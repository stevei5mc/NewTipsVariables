package cn.stevei5mc.NewTipsVariables.utils;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.utils.Config;
import cn.stevei5mc.NewTipsVariables.Main;
import healthapi.PlayerHealth;

public class GetConfigInfo {
    /**
     * 获取服务器TPS
     * @return 服务器TPS
    */
    public static String getServerTps() {
        String serverTpslowColor = Main.getInstance().getConfigInServer().getString("TPS.low_color");//low值
        int serverTpsMediumValue = Main.getInstance().getConfigInServer().getInt("TPS.medium_value");//medium值
        String serverTpsMediumColor = Main.getInstance().getConfigInServer().getString("TPS.medium_color");
        int serverTpsHgihValue = Main.getInstance().getConfigInServer().getInt("TPS.high_value");//high值
        String serverTpsHgihColor = Main.getInstance().getConfigInServer().getString("TPS.high_color");
        String serverTps;
        float tpsValue = Server.getInstance().getTicksPerSecond();
        //low=0
        if (tpsValue >= serverTpsHgihValue) {
            serverTps = serverTpsHgihColor + tpsValue;
        }else if (tpsValue >= serverTpsMediumValue) {
            serverTps = serverTpsMediumColor + tpsValue;
        }else {
            serverTps = serverTpslowColor + tpsValue;
        }
        return serverTps;
    }

    /**
     * 获取玩家所在的世界的世界名
     * @return 玩家所在的世界的世界名
    */
    public static String getPlayerWorld(Player player) {
        String worldName = player.getLevel().getFolderName();
        String levelName = getWorldName(worldName); // 使用我们的新方法获取世界名
        String unknownWorld = Main.getInstance().getLanguage().getString("Unknown_World").replace("{0}", worldName);
        if (levelName == "") {
            levelName = unknownWorld;
        }
        return levelName;
    }

    //获取玩家所在的世界的世界名(这部分代码是用来处理通配符的)
    private static String getWorldName(String worldName) {
        Config worldConfig = Main.getInstance().getWorldName();
        for (String key : worldConfig.getKeys()) {
            if (worldName.matches(key.replace("*", ".*"))) { // 使用正则表达式处理通配符
                return worldConfig.getString(key);
            }
        }
        return "";
    }

    /**
     * 获取玩家的延迟
     * @return 玩家的延迟
    */
    public static String getPlayerPing(Player player) {
        String playerPingLowColor = Main.getInstance().getConfigInPlayer().getString("ping.low_color");// low color
        int playerPingMediumValue = Main.getInstance().getConfigInPlayer().getInt("ping.medium_value");//medium值
        String playerPingMediumColor = Main.getInstance().getConfigInPlayer().getString("ping.medium_color");
        int playerPingHighValue = Main.getInstance().getConfigInPlayer().getInt("ping.high_value");//high值
        String playerPingHighColor = Main.getInstance().getConfigInPlayer().getString("ping.high_color");
        String playerMS;
        int pingValue = player.getPing();
        //low=0
        if (pingValue >= playerPingHighValue) {
            playerMS = playerPingHighColor + pingValue;
        }else if (pingValue >= playerPingMediumValue) {
            playerMS = playerPingMediumColor + pingValue;
        }else {
            playerMS = playerPingLowColor + pingValue;
        }
        return playerMS;
    }

    /**
     * 获取玩家的生命值状态
     * @return 玩家的生命值状态
    */
    public static String getPlayerHealth(Player player) {
        String playerHealthLowColor = Main.getInstance().getConfigInPlayer().getString("HP.low_color");//low值
        int playerHealthMediumValue = Main.getInstance().getConfigInPlayer().getInt("HP.medium_value");//medium值
        String playerHealthMediumColor = Main.getInstance().getConfigInPlayer().getString("HP.medium_color");
        int playerHealthHgihValue = Main.getInstance().getConfigInPlayer().getInt("HP.high_value");//hgih值
        String playerHealthHgihColor = Main.getInstance().getConfigInPlayer().getString("HP.high_color");
        String playerHealth;
        double healthValue;
        String healthValue2;
        String healthMaxValue;
        if (PluginsState.getPluginState(PluginsListEnum.HEALTH_API.getName())) {
            PlayerHealth health = PlayerHealth.getPlayerHealth(player);
            healthValue = health.getHealth();
            healthValue2 = String.valueOf(healthValue);
            healthMaxValue = String.valueOf(health.getMaxHealth());
        }else {
            healthValue = player.getHealth();
            healthValue2 = String.valueOf(healthValue);
            healthMaxValue = String.valueOf(player.getMaxHealth());
        }
        //low=1
        if (healthValue >= playerHealthHgihValue) {
            playerHealth = playerHealthHgihColor.replace("{0}",healthValue2).replace("{1}",healthMaxValue);
        }else if (healthValue >= playerHealthMediumValue) {
            playerHealth = playerHealthMediumColor.replace("{0}",healthValue2).replace("{1}",healthMaxValue);
        }else {
            playerHealth = playerHealthLowColor.replace("{0}",healthValue2).replace("{1}",healthMaxValue);
        }
        return playerHealth;
    }

