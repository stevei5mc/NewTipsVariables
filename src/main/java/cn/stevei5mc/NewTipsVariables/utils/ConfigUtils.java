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
        if (ccvl > csvl) {
            Main.getInstance().getLogger().warning("§econfig.yml 版本不是最新版");
        } else if (ccvl < csvl) {
            Main.getInstance().getLogger().error("§cconfig.yml 版本出现了错误");
        } else {
            Main.getInstance().getLogger().info("§aconfig.yml 版本是最新版");
        }
        if (cpvl > cpvt) {
            Main.getInstance().getLogger().warning("§eplayer.yml 版本不是最新版");
        } else if (cpvl < cpvt) {
            Main.getInstance().getLogger().error("§cplayer.yml 版本出现了错误");
        } else {
            Main.getInstance().getLogger().info("§aplayer.yml 版本是最新版");
        }
        if (csvt > csvt) {
            Main.getInstance().getLogger().warning("§eserver.yml 版本不是最新版");
        } else if (csvt < csvt) {
            Main.getInstance().getLogger().error("§cserver.yml 版本出现了错误");
        } else {
            Main.getInstance().getLogger().info("§aserver.yml 版本是最新版");
        }
    }
}