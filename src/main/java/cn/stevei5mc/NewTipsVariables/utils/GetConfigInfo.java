package cn.stevei5mc.NewTipsVariables.utils;

import cn.stevei5mc.NewTipsVariables.Main;
import cn.nukkit.Player;
import cn.nukkit.Server;
import healthapi.PlayerHealth;
import cn.stevei5mc.NewTipsVariables.variables.LoadSupportPlugins;

public class GetConfigInfo {
    //获取服务器TPS
    public static String getServerTps(Player player) {
        String serverTpslowColor = Main.getInstance().getConfigInServer().getString("TPS.low_color");//low值
        int serverTpsMediumValue = Main.getInstance().getConfigInServer().getInt("TPS.medium_value");//medium值
        String serverTpsMediumColor = Main.getInstance().getConfigInServer().getString("TPS.medium_color");
        int serverTpsHgihValue = Main.getInstance().getConfigInServer().getInt("TPS.high_value");//hgih值
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
    //获取玩家所在的世界名
    public static String getPlayerWorld(Player player) {
        String worldName = player.getLevel().getFolderName();
        String levelName = Main.getInstance().getWorldName().getString(worldName);
        String unknownWorld = Main.getInstance().getLanguage().getString("Unknown_World").replace("{0}", worldName);
        if (levelName == "") {
            levelName = unknownWorld;
        }
        return levelName;
    }
    //获取玩家的延迟
    public static String getPlayerPing(Player player) {
        String playerPingLowColor = Main.getInstance().getConfigInPlayer().getString("ping.low_color");//low值
        int playerPingMediumValue = Main.getInstance().getConfigInPlayer().getInt("ping.medium_value");//medium值
        String playerPingMediumColor = Main.getInstance().getConfigInPlayer().getString("ping.medium_color");
        int playerPingHgihValue = Main.getInstance().getConfigInPlayer().getInt("ping.high_value");//hgih值
        String playerPingHgihColor = Main.getInstance().getConfigInPlayer().getString("ping.high_color");
        String playerMS;
        int pingValue = player.getPing();
        //low=0
        if (pingValue >= playerPingHgihValue) {
            playerMS = playerPingHgihColor + pingValue;
        }else if (pingValue >= playerPingMediumValue) {
            playerMS = playerPingMediumColor + pingValue;
        }else {
            playerMS = playerPingLowColor + pingValue;
        }
        return playerMS;
    }
    //获取玩家的生命值状态
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
        if (LoadSupportPlugins.pl5) {
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
    //获取玩家的饱食度状态
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
    //获取玩家的UI Profile
    public static String getPlayerUi(int ui) {
        String classicUi = Main.getInstance().getConfigInPlayer().getString("Device.UIProfile.classic");
        String pocketUi = Main.getInstance().getConfigInPlayer().getString("Device.UIProfile.pocket");
        String unknownUi = Main.getInstance().getLanguage().getString("Unknown_Device_UIProfile");
        switch (ui) {
            case 0: return classicUi;
            case 1: return pocketUi;
            default: return unknownUi;
        }
    }
    //获取玩家的操作方式
    public static String getDeviceControls(int ctrl) {
        String keyboard = Main.getInstance().getConfigInPlayer().getString("Device.Controls.Keyboard");
        String touch = Main.getInstance().getConfigInPlayer().getString("Device.Controls.Touch");
        String pad = Main.getInstance().getConfigInPlayer().getString("Device.Controls.pad");
        String motionController = Main.getInstance().getConfigInPlayer().getString("Device.Controls.motion_controller");
        String unknownCtrl = Main.getInstance().getLanguage().getString("Unknown_Device_controls");
        switch (ctrl) {
            case 1: return keyboard;
            case 2: return touch;
            case 3: return pad;
            case 4: return motionController;
            default: return unknownCtrl;
       }
    }
    //获取玩家设备的系统
    public static String getDeviceOS(int os) {
        String android = Main.getInstance().getConfigInPlayer().getString("Device.OS.Android");
        String iOS = Main.getInstance().getConfigInPlayer().getString("Device.OS.iOS");
        String macOS = Main.getInstance().getConfigInPlayer().getString("Device.OS.macOS");
        String fireOS = Main.getInstance().getConfigInPlayer().getString("Device.OS.Fire_OS");
        String gearVR = Main.getInstance().getConfigInPlayer().getString("Device.OS.Gear_VR");
        String holoLens = Main.getInstance().getConfigInPlayer().getString("Device.OS.HoloLens");
        String windows10 = Main.getInstance().getConfigInPlayer().getString("Device.OS.Windows_10");
        String windows = Main.getInstance().getConfigInPlayer().getString("Device.OS.Windows");
        String dedicated = Main.getInstance().getConfigInPlayer().getString("Device.OS.Dedicated");
        String tvOS = Main.getInstance().getConfigInPlayer().getString("Device.OS.tvOS");
        String playStation = Main.getInstance().getConfigInPlayer().getString("Device.OS.PlayStation");
        String switchh = Main.getInstance().getConfigInPlayer().getString("Device.OS.Switch");
        String xbox = Main.getInstance().getConfigInPlayer().getString("Device.OS.Xbox");
        String windowsPhone = Main.getInstance().getConfigInPlayer().getString("Device.OS.Windows_Phone");
        String unknownOs = Main.getInstance().getLanguage().getString("Unknown_Device_OS");
        switch (os) {
            case 1: return android;
            case 2: return iOS;
            case 3: return macOS;
            case 4: return fireOS;
            case 5: return gearVR;
            case 6: return holoLens;
            case 7: return windows10;
            case 8: return windows;
            case 9: return dedicated;
            case 10: return tvOS;
            case 11: return playStation;
            case 12: return switchh;
            case 13: return xbox;
            case 14: return windowsPhone;
            default: return unknownOs;
        }
    }
}