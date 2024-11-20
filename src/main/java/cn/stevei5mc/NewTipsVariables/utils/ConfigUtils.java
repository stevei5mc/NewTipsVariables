package cn.stevei5mc.NewTipsVariables.utils;

import cn.nukkit.utils.Config;
import cn.stevei5mc.NewTipsVariables.Main;

import java.io.File;
import java.util.HashMap;

public class ConfigUtils {
    private static Main main = Main.getInstance();
    private static boolean reload = false;
    //定义配置文件的最新版本号
    private static final int latestConfigVersion = 2; //config.yml
    private static final int latestPlayerConfigVersion = 1; //player.yml
    private static final int latestServerConfigVersion = 1; //server.yml
    private static final String configVersionError = "§c配置文件 {1} 版本出现异常，将对其进行重置";
    private static final String configVersionNotLatest = "Se检测到配置文件 {1} 不是最新的版本，将对其进行更新";
    private static final String configIsLatestVersion = "配置文件 {1} 是最新版本";

    public static void updateDefaultConfig() {
        Config config = main.getConfig();
        int latest = latestConfigVersion;
        if (config.getInt("version",1) == latest){
            main.getLogger().info(configIsLatestVersion.replace("{1}","config.yml"));
        }else if(config.getInt("version",1) < latest) {
            main.getLogger().warning(configVersionNotLatest.replace("{1}","config.yml"));
            reload = true;
            if (config.getInt("version",1) < 2) {
                config.set("version",2);
                if (config.exists("updata")) {
                    config.remove("updata");
                }
                if (!config.exists("update-plugin")) {
                    HashMap<String, Boolean> map = new HashMap<>();
                    map.put("check", false);
                    map.put("auto",false);
                    config.set("update-plugin",map);
                }
                config.save();
            }
        }else {
            reload = true;
            main.getLogger().error(configVersionError.replace("{1}","config.yml"));
            config.save(new File(main.getDataFolder() + "/config.yml.bak"));
            main.saveResource("config.yml",true);
        }
    }

    public static void updateServerConfig() {
        Config config = main.getConfigInServer();
        if (config.getInt("version",1) == latestServerConfigVersion){
            main.getLogger().info(configIsLatestVersion.replace("{1}","server.yml"));
        }else if(config.getInt("version",1) < latestServerConfigVersion) {
            main.getLogger().warning(configVersionNotLatest.replace("{1}","server.yml"));
        }else {
            reload = true;
            main.getLogger().error(configVersionError.replace("{1}","server.yml"));
            config.save(new File(main.getDataFolder() + "/server.yml.bak"));
            main.saveResource("server.yml",true);
        }
    }

    public static void updatePlayerConfig() {
        Config config = main.getConfigInPlayer();
        if (config.getInt("version",1) == latestPlayerConfigVersion){
            main.getLogger().info(configIsLatestVersion.replace("{1}","player.yml"));
        }else if(config.getInt("version",1) < latestPlayerConfigVersion) {
            main.getLogger().warning(configVersionNotLatest.replace("{1}","player.yml"));
            reload = true;
        }else {
            reload = true;
            main.getLogger().error(configVersionError.replace("{1}","player.yml"));
            config.save(new File(main.getDataFolder() + "/player.yml.bak"));
            main.saveResource("player.yml",true);
        }
    }

    public static void reloadConfig() {
        if (reload) {
            main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "NewTipsVariables reload");
            reload = false;
        }
    }
}