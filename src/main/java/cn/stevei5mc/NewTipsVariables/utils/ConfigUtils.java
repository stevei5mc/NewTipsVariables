package cn.stevei5mc.NewTipsVariables.utils;

import cn.stevei5mc.NewTipsVariables.Main;

public class ConfigUtils {
    //定义配置文件的最新版本号
    public static int ccvl = 1; //config.yml
    public static int cpvl = 1; //player.yml
    public static int csvl = 1; //server.yml
    //获取配置文件当前的版本号
    public static int ccvt = Main.getInstance().getConfig().getInt("version"); //config.yml
    public static int cpvt = Main.getInstance().getConfigInPlayer().getInt("version"); //player.yml
    public static int csvt = Main.getInstance().getConfigInServer().getInt("version"); //server.yml

    public static void checkVersion() {
        runCheck("config.yml", ccvl, ccvt);
        runCheck("player.yml", cpvl, cpvt);
        runCheck("server.yml", csvl, csvt);
    }  

    public static void runCheck(String name, int latestVersion, int currentVersion) {
        Main.getInstance().getLogger().info(name + " §aversion: "+ currentVersion);
        if (currentVersion == 0) {
            currentVersion = 114514;//防止有人误把配置文件中的version配置项，如果无法获取数据则输入一个最大数
        }
        if (currentVersion == latestVersion) {
            Main.getInstance().getLogger().info(name + " §a版本是最新版");
        } else if (currentVersion < latestVersion) {
            Main.getInstance().getLogger().warning(name + " §e版本不是最新版, 请及时更新配置文件");
        } else {
            Main.getInstance().getLogger().error(name + " §c版本出现了错误，需要修复配置文件");
        }
    }
}