    /**
     * 获取玩家的饱食度状态
     * @return 玩家的饱食度状态
    */
    public static String getPlayerFood(Player player) {
        String playerFoodEmptyColor = Main.getInstance().getConfigInPlayer().getString("Food.empty_color");//empty值
        String playerFoodLowColor = Main.getInstance().getConfigInPlayer().getString("Food.low_color");//low值
        int playerFoodMediumValue = Main.getInstance().getConfigInPlayer().getInt("Food.medium_value");//medium值
        String playerFoodMediumColor = Main.getInstance().getConfigInPlayer().getString("Food.medium_color");
        int playerFoodHgihValue = Main.getInstance().getConfigInPlayer().getInt("Food.high_value");//hgih值
        String playerFoodHgihColor = Main.getInstance().getConfigInPlayer().getString("Food.high_color");
        String playerFood;
        float foodValue = player.getFoodData().getLevel();
        String foodValue2 = String.valueOf(foodValue);
        String foodMaxValue = String.valueOf(player.getFoodData().getMaxLevel());
        //empty=0 low=1
        if (foodValue >= playerFoodHgihValue) {
            playerFood = playerFoodHgihColor.replace("{0}",foodValue2).replace("{1}",foodMaxValue);
        }else if (foodValue >= playerFoodMediumValue) {
            playerFood = playerFoodMediumColor.replace("{0}",foodValue2).replace("{1}",foodMaxValue);
        }else if (foodValue >= 1) {
            playerFood = playerFoodLowColor.replace("{0}",foodValue2).replace("{1}",foodMaxValue);
        }else {
            playerFood = playerFoodEmptyColor.replace("{0}",foodValue2).replace("{1}",foodMaxValue);
        }
        return playerFood;
    }

    /**
     * 获取玩家的UI Profile
     * @return 玩家的UI Profile
    */
    public static String getPlayerUi(int ui) {
        switch (ui) {
            case 0: return Main.getInstance().getConfigInPlayer().getString("Device.UIProfile.classic");
            case 1: return Main.getInstance().getConfigInPlayer().getString("Device.UIProfile.pocket");
            default: return Main.getInstance().getLanguage().getString("Unknown_Device_UIProfile");
        }
    }

    /**
     * 获取玩家的操作方式
     * @return 玩家的操作方式
    */
    public static String getDeviceControls(int ctrl) {
        switch (ctrl) {
            case 1: return Main.getInstance().getConfigInPlayer().getString("Device.Controls.Keyboard");
            case 2: return Main.getInstance().getConfigInPlayer().getString("Device.Controls.Touch");
            case 3: return Main.getInstance().getConfigInPlayer().getString("Device.Controls.pad");
            case 4: return Main.getInstance().getConfigInPlayer().getString("Device.Controls.motion_controller");
            default: return Main.getInstance().getLanguage().getString("Unknown_Device_controls");
       }
    }

    /**
     * 获取玩家设备的系统
     * @return 玩家设备的系统
    */
    public static String getDeviceOS(int os) {
        switch (os) {
            case 1: return Main.getInstance().getConfigInPlayer().getString("Device.OS.Android");
            case 2: return Main.getInstance().getConfigInPlayer().getString("Device.OS.iOS");
            case 3: return Main.getInstance().getConfigInPlayer().getString("Device.OS.macOS");
            case 4: return Main.getInstance().getConfigInPlayer().getString("Device.OS.Fire_OS");
            case 5: return Main.getInstance().getConfigInPlayer().getString("Device.OS.Gear_VR");
            case 6: return Main.getInstance().getConfigInPlayer().getString("Device.OS.HoloLens");
            case 7: return Main.getInstance().getConfigInPlayer().getString("Device.OS.Windows_10");
            case 8: return Main.getInstance().getConfigInPlayer().getString("Device.OS.Windows");
            case 9: return Main.getInstance().getConfigInPlayer().getString("Device.OS.Dedicated");
            case 10: return Main.getInstance().getConfigInPlayer().getString("Device.OS.tvOS");
            case 11: return Main.getInstance().getConfigInPlayer().getString("Device.OS.PlayStation");
            case 12: return Main.getInstance().getConfigInPlayer().getString("Device.OS.Switch");
            case 13: return Main.getInstance().getConfigInPlayer().getString("Device.OS.Xbox");
            case 14: return Main.getInstance().getConfigInPlayer().getString("Device.OS.Windows_Phone");
            default: return Main.getInstance().getLanguage().getString("Unknown_Device_OS");
        }
    }
}