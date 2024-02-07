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
    }
    
    /*这ui档案应该只有classic ui和pocket ui这两种UI(测试出来的)
    Unknown UI是为了保险起见加上去的*/
    private String playerUiString(int uiprofile) {
        String classicUi = Main.getInstance().getConfigInPlayer().getString("Device.UIProfile.classic");
        String pocketUi = Main.getInstance().getConfigInPlayer().getString("Device.UIProfile.pocket");
        String unknownUi = Main.getInstance().getConfigInPlayer().getString("Device.UIProfile.Unknown");
        switch (uiprofile) {
            case 0: return classicUi;
            case 1: return pocketUi;
            default: return unknownUi;
        }
    }    

    //获取玩家的饱食度状态
    public static String getPlayerFood(Player player) {
        String playerFoodLowColor = Main.getInstance().getConfigInPlayer().getString("Food.low_color");
        int playerFoodMediumValue = Main.getInstance().getConfigInPlayer().getInt("Food.medium_value");
        String playerFoodMediumColor = Main.getInstance().getConfigInPlayer().getString("Food.medium_color");
        int playerFoodHgihValue = Main.getInstance().getConfigInPlayer().getInt("Food.high_value");
        String playerFoodHgihColor = Main.getInstance().getConfigInPlayer().getString("Food.high_color");
        String playerFood = playerFoodHgihColor + playerFoodHgihValue;
        float foodValue = player.getFoodData().getLevel();
        //最低值为0
        if (foodValue >= 0) {
            playerFood = playerFoodLowColor + foodValue;
        }
        if (foodValue >= playerFoodMediumValue) {
            playerFood = playerFoodMediumColor + foodValue;
        }
        if (foodValue >= playerFoodHgihValue) {
            playerFood = playerFoodHgihColor + foodValue;
        }
        return playerFood;
    }

    //获取玩家的生命值状态
    public static String getPlayerHealth(Player player) {
        String playerHealthLowColor = Main.getInstance().getConfigInPlayer().getString("HP.low_color");
        int playerHealthMediumValue = Main.getInstance().getConfigInPlayer().getInt("HP.medium_value");
        String playerHealthMediumColor = Main.getInstance().getConfigInPlayer().getString("HP.medium_color");
        int playerHealthHgihValue = Main.getInstance().getConfigInPlayer().getInt("HP.high_value");
        String playerHealthHgihColor = Main.getInstance().getConfigInPlayer().getString("HP.high_color");
        String playerHealth = playerHealthHgihColor + playerHealthHgihValue;
        float healthValue = player.getHealth();
        //最低值为0
        if (healthValue >= 0) {
            playerHealth = playerHealthLowColor + healthValue;
        }
        if (healthValue >= playerHealthMediumValue) {
            playerHealth = playerHealthMediumColor + healthValue;
        }
        if (healthValue >= playerHealthHgihValue) {
            playerHealth = playerHealthHgihColor + healthValue;
        }
        return playerHealth;
    }
    
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
        String osUnknown = Main.getInstance().getConfigInPlayer().getString("Device.OS.Unknown");
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

    public static String getPlayerPing(Player player) {
        String playerPingLowColor = Main.getInstance().getConfigInPlayer().getString("ping.low_color");
        int playerPingMediumValue = Main.getInstance().getConfigInPlayer().getInt("ping.medium_value");
        String playerPingMediumColor = Main.getInstance().getConfigInPlayer().getString("ping.medium_color");
        int playerPingHgihValue = Main.getInstance().getConfigInPlayer().getInt("ping.high_value");
        String playerPingHgihColor = Main.getInstance().getConfigInPlayer().getString("ping.high_color");
        String playerMS = playerPingHgihColor + playerPingHgihValue;
        int pingValue = player.getPing();
        //最低值为0
        if (pingValue >= 0) {
            playerMS = playerPingLowColor + pingValue;
        }
        if (pingValue >= playerPingMediumValue) {
            playerMS = playerPingMediumColor + pingValue;
        }
        if (pingValue >= playerPingHgihValue) {
            playerMS = playerPingHgihColor + pingValue;
        }
        return playerMS;
    }
}