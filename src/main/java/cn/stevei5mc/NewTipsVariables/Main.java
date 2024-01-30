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

public class Main extends PluginBase {
    public static Player player;

    public void onEnable() {
        this.loadresource();//先把资源文件给加载了
        //判断需要的前置插件是否存在
        if (this.getServer().getPluginManager().getPlugin("Tips") != null) {
            //存在则加载该插件
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

    public void loadresource() {
        this.getDataFolder().mkdirs(); //创建插件文件夹
        //每次都加载最新的变量信息
        this.saveResource("text-variables.txt","/text-variables.txt",true);
        this.saveResource("server-variables.txt","/server-variables.txt",true);
        this.saveResource("player-variables.txt","/player-variables.txt",true);
        this.getLogger().info("§a变量说明文件加载成功");
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
}