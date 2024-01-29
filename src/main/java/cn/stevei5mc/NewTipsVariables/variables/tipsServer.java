package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;

public class tipsServer extends BaseVariable {
    public tipsServer(Player player) {
        super(player);
    }

    public void strReplace() {
        serverVar();
    }

    public void serverVar() {
        addStrReplaceString("{Server-Motd}", Server.getInstance().getMotd());
        addStrReplaceString("{Server-SubMotd}", Server.getInstance().getSubMotd());
        addStrReplaceString("{Server-Ip}", Server.getInstance().getIp());
        addStrReplaceString("{Server-Port}", String.valueOf(Server.getInstance().getPort()));
    }
}