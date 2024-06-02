package cn.stevei5mc.NewTipsVariables.utils;

import cn.stevei5mc.NewTipsVariables.Main;
import cn.nukkit.Server;

public class ConfigUtils {
    //定义配置文件的最新版本号
    public static int ccvl = 1; //config.yml
    public static int cpvl = 1; //player.yml
    public static int csvl = 1; //server.yml

    public static void checkVersion() {
        //获取配置文件当前的版本号
        int ccvt = Main.getInstance().getConfig().getInt("version",0); //config.yml
        int cpvt = Main.getInstance().getConfigInPlayer().getInt("version",0); //player.yml
        int csvt = Main.getInstance().getConfigInServer().getInt("version",0); //server.yml
        runCheck("config.yml", ccvl, ccvt);
        runCheck("player.yml", cpvl, cpvt);
        runCheck("server.yml", csvl, csvt);

    }  

    public static void runCheck(String name, int latestVersion, int currentVersion) {
        String current = String.valueOf(currentVersion);
        if (currentVersion == 0) {
            currentVersion = 114514;//防止有人误把配置文件中的version配置项，如果无法获取数据则输入一个最大数
            current = "null";
        }
        if (Main.debug) {
            String msg = Main.debugPrefix + "{0} 当前版本: {1} 最新版本：{2}";
            Main.getInstance().getLogger().info(msg.replace("{0}",name).replace("{1}",current).replace("{2}",String.valueOf(latestVersion)));//这个到时候再搞
        }
        if (currentVersion == latestVersion) {
            Main.getInstance().getLogger().info(name + " §a版本是最新版");
        } else if (currentVersion < latestVersion) {
            Main.getInstance().getLogger().warning(name + " §e版本不是最新版, 请及时更新配置文件，如果开启自动更新可以无视该消息");
            runUpdata(name);
        } else {
            Main.getInstance().getLogger().error(name + " §c版本出现了错误，需要修复配置文件，如果开启自动更新可以无视该消息");
            runUpdata(name);
        }
    }

    private static void runUpdata(String name) {
        if (Main.getInstance().getConfig().getBoolean("updata.in-config.auto")) {
            Main.getInstance().saveResource(name,true);
            Main.getInstance().getLogger().info(Main.updataPrefix + name + " §a更新成功");
        }
    }
}