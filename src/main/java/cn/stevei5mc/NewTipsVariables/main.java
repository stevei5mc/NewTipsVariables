package cn.stevei5mc.NewTipsVariables;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import tip.utils.Api;
import cn.stevei5mc.NewTipsVariables.variables.tipstext;
import cn.stevei5mc.NewTipsVariables.variables.tipsserver;
import cn.stevei5mc.NewTipsVariables.variables.tipsplayer;

public class main extends PluginBase {
    public void onEnable() {
        this.loadresource();
        if (this.getServer().getPluginManager().getPlugin("Tips") != null) {
            this.tipsvariables();
            this.loadover();
        } else {
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
        this.getLogger().info("变量说明文件生成成功");
    }

    public void tipsvariables() {
        Api.registerVariables("tipstext", tipstext.class);
        Api.registerVariables("tipsserver", tipsserver.class);
        Api.registerVariables("tipsplayer", tipsplayer.class);
    }

    public void loadover() {
        this.getLogger().info("加载成功");
        this.getLogger().warning("§c警告:");
        this.getLogger().warning("§c本插件为免费且开源的一款插件，如果你是付费获取到的那么你就被骗了");
        this.getLogger().info("§a开源链接和使用方法: §bhttps://github.com/stevei5mc/NewTipsVariables");
    }    
}