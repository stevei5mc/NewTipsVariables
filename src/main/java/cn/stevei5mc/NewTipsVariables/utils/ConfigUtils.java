package cn.stevei5mc.NewTipsVariables.utils;

import cn.nukkit.utils.Config;
import cn.stevei5mc.NewTipsVariables.Main;
import cn.stevei5mc.NewTipsVariables.utils.enums.ConfigInfoEnum;

import java.io.File;
import java.util.HashMap;

public class ConfigUtils {
    private static final Main main = Main.getInstance();
    private static boolean reload = false;

    public static void updateConfig() {
        reload = false;
        updateDefaultConfig();
        updateServerConfig();
        updatePlayerConfig();
    }

    private static void updateDefaultConfig() {
        Config config = main.getConfig();
        if(checkVersion(config, ConfigInfoEnum.DEFAULT_CONFIG).equals(ConfigCheckState.NEED_UPDATE)) {
            if (config.getInt("version", 1) < 2) {
                config.set("version", 2);
                if (config.exists("updata")) {
                    config.remove("updata");
                }
                if (!config.exists("update-plugin")) {
                    HashMap<String, Boolean> map = new HashMap<>();
                    map.put("check", false);
                    map.put("auto", false);
                    config.set("update-plugin", map);
                }
                config.save();
            }
        }
    }

    private static void updateServerConfig() {
        Config config = main.getConfigInServer();
        if(checkVersion(config, ConfigInfoEnum.SERVER_VAR_INFO_CONFIG).equals(ConfigCheckState.NEED_UPDATE)) {
            main.getLogger().warning("hello world");
        }
    }

    private static void updatePlayerConfig() {
        Config config = main.getConfigInPlayer();
        if(checkVersion(config, ConfigInfoEnum.PLAYER_VAR_INFO_CONFIG).equals(ConfigCheckState.NEED_UPDATE)) {
            main.getLogger().warning("hello world");
        }
    }

    private static ConfigCheckState checkVersion(Config config, ConfigInfoEnum configInfo) {
        int currentVersion = config.getInt("version", 1);
        if (currentVersion == configInfo.getLatestVersion()) {
            main.getLogger().info(String.format("配置文件 %s 是最新版本", configInfo.getName()));
            return ConfigCheckState.NEED_NOT;
        }else if (currentVersion < configInfo.getLatestVersion()) {
            main.getLogger().warning(String.format("Se检测到配置文件 %s 不是最新的版本，将对其进行更新", configInfo.getName()));
            reload = true;
            return ConfigCheckState.NEED_UPDATE;
        }else {
            reload = resetConfig(config, configInfo);
            return ConfigCheckState.NEED_RESET;
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

    public enum ConfigCheckState {
        NEED_NOT, NEED_UPDATE, NEED_RESET
    }
}