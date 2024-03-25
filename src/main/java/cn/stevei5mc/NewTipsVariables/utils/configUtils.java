package cn.stevei5mc.NewTipsVariables.utils;

import cn.stevei5mc.NewTipsVariables.Main;

public class configUtils {
    public static void configUtils() {
        int cv1 = Main.getInstance().getConfig().getInt("version");
        int cv2 = Main.getInstance().getConfigInPlayer().getInt("version");
        int cv3 = Main.getInstance().getConfigInServer().getInt("version");
        boolean checkConfig = Main.getInstance().getConfig().getBoolean("updata.in-config.check");
        if (checkConfig) {
            if (Main.config1Version > cv1) {
                Main.getInstance().getLogger().warning("§econfig.yml 版本不是最新版");
            } else if (Main.config1Version < cv1) {
                Main.getInstance().getLogger().error("§cconfig.yml 版本出现了错误");
            } else {
                Main.getInstance().getLogger().info("§aconfig.yml 版本是最新版");
            }
            
            if (Main.config2Version > cv2) {
                Main.getInstance().getLogger().warning("§eplayer.yml 版本不是最新版");
            } else if (Main.config2Version < cv2) {
                Main.getInstance().getLogger().error("§cplayer.yml 版本出现了错误");
            } else {
                Main.getInstance().getLogger().info("§aplayer.yml 版本是最新版");
            }

            if (Main.config3Version > cv3) {
                Main.getInstance().getLogger().warning("§eserver.yml 版本不是最新版");
            } else if (Main.config3Version < cv3) {
                Main.getInstance().getLogger().error("§cserver.yml 版本出现了错误");
            } else {
                Main.getInstance().getLogger().info("§aserver.yml 版本是最新版");
            }
        }
    }
}