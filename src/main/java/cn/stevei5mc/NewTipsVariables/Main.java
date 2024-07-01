package cn.stevei5mc.NewTipsVariables;

import cn.nukkit.plugin.PluginBase;
import tip.utils.Api;
import cn.stevei5mc.NewTipsVariables.variables.BaseVariables;
import cn.stevei5mc.NewTipsVariables.variables.LoadSupportPlugins;
import cn.nukkit.Player;
import cn.nukkit.utils.Config;
import cn.stevei5mc.NewTipsVariables.command.NewTipsVariablesCommand;
import cn.stevei5mc.NewTipsVariables.utils.ConfigUtils;
import cn.nukkit.Server;

public class Main extends PluginBase {
    public static String debugPrefix = "§7[§cDEBUG§7] ";
    public static String updataPrefix = "§7[§cUPDATA§7] ";
    public static Player player;
    private static Main instance;
    private Config config;
    private Config configInServer;
    private Config configInPlayer;
    private Config worldName;
    private Config language;
    public static boolean debug = false;

    public static Main getInstance() {
        return instance;
    }

    public void onLoad() {
        instance = this;
        this.loadConfigRes();//加载配置文件
        this.loadVarRes();//加载变量文档
        if (config.getBoolean("updata.in-config.check")) {//从config.yml中获取updata.in-config.check为true则执行相关内容
            ConfigUtils.checkVersion();
        }
    }

    public void onEnable() {
        //判断需要的前置插件是否存在
        if (this.getServer().getPluginManager().getPlugin("Tips") != null) {
            //存在则加载该插件
            this.getServer().getCommandMap().register("", new NewTipsVariablesCommand());//注册命令
            this.tipsvariables();//加载变量部分
            this.getLogger().info("§a变量加载完成");
            Server.getInstance().getScheduler().scheduleDelayedTask(this, () -> {
                ConfigUtils.reloadConfig();
                this.getLogger().warning("§c警告! §c本插件为免费且开源的一款插件，如果你是付费获取到的那么你就被骗了");
                this.getLogger().info("§a开源链接和使用方法: §bhttps://github.com/stevei5mc/NewTipsVariables");
            },20);
        } else {
            //不存在作为卸载该插件
            this.getLogger().warning("§c未检测到前置插件§aTips§c，请安装§aTips§c再试!!!");
            this.getLogger().warning("§b下载地址: §ehttps://motci.cn/job/Tips/");
            this.onDisable();
        }
    }

    public void onDisable() {
        this.getLogger().info("已停止运行，感谢你的使用");
    }

    public void loadConfigRes() {
        this.getDataFolder().mkdirs();
        this.saveDefaultConfig();
        this.saveResource("server.yml",false);
        this.saveResource("player.yml",false);
        this.saveResource("world_name.yml",false);
        this.saveResource("language.yml",false);
        this.config = new Config(this.getDataFolder() + "/config.yml", Config.YAML);
        this.configInServer = new Config(this.getDataFolder() + "/server.yml", Config.YAML);
        this.configInPlayer = new Config(this.getDataFolder() + "/player.yml", Config.YAML);
        this.worldName = new Config(this.getDataFolder() + "/world_name.yml", Config.YAML);
        this.language = new Config(this.getDataFolder() + "/language.yml", Config.YAML);
        debug = false; //这个防止出现关闭debug功能reload配置文件后还需要重启服务器的问题
        if (config.getBoolean("debug", false)) {//从config.yml中获取debug为true则执行相关内容，如果无法获取则为false
            debug = true;
            this.getLogger().warning(debugPrefix + "§cdebug模式已开启");
        }
    }

    public void loadVarRes() {
        if (config.getBoolean("save-variables-doc")) {//获取配置为true时就每次都加载最新的变量文档，为false则不会更新就算把变量文档删除了也不会更新
            this.saveResource("base-variables.txt",true);
            this.saveResource("SupportPluginsVariables.txt",true);
            this.getLogger().info("§a变量说明文件加载成功");
        }
    }

    public void tipsvariables() {
        Api.registerVariables("BaseVariables", BaseVariables.class);
        LoadSupportPlugins.loadSupportVariables(player);
    }
    
    //这些都是用在非主类获取配置文件信息用的
    public Config getConfig() {
        return this.config;
    }
    public Config getConfigInServer() {
        return this.configInServer;
    }
    public Config getConfigInPlayer() {
        return this.configInPlayer;
    }
    public Config getWorldName() {
        return this.worldName;
    }
    public Config getLanguage() {
        return this.language;
    }

    //重载配置
    public void reload() {
        loadConfigRes();
    }
}