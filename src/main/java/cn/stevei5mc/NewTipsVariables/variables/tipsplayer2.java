package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;

//这个class内容是要从config.yml获取内容的,但是现在还不行
public class tipsplayer2 extends BaseVariable {
    public tipsplayer2(Player player) {
        super(player);
    }

    public void strReplace() {
        playervar();
    }

    public void playervar() {  
        addStrReplaceString("{deviceOS}", this.mapDeviceOSToString(player.getLoginChainData().getDeviceOS()));
        addStrReplaceString("{PlayerUi}", this.playerUiString(player.getLoginChainData().getUIProfile()));
    }
    
    //这下面的内容是要从config.yml获取内容的,但是现在还不行
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

    private String playerUiString(int uiprofile) {
        switch (uiprofile) {
            case 0: return "classic ui";
            case 1: return "pocket ui";
            default: return "Unknown UI";
        }
    }
}