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
        addStrReplaceString("{PlayerUI}", this.playerUiString(player.getLoginChainData().getUIProfile()));    
    }
    
    private String playerUiString(int uiprofile) {
        switch (uiprofile) {
            case 0: return "classic ui";
            case 1: return "pocket ui";
            default: return "Unknown UI";
        }
    }
}