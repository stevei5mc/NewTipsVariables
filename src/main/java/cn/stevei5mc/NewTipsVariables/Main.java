package cn.stevei5mc.NewTipsVariables;

import cn.nukkit.Server;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.stevei5mc.NewTipsVariables.command.NewTipsVariablesCommand;
import cn.stevei5mc.NewTipsVariables.utils.ConfigUtils;
import cn.stevei5mc.NewTipsVariables.utils.LoadVariables;
import cn.stevei5mc.NewTipsVariables.variables.BaseVariables;
import lombok.Getter;
import tip.utils.Api;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;

public class Main extends PluginBase {
    public static String debugPrefix = "§7[§cDEBUG§7] ";
    public static String updataPrefix = "§7[§cUPDATE§7] ";
    private static Main instance;
    private Config config;
    @Getter
    private Config configInServer;
    @Getter
    private Config configInPlayer;
    @Getter
    private Config worldName;
    @Getter
    private Config language;
    public static boolean debug = false;

    public static Main getInstance() {
        return instance;
    }

    public void onLoad() {
        instance = this;
        this.loadConfigRes();//加载配置文件
        this.saveConfig();
        this.loadVarRes();//加载变量文档
        ConfigUtils.updateDefaultConfig();
        ConfigUtils.updateServerConfig();
        ConfigUtils.updatePlayerConfig();
    }

    public void onEnable() {
        //判断需要的前置插件是否存在
        try{
            Class.forName("tip.utils.variables.BaseVariable");
            deleteUnicodeVariables();
            //存在则加载该插件
            this.getServer().getCommandMap().register("", new NewTipsVariablesCommand());//注册命令
            this.tipsVariables();//加载变量部分
            this.getLogger().info("§a变量加载完成");
            Server.getInstance().getScheduler().scheduleDelayedTask(this, () -> {
                ConfigUtils.reloadConfig();
                this.getLogger().warning("§c警告! §c本插件为免费且开源的，如果您付费获取获取的，则有可能被误导");
                this.getLogger().info("§a开源链接和使用方法: §bhttps://github.com/stevei5mc/NewTipsVariables");
            },20);
        }catch (Exception ignore) {
            //不存在作为卸载该插件
            this.getLogger().warning("§c未检测到前置插件§aTips§c，请安装§aTips§c再试!!!");
            this.getLogger().warning("§b下载地址: §ehttps://motci.cn/job/GameCore/ 或 https://ci.lanink.cn/job/GameCore/");
            this.onDisable();
        }
    }

    public void onDisable() {
        this.getLogger().info("已停止运行，感谢你的使用");
    }

    public void saveConfig() {
        this.getDataFolder().mkdirs();
        this.saveDefaultConfig();
        this.saveResource("server.yml",false);
        this.saveResource("player.yml",false);
        this.saveResource("world_name.yml",false);
        this.saveResource("language.yml",false);
    }

    public void loadConfigRes() {
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

    public void tipsVariables() {
        Api.registerVariables("BaseVariables", BaseVariables.class);
        LoadVariables.pluginVariables();
    }

    //重载配置
    public void reload() {
        loadConfigRes();
    }

    private void deleteUnicodeVariables() {
        try {
            Class.forName("cn.stevei5mc.UnicodeVariables.main");
            Plugin plugin = this.getServer().getPluginManager().getPlugin("UnicodeVariables");
            File file = null;
            ClassLoader pluginClass = plugin.getClass().getClassLoader();
            try {
                if (pluginClass instanceof URLClassLoader) {
                    URLClassLoader pluginClassL = (URLClassLoader) pluginClass;
                    URL url = pluginClassL.getURLs()[0];
                    file = new File(URLDecoder.decode(url.getFile(), "UTF-8"));
                }
            }catch (Exception ignore) {}
            if (file != null) {
                plugin.onDisable();
                try {
                    ((URLClassLoader) pluginClass).close();
                }catch (Exception ignore) {}
                file.delete();
            }
            getLogger().warning("§c插件UnicodeVariables的功能已合并到本插件，插件UnicodeVariables不再维护！！！");
            getLogger().warning("§cUnicodeVariables将会自动删除，如果无法自动删除请将其手动删除！！！");
        }catch (Exception ignore) {}
    }
}