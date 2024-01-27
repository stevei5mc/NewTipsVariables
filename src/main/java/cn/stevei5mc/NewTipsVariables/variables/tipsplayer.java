package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;

public class tipsplayer extends BaseVariable {
    public tipsplayer(Player player) {
        super(player);
    }

    public void strReplace() {
        playervar();
    }

    public void playervar() {
        addStrReplaceString("{Player-Xp}", String.valueOf(player.getExperienceLevel()));
        addStrReplaceString("{Device-Model}", player.getLoginChainData().getDeviceModel());
        addStrReplaceString("{XUID}", String.valueOf(player.getLoginChainData().getXUID()));
        addStrReplaceString("{Player-Lang}", player.getLoginChainData().getLanguageCode());  
        addStrReplaceString("{Player-Uuid}", String.valueOf(player.getLoginChainData().getClientUUID())); 
    }
}