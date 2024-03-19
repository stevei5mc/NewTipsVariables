package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import tip.utils.variables.BaseVariable;
import cn.stevei5mc.NewTipsVariables.Main;

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

    public static String getServerTps(Player player) {
        String serverTpslowColor = Main.getInstance().getConfigInServer().getString("TPS.low_color");
        int serverTpsMediumValue = Main.getInstance().getConfigInServer().getInt("TPS.medium_value");
        String serverTpsMediumColor = Main.getInstance().getConfigInServer().getString("TPS.medium_color");
        int serverTpsHgihValue = Main.getInstance().getConfigInServer().getInt("TPS.high_value");
        String serverTpsHgihColor = Main.getInstance().getConfigInServer().getString("TPS.high_color");
        String serverTps = serverTpsHgihColor + serverTpsHgihValue;
        float tpsValue = Server.getInstance().getTicksPerSecond();
        //low=0
        if (tpsValue >= serverTpsHgihValue) {
            serverTps = serverTpsHgihColor + tpsValue;
        }else if (tpsValue >= serverTpsMediumValue) {
            serverTps = serverTpsMediumColor + tpsValue;
        }else {
            serverTps = serverTpslowColor + tpsValue;
        }
        return serverTps;
    }
}