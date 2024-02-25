package cn.stevei5mc.NewTipsVariables;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import tip.utils.Api;
import cn.stevei5mc.NewTipsVariables.variables.tipsText;
import cn.stevei5mc.NewTipsVariables.variables.tipsServer;
import cn.stevei5mc.NewTipsVariables.variables.tipsPlayer;
import cn.stevei5mc.NewTipsVariables.variables.tipsPlayerConfig;
import cn.stevei5mc.NewTipsVariables.variables.tipsServerConfig;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.loadSupportPlugins;
import cn.nukkit.Player;
import cn.nukkit.utils.Config;

public class Main extends PluginBase {
    public static Player player;
    private static Main instance;
    private static Config config;
    private static Config configInServer;
    private static Config configInPlayer;
    private static Config worldName;
    public static Main getInstance() {
        return instance;
    }
    
    public void onLoad() {
        instance = this;
        this.loadConfigRes();//加载配置文件
        this.loadVarRes();//加载变量文档
    }
    
    public void onEnable() {
        //判断需要的前置插件是否存在
        if (this.getServer().getPluginManager().getPlugin("Tips") != null) {
            //存在则加载该插件
            this.deBugMode();//用于加载debug信息
            this.tipsvariables();//加载变量部分
            this.loadover();//加载完成显示的内容
        } else {
            //不存在作为卸载该插件
            this.getLogger().warning("§c未检测到前置插件§aTips§c，请安装§aTips§c再试!!!");
            this.getLogger().warning("§b下载地址: §ehttps://ci.lanink.cn/job/Tips/");
            this.onDisable();
        }
    }

    public void onDisable() {
        this.getLogger().info("停止运行");
        this.getLogger().info("§6感谢你的使用");
    }

    public void loadConfigRes() {
        this.getDataFolder().mkdirs(); //创建插件文件夹
        this.saveDefaultConfig();
        this.saveResource("server.yml",false);
        this.saveResource("player.yml",false);
        this.saveResource("world_name.yml",false);
        this.config = new Config(this.getDataFolder() + "/config.yml", Config.YAML);
        this.configInServer = new Config(this.getDataFolder() + "/server.yml", Config.YAML);
        this.configInPlayer = new Config(this.getDataFolder() + "/player.yml", Config.YAML);
        this.worldName = new Config(this.getDataFolder() + "/world_name.yml", Config.YAML);
    }

    public void loadVarRes() {
        boolean saveVariablesDoc = this.config.getBoolean("save-variables-doc");
        if (saveVariablesDoc) {
            //为true时就每次都加载最新的变量信息
            this.saveResource("base-variables.txt",true);
            this.saveResource("SupportPluginsVariables.txt",true);
            this.getLogger().info("§a变量说明文件加载成功");
        }
    }

    public void deBugMode() {
        boolean deBug = this.config.getBoolean("debug", false); //这个功能默认关闭,不在配置文件中,需手动加上
        if (deBug) {
            String debugPerfix = "§7[§cDEBUG§7] ";
            this.getLogger().warning(debugPerfix + "§cdebug模式已开启");
            int configVersionLatest = 1;
            int configInServerVersionLatest = 1;
            int configInPlayerVersionLatest = 1;
            int configVersion = this.config.getInt("version");
            int configInServerVersion = this.configInServer.getInt("version");
            int configInPlayerVersion = this.configInPlayer.getInt("version");
            this.getLogger().info(debugPerfix + "§bconfig.yml§e 当前版本§a " + configVersion + " §e最新版本§a " + configVersionLatest);
            this.getLogger().info(debugPerfix + "§bserver.yml§e 当前版本§a " + configInServerVersion + " §e最新版本§a " + configInServerVersionLatest);
            this.getLogger().info(debugPerfix + "§bplayer.yml§e 当前版本§a " + configInPlayerVersion + " §e最新版本§a " + configInPlayerVersionLatest);
        }
    }

    public void tipsvariables() {
        Api.registerVariables("tipsText", tipsText.class);
        Api.registerVariables("tipsServer", tipsServer.class);
        Api.registerVariables("tipsPlayer", tipsPlayer.class);
        Api.registerVariables("tipsPlayerConfig", tipsPlayerConfig.class);
        Api.registerVariables("tipsServerConfig", tipsServerConfig.class);
        loadSupportPlugins.loadSupportVariables(player);
    }

    public void loadover() {
        this.getLogger().info("§a变量加载完成");
        this.getLogger().warning("§c警告:");
        this.getLogger().warning("§c本插件为免费且开源的一款插件，如果你是付费获取到的那么你就被骗了");
        this.getLogger().info("§a开源链接和使用方法: §bhttps://github.com/stevei5mc/NewTipsVariables");
    }
    
    @Override
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
}