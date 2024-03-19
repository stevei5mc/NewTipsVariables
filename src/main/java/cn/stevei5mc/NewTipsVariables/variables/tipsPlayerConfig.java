package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;
import cn.stevei5mc.NewTipsVariables.Main;

public class tipsPlayerConfig extends BaseVariable {
    public tipsPlayerConfig(Player player) {
        super(player);
    }

    public void strReplace() {
        playerVarConfig();
    }

    public void playerVarConfig() {  
        addStrReplaceString("{Device-Os}", this.mapDeviceOSToString(player.getLoginChainData().getDeviceOS()));
        addStrReplaceString("{Player-Ui}", this.playerUiString(player.getLoginChainData().getUIProfile()));
        addStrReplaceString("{Player-Ping}", this.getPlayerPing(player));
        addStrReplaceString("{Player-Food}", this.getPlayerFood(player));
        addStrReplaceString("{Player-Health}", this.getPlayerHealth(player));
        addStrReplaceString("{Player-World}", this.getPlayerWorld(player));
    }
    
    /*这ui档案应该只有classic ui和pocket ui这两种UI(测试出来的)
    Unknown UI是为了保险起见加上去的*/
    private String playerUiString(int uiprofile) {
        String classicUi = Main.getInstance().getConfigInPlayer().getString("Device.UIProfile.classic");
        String pocketUi = Main.getInstance().getConfigInPlayer().getString("Device.UIProfile.pocket");
        String unknownUi = Main.getInstance().getLanguage().getString("Unknown_Device_UIProfile");
        switch (uiprofile) {
            case 0: return classicUi;
            case 1: return pocketUi;
            default: return unknownUi;
        }
    }    

    //获取玩家的饱食度状态
    public static String getPlayerFood(Player player) {
        String playerFoodEmptyColor = Main.getInstance().getConfigInPlayer().getString("Food.empty_color");//empty值
        String playerFoodLowColor = Main.getInstance().getConfigInPlayer().getString("Food.low_color");//low值
        int playerFoodMediumValue = Main.getInstance().getConfigInPlayer().getInt("Food.medium_value");//medium值
        String playerFoodMediumColor = Main.getInstance().getConfigInPlayer().getString("Food.medium_color");
        int playerFoodHgihValue = Main.getInstance().getConfigInPlayer().getInt("Food.high_value");//hgih值
        String playerFoodHgihColor = Main.getInstance().getConfigInPlayer().getString("Food.high_color");
        String playerFood = playerFoodHgihColor + playerFoodHgihValue;
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

    //获取玩家的生命值状态
    public static String getPlayerHealth(Player player) {
        String playerHealthLowColor = Main.getInstance().getConfigInPlayer().getString("HP.low_color");//low值
        int playerHealthMediumValue = Main.getInstance().getConfigInPlayer().getInt("HP.medium_value");//medium值
        String playerHealthMediumColor = Main.getInstance().getConfigInPlayer().getString("HP.medium_color");
        int playerHealthHgihValue = Main.getInstance().getConfigInPlayer().getInt("HP.high_value");//hgih值
        String playerHealthHgihColor = Main.getInstance().getConfigInPlayer().getString("HP.high_color");
        String playerHealth = playerHealthHgihColor + playerHealthHgihValue;
        float healthValue = player.getHealth();
        String healthValue2 = String.valueOf(healthValue);
        String healthMaxValue = String.valueOf(player.getMaxHealth());
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
    
    //获取玩家设备的系统
    private String mapDeviceOSToString(int os) {
        String osAndroid = Main.getInstance().getConfigInPlayer().getString("Device.OS.Android");
        String osIOS = Main.getInstance().getConfigInPlayer().getString("Device.OS.iOS");
        String osMacOS = Main.getInstance().getConfigInPlayer().getString("Device.OS.macOS");
        String osFireOS = Main.getInstance().getConfigInPlayer().getString("Device.OS.Fire_OS");
        String osGearVR = Main.getInstance().getConfigInPlayer().getString("Device.OS.Gear_VR");
        String osHoloLens = Main.getInstance().getConfigInPlayer().getString("Device.OS.HoloLens");
        String osWindows10 = Main.getInstance().getConfigInPlayer().getString("Device.OS.Windows_10");
        String osWindows = Main.getInstance().getConfigInPlayer().getString("Device.OS.Windows");
        String osDedicated = Main.getInstance().getConfigInPlayer().getString("Device.OS.Dedicated");
        String osTvOS = Main.getInstance().getConfigInPlayer().getString("Device.OS.tvOS");
        String osPlayStation = Main.getInstance().getConfigInPlayer().getString("Device.OS.PlayStation");
        String osSwitch = Main.getInstance().getConfigInPlayer().getString("Device.OS.Switch");
        String osXbox = Main.getInstance().getConfigInPlayer().getString("Device.OS.Xbox");
        String osWindowsPhone = Main.getInstance().getConfigInPlayer().getString("Device.OS.Windows_Phone");
        String osUnknown = Main.getInstance().getLanguage().getString("Unknown_Device_OS");
        switch (os) {
            case 1: return osAndroid;
            case 2: return osIOS;
            case 3: return osMacOS;
            case 4: return osFireOS;
            case 5: return osGearVR;
            case 6: return osHoloLens;
            case 7: return osWindows10;
            case 8: return osWindows;
            case 9: return osDedicated;
            case 10: return osTvOS;
            case 11: return osPlayStation;
            case 12: return osSwitch;
            case 13: return osXbox;
            case 14: return osWindowsPhone;
            default: return osUnknown;
        }
    }

    //获取玩家的延迟
    public static String getPlayerPing(Player player) {
        String playerPingLowColor = Main.getInstance().getConfigInPlayer().getString("ping.low_color");
        int playerPingMediumValue = Main.getInstance().getConfigInPlayer().getInt("ping.medium_value");
        String playerPingMediumColor = Main.getInstance().getConfigInPlayer().getString("ping.medium_color");
        int playerPingHgihValue = Main.getInstance().getConfigInPlayer().getInt("ping.high_value");
        String playerPingHgihColor = Main.getInstance().getConfigInPlayer().getString("ping.high_color");
        String playerMS = playerPingHgihColor + playerPingHgihValue;
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
}