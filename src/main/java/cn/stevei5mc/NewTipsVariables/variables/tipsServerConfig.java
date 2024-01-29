package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;

public class tipsServerConfig extends BaseVariable {
    public tipsServerConfig(Player player) {
        super(player);
    }

    public void strReplace() {
        serverVarConfig();
    }

    public void serverVarConfig() {
        addStrReplaceString("{Server-Tps}", this.getServerTps(player));
    }

    //这下面的内容是要从config.yml获取内容的,但是现在还不行

    public static String getServerTps(Player player) {
        String serverTps = "§a15";
        if (Server.getInstance().getTicksPerSecond() >= 0) {
            serverTps = "§c" + Server.getInstance().getTicksPerSecond();
        }
        if (Server.getInstance().getTicksPerSecond() >= 9) {
            serverTps = "§e" + Server.getInstance().getTicksPerSecond();
        }
        if (Server.getInstance().getTicksPerSecond() >= 15) {
            serverTps = "§a" + Server.getInstance().getTicksPerSecond();
        }
        return serverTps;
    }
}