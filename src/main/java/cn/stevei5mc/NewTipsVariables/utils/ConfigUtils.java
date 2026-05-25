package cn.stevei5mc.NewTipsVariables.utils;

import cn.nukkit.utils.Config;
import cn.stevei5mc.NewTipsVariables.Main;
import cn.stevei5mc.NewTipsVariables.utils.enums.ConfigInfoEnum;

import java.io.File;
import java.util.HashMap;

public class ConfigUtils {
    private static final Main main = Main.getInstance();
    private static boolean reload = false;
    private static final String configVersionNotLatest = "Se检测到配置文件 %s 不是最新的版本，将对其进行更新";
    private static final String configIsLatestVersion = "配置文件 %s 是最新版本";

    public static void updateConfig() {
        updateDefaultConfig();
        updateServerConfig();
        updatePlayerConfig();
    }

    private static void updateDefaultConfig() {
        Config config = main.getConfig();
        int latestVersion = ConfigInfoEnum.DEFAULT_CONFIG.getLatestVersion();
        if (config.getInt("version",1) == latestVersion){
            main.getLogger().info(String.format(configIsLatestVersion, "config.yml"));
        }else if(config.getInt("version",1) < latestVersion) {
            main.getLogger().warning(String.format(configVersionNotLatest, "config.yml"));
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
            reload = resetConfig(config, ConfigInfoEnum.DEFAULT_CONFIG);
        }
    }

    private static void updateServerConfig() {
        Config config = main.getConfigInServer();
        int latestVersion = ConfigInfoEnum.SERVER_VAR_INFO_CONFIG.getLatestVersion();
        if (config.getInt("version", 1) == latestVersion){
            main.getLogger().info(String.format(configIsLatestVersion, "server.yml"));
        }else if(config.getInt("version", 1) < latestVersion) {
            main.getLogger().warning(String.format(configVersionNotLatest, "server.yml"));
        }else {
            reload = resetConfig(config, ConfigInfoEnum.SERVER_VAR_INFO_CONFIG);
        }
    }

    private static void updatePlayerConfig() {
        Config config = main.getConfigInPlayer();
        int latestVersion = ConfigInfoEnum.PLAYER_VAR_INFO_CONFIG.getLatestVersion();
        if (config.getInt("version", 1) == latestVersion){
            main.getLogger().info(String.format(configIsLatestVersion, "player.yml"));
        }else if(config.getInt("version", 1) < latestVersion) {
            main.getLogger().warning(String.format(configVersionNotLatest, "player.yml"));
            reload = true;
        }else {
            reload = resetConfig(config, ConfigInfoEnum.PLAYER_VAR_INFO_CONFIG);
        }
    }

    private static boolean resetConfig(Config config, ConfigInfoEnum configInfo) {
        main.getLogger().error(String.format("§c配置文件 %s 版本出现异常，将对其进行重置", configInfo.getName()));
        config.save(new File(main.getDataFolder() + configInfo.getPath() + ".backup"));
        main.saveResource(configInfo.getName(),true);
        return true;
    }

    public static void reloadConfig() {
        if (reload) {
            main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "NewTipsVariables reload");
            reload = false;
        }
    }
}