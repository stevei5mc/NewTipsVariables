package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;

public class tipsplayer2 extends BaseVariable {
    public tipsplayer2(Player player) {
        super(player);
    }

    public void strReplace() {
        playervar();
    }

    public void playervar() {  
        addStrReplaceString("{Device-Os}", this.mapDeviceOSToString(player.getLoginChainData().getDeviceOS()));
        addStrReplaceString("{Player-Ui}", this.playerUiString(player.getLoginChainData().getUIProfile()));
        addStrReplaceString("{Player-Ping}", this.getPlayerPing(player));
        addStrReplaceString("{Player-Food}", this.getPlayerFood(player));
        addStrReplaceString("{Player-Health}", this.getPlayerHealth(player));
    }


    //这下面的内容是要从config.yml获取内容的,但是现在还不行
    
    /*这ui档案应该只有classic ui和pocket ui这两种UI(测试出来的)
    Unknown UI是为了保险起见加上去的*/
    private String playerUiString(int uiprofile) {
        switch (uiprofile) {
            case 0: return "classic ui";
            case 1: return "pocket ui";
            default: return "Unknown UI";
        }
    }    

    //获取玩家的饱食度状态
    public static String getPlayerFood(Player player) {
        String playerFood = "§a15";
        if (player.getFoodData().getLevel() >= 0) {
            playerFood = "§c" + player.getFoodData().getLevel();
        }
        if (player.getFoodData().getLevel() >= 9) {
            playerFood = "§e" + player.getFoodData().getLevel();
        }
        if (player.getFoodData().getLevel() >= 15) {
            playerFood = "§a" + player.getFoodData().getLevel();
        }
        return playerFood;
    }

    //获取玩家的生命值状态
    public static String getPlayerHealth(Player player) {
        String playerFood = "§a15";
        if (player.getHealth() >= 0) {
            playerFood = "§c" + player.getHealth();
        }
        if (player.getHealth() >= 9) {
            playerFood = "§e" + player.getHealth();
        }
        if (player.getHealth() >= 15) {
            playerFood = "§a" + player.getHealth();
        }
        return playerFood;
    }
    
    private String mapDeviceOSToString(int os) {
        switch (os) {
            case 1: return "Android";
            case 2: return "iOS";
            case 3: return "macOS";
            case 4: return "Fire OS";
            case 5: return "Gear VR";
            case 6: return "HoloLens";
            case 7: return "Windows 10";
            case 8: return "Windows";
            case 9: return "Dedicated";
            case 10: return "tvOS";
            case 11: return "PlayStation";
            case 12: return "Switch";
            case 13: return "Xbox";
            case 14: return "Windows Phone";
        }
        return "Unknown";
    }

    public static String getPlayerPing(Player player) {
        String playerMS = "§a0";
        if (player.getPing() >= 0) {
            playerMS = "§a" + player.getPing();
        }
        if (player.getPing() >= 80) {
            playerMS = "§e" + player.getPing();
        }
        if (player.getPing() >= 120) {
            playerMS = "§c" + player.getPing();
        }
        return playerMS;
    }
}