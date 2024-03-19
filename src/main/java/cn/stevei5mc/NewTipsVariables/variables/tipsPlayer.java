package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;

public class tipsPlayer extends BaseVariable {
    public tipsPlayer(Player player) {
        super(player);
    }

    public void strReplace() {
        playerVar();
    }

    public void playerVar() {
        addStrReplaceString("{Player-Xp}", String.valueOf(player.getExperienceLevel()));
        addStrReplaceString("{Device-Model}", player.getLoginChainData().getDeviceModel());
        addStrReplaceString("{XUID}", String.valueOf(player.getLoginChainData().getXUID()));
        addStrReplaceString("{Player-Lang}", player.getLoginChainData().getLanguageCode());
        addStrReplaceString("{Player-Uuid}", String.valueOf(player.getLoginChainData().getClientUUID()));
    }
}