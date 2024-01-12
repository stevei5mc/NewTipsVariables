package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;

public class tipsserver extends BaseVariable {
    public tipsserver(Player player) {
        super(player);
    }

    public void strReplace() {
        scv();
    }

    public void scv() {
        addStrReplaceString("{Motd}", Server.getInstance().getMotd());
        addStrReplaceString("{SubMotd}", Server.getInstance().getSubMotd());
    }
}