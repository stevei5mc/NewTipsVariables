package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;
import cn.nukkit.level.Level;
import cn.stevei5mc.NewTipsVariables.utils.GetConfigInfo;

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
        //参考了RsNpcVariable的写法
        for (Level level : Server.getInstance().getLevels().values()) {
            addStrReplaceString("{WorldOnline@"+ level.getFolderName() +"}", String.valueOf(level.getPlayers().size()));
        }
        addStrReplaceString("{Server-Tps}", GetConfigInfo.getServerTps(player));
    }
}