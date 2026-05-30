package cn.stevei5mc.NewTipsVariables.utils.variables;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;
import cn.stevei5mc.NewTipsVariables.Main;
import cn.stevei5mc.NewTipsVariables.utils.PluginsListEnum;
import cn.stevei5mc.NewTipsVariables.utils.PluginsState;
import healthapi.PlayerHealth;

public class GetPlayerVarInfo {

    private static final Main main = Main.getInstance();

    /**
     * 获取玩家的延迟
     * @return 玩家的延迟
     */
    public static String getPlayerPing(Player player) {
        int pingValue = player.getPing();
        String color = main.getConfigInPlayer().getString("ping.color.low");
        if (pingValue >= main.getConfigInPlayer().getInt("ping.value.high")) {
            color = main.getConfigInPlayer().getString("ping.color.medium");
        }else if (pingValue >= main.getConfigInPlayer().getInt("ping.value.medium")) {
            color = main.getConfigInPlayer().getString("ping.color.medium");
        }
        return color + pingValue;
    }

    public static String getPlayerHealth(Player player) {
        double currentHealth;
        double maxHealth;
        if (PluginsState.getPluginState(PluginsListEnum.HEALTH_API.getName())) {
            PlayerHealth health = PlayerHealth.getPlayerHealth(player);
            currentHealth = health.getHealth();
            maxHealth = health.getMaxHealth();
        } else {
            currentHealth = player.getHealth();
            maxHealth = player.getMaxHealth();
        }

        String color = main.getConfigInPlayer().getString("HP.dynamic.low"); // 默认低血量颜色
        if (currentHealth >= main.getConfigInPlayer().getInt("HP.value.high")) {
            color = main.getConfigInPlayer().getString("HP.dynamic.high");
        } else if (currentHealth >= main.getConfigInPlayer().getInt("HP.value.medium")) {
            color = main.getConfigInPlayer().getString("HP.dynamic.medium");
        }

        return color.replace("{0}", String.valueOf(currentHealth)).replace("{1}", String.valueOf(maxHealth));
    }

    public static String getPlayerCurrentHp(Player player) {
        double currentHp = PluginsState.getPluginState(PluginsListEnum.HEALTH_API.getName()) ? PlayerHealth.getPlayerHealth(player).getHealth() : player.getHealth();
        String color = main.getConfigInPlayer().getString("HP.color.low"); // 默认低血量颜色
        if (currentHp >= main.getConfigInPlayer().getInt("HP.value.high")) {
            color = main.getConfigInPlayer().getString("HP.color.high");
        } else if (currentHp >= main.getConfigInPlayer().getInt("HP.value.medium")) {
            color = main.getConfigInPlayer().getString("HP.color.medium");
        }

        return color + currentHp;
    }

    public static String getPlayerMaxHp(Player player) {
        return String.valueOf(PluginsState.getPluginState(PluginsListEnum.HEALTH_API.getName()) ? PlayerHealth.getPlayerHealth(player).getHealth() : player.getHealth());
    }

    /**
     * 获取玩家的饱食度状态
     * @return 玩家的饱食度状态
     */
    public static String getPlayerFood(Player player) {
        float foodValue = player.getFoodData().getLevel();
        String color = main.getConfigInPlayer().getString("Food.color.empty");
        if (foodValue >= main.getConfigInPlayer().getInt("Food.value.high")) {
            color = main.getConfigInPlayer().getString("Food.color.high");
        }else if (foodValue >= main.getConfigInPlayer().getInt("Food.value.medium")) {
            color = main.getConfigInPlayer().getString("Food.color.medium");
        }else if (foodValue >= 1) {
            color = main.getConfigInPlayer().getString("Food.color.low");
        }
        return color.replace("{0}", String.valueOf(foodValue)).replace("{1}", String.valueOf(player.getFoodData().getMaxLevel()));
    }

    /**
     * 获取玩家的UI Profile
     * @return 玩家的UI Profile
     */
    public static String getPlayerUi(Player player) {
        switch (player.getLoginChainData().getUIProfile()) {
            case 0: return main.getConfigInPlayer().getString("Device.UIProfile.classic");
            case 1: return main.getConfigInPlayer().getString("Device.UIProfile.pocket");
            default: return main.getLanguage().getString("Unknown_Device_UIProfile");
        }
    }

    /**
     * 获取玩家的操作方式
     * @return 玩家的操作方式
     */
    public static String getDeviceControls(Player player) {
        switch (player.getLoginChainData().getCurrentInputMode()) {
            case 1: return main.getConfigInPlayer().getString("Device.Controls.Keyboard");
            case 2: return main.getConfigInPlayer().getString("Device.Controls.Touch");
            case 3: return main.getConfigInPlayer().getString("Device.Controls.pad");
            case 4: return main.getConfigInPlayer().getString("Device.Controls.motion_controller");
            default: return main.getLanguage().getString("Unknown_Device_controls");
        }
    }

    /**
     * 获取玩家设备的系统
     * @return 玩家设备的系统
     */
    public static String getDeviceOS(Player player) {
        switch (player.getLoginChainData().getDeviceOS()) {
            case 1: return main.getConfigInPlayer().getString("Device.OS.Android");
            case 2: return main.getConfigInPlayer().getString("Device.OS.iOS");
            case 3: return main.getConfigInPlayer().getString("Device.OS.macOS");
            case 4: return main.getConfigInPlayer().getString("Device.OS.Fire_OS");
            case 5: return main.getConfigInPlayer().getString("Device.OS.Gear_VR");
            case 6: return main.getConfigInPlayer().getString("Device.OS.HoloLens");
            case 7: return main.getConfigInPlayer().getString("Device.OS.Windows_10");
            case 8: return main.getConfigInPlayer().getString("Device.OS.Windows");
            case 9: return main.getConfigInPlayer().getString("Device.OS.Dedicated");
            case 10: return main.getConfigInPlayer().getString("Device.OS.tvOS");
            case 11: return main.getConfigInPlayer().getString("Device.OS.PlayStation");
            case 12: return main.getConfigInPlayer().getString("Device.OS.Switch");
            case 13: return main.getConfigInPlayer().getString("Device.OS.Xbox");
            case 14: return main.getConfigInPlayer().getString("Device.OS.Windows_Phone");
            default: return main.getLanguage().getString("Unknown_Device_OS");
        }
    }

    /**
     * 获取玩家所在的世界的世界名
     * @return 玩家所在的世界的世界名
     */
    public static String getPlayerWorld(Player player) {
        String worldName = player.getLevel().getFolderName();
        String levelName = getWorldName(worldName);
        String unknownWorld = main.getLanguage().getString("Unknown_World").replace("{0}", worldName);
        if (levelName.equals("")) {
            levelName = unknownWorld;
        }
        return levelName;
    }

    //获取玩家所在的世界的世界名(这部分代码是用来处理通配符的)
    private static String getWorldName(String worldName) {
        Config worldConfig = main.getWorldName();
        for (String key : worldConfig.getKeys()) {
            if (worldName.matches(key.replace("*", ".*"))) { // 使用正则表达式处理通配符
                return worldConfig.getString(key);
            }
        }
        return "";
    }
}