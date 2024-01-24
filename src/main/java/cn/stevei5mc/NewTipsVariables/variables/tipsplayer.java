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
        addStrReplaceString("{PlayerXp}", String.valueOf(player.getExperienceLevel()));
        addStrReplaceString("{DeviceModel}", player.getLoginChainData().getDeviceModel());
        addStrReplaceString("{XUID}", String.valueOf(player.getLoginChainData().getXUID()));
        addStrReplaceString("{PlayerLang}", player.getLoginChainData().getLanguageCode());  
        addStrReplaceString("{PlayerUuid}", String.valueOf(player.getLoginChainData().getClientUUID())); 
    }
}