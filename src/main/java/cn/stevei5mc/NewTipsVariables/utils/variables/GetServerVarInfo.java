package cn.stevei5mc.NewTipsVariables.utils.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.utils.Config;
import cn.stevei5mc.NewTipsVariables.Main;

public class GetServerVarInfo {

    private static final Main main = Main.getInstance();

    /**
     * 获取服务器TPS
     * @return 服务器TPS
     */
    public static String getServerTps() {
        float tpsValue = Server.getInstance().getTicksPerSecond();
        String color = main.getConfigInServer().getString("TPS.low_color");
        if (tpsValue >= main.getConfigInServer().getInt("TPS.high_value")) {
            color = main.getConfigInServer().getString("TPS.high_color");
        }else if (tpsValue >= main.getConfigInServer().getInt("TPS.medium_value")) {
            color = main.getConfigInServer().getString("TPS.medium_color");
        }
        return color + tpsValue;
    }
}