package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;

public class tipsserver2 extends BaseVariable {
    public tipsserver2(Player player) {
        super(player);
    }

    public void strReplace() {
        scv();
    }

    public void scv() {
        addStrReplaceString("{ServerTps}", this.getServerTps(player));
    }

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