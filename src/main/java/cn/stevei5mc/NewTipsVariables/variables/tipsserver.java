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
        addStrReplaceString("{Server-Motd}", Server.getInstance().getMotd());
        addStrReplaceString("{Server-SubMotd}", Server.getInstance().getSubMotd());
        addStrReplaceString("{Server-Ip}", Server.getInstance().getIp());
        addStrReplaceString("{Server-Port}", String.valueOf(Server.getInstance().getPort()));
    }
}