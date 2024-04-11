package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import cn.stevei5mc.NewTipsVariables.utils.GetConfigInfo;

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
        int yaw = (int) player.getYaw();
        addStrReplaceString("{Player-Yaw}",String.valueOf(yaw));
        int pitch = (int) player.getPitch();
        addStrReplaceString("{Player-Pitch}",String.valueOf(pitch));
        int headYaw = (int) player.getHeadYaw();
        addStrReplaceString("{Player-HeadYaw}",String.valueOf(headYaw));
        addStrReplaceString("{Player-World}", GetConfigInfo.getPlayerWorld(player));
        addStrReplaceString("{Player-Ping}", GetConfigInfo.getPlayerPing(player));
        addStrReplaceString("{Player-Health}", GetConfigInfo.getPlayerHealth(player));
        addStrReplaceString("{Player-Food}", GetConfigInfo.getPlayerFood(player));
        addStrReplaceString("{Player-Ui}", GetConfigInfo.getPlayerUi(player.getLoginChainData().getUIProfile()));
        addStrReplaceString("{Player-Controls}",GetConfigInfo.getDeviceControls(player.getLoginChainData().getCurrentInputMode()));
        addStrReplaceString("{Device-Os}", GetConfigInfo.getDeviceOS(player.getLoginChainData().getDeviceOS()));
    }
}