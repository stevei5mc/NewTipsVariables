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
            int version = config.getInt("version", 1);
            config.set("version", ConfigInfoEnum.SERVER_VAR_INFO_CONFIG.getLatestVersion());
//            config.remove("TPS");
            if (version < 2) {
                if (!config.exists("TPS.color")) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("low", config.getString("TPS.low_color",  "§c"));
                    map.put("medium", config.getString("TPS.medium_color", "§e"));
                    map.put("high", config.getString("TPS.high_color", "§a"));
                    config.getSection("TPS").remove("low_color");
                    config.getSection("TPS").remove("medium_color");
                    config.getSection("TPS").remove("high_color");
                    config.set("TPS.color", map);
                }
                if (!config.exists("TPS.value")) {
                    HashMap<String, Integer> map2 = new HashMap<>();
                    map2.put("medium", config.getInt("TPS.medium_value", 9));
                    map2.put("high", config.getInt("TPS.high_value", 15));
                    config.getSection("TPS").remove("medium_value");
                    config.getSection("TPS").remove("high_value");
                    config.set("TPS.value", map2);
                }
            }
            config.save();
        }
    }

    private static void updatePlayerConfig() {
        Config config = main.getConfigInPlayer();
        if(checkVersion(config, ConfigInfoEnum.PLAYER_VAR_INFO_CONFIG).equals(ConfigCheckState.NEED_UPDATE)) {
            int version = config.getInt("version", 1);
            config.set("version", ConfigInfoEnum.PLAYER_VAR_INFO_CONFIG.getLatestVersion());
            if (version < 2) {
                if (!config.exists("ping.color")) {
                    HashMap<String, String> pingColor = new HashMap<>();
                    pingColor.put("low", config.getString("ping.low_color",  "§c"));
                    pingColor.put("medium", config.getString("ping.medium_color", "§e"));
                    pingColor.put("high", config.getString("ping.high_color", "§a"));
                    config.set("ping.color", pingColor);
                    config.getSection("ping").remove("low_color");
                    config.getSection("ping").remove("medium_color");
                    config.getSection("ping").remove("high_color");
                }
                if (!config.exists("ping.value")) {
                    HashMap<String, Integer> pingValue = new HashMap<>();
                    pingValue.put("medium", config.getInt("ping.high_value", 80));
                    pingValue.put("high", config.getInt("ping.high_value", 120));
                    config.set("ping.value", pingValue);
                    config.getSection("ping").remove("high_value");
                    config.getSection("ping").remove("medium_value");
                }
                if (!config.exists("Food.color")) {
                    HashMap<String, String> foodColor = new HashMap<>();
                    foodColor.put("empty", config.getString("Food.empty_color", "§7{0}/{1}"));
                    foodColor.put("low", config.getString("Food.low_color", "§c{0}§7/§c{1}"));
                    foodColor.put("medium", config.getString("Food.medium_color", "§e{0}§7/§e{1}"));
                    foodColor.put("high", config.getString("Food.high_color", "§a{0}§7/§a{1}"));
                    config.set("Food.color", foodColor);
                    config.getSection("Food").remove("empty_color");
                    config.getSection("Food").remove("low_color");
                    config.getSection("Food").remove("medium_color");
                    config.getSection("Food").remove("high_color");
                }
                if (!config.exists("Food.value")) {
                    HashMap<String, Integer> foodValue = new HashMap<>();
                    foodValue.put("medium", config.getInt("Food.medium_value", 9));
                    foodValue.put("high", config.getInt("Food.high_value", 15));
                    config.set("Food.value", foodValue);
                    config.getSection("Food").remove("medium_value");
                    config.getSection("Food").remove("high_value");
                }
                if (!config.exists("HP.value")) {
                    HashMap<String, Integer> hpValue = new HashMap<>();
                    hpValue.put("medium", config.getInt("HP.medium_value", 9));
                    hpValue.put("high", config.getInt("HP.high_value", 15));
                    config.set("HP.value", hpValue);
                    config.getSection("HP").remove("high_value");
                    config.getSection("HP").remove("medium_value");
                }
                if (!config.exists("HP.color")) {
                    HashMap<String, String> hpColor = new HashMap<>();
                    hpColor.put("low", "§c");
                    hpColor.put("medium", "§e");
                    hpColor.put("high", "§a");
                    config.set("HP.color", hpColor);
                }
                if (!config.exists("HP.dynamic")) {
                    HashMap<String, String> hpDynamic = new HashMap<>();
                    hpDynamic.put("low", config.getString("HP.low_color", "§c{0}§7/§c{1}"));
                    hpDynamic.put("medium", config.getString("HP.medium_color", "§e{0}§7/§e{1}"));
                    hpDynamic.put("high", config.getString("HP.high_color", "§a{0}§7/§a{1}"));
                    config.set("HP.dynamic", hpDynamic);
                    config.getSection("HP").remove("low_color");
                    config.getSection("HP").remove("medium_color");
                    config.getSection("HP").remove("high_color");
                }
            }
            config.save();
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