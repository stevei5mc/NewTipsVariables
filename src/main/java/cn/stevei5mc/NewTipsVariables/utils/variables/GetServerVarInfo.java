package cn.stevei5mc.NewTipsVariables.utils.variables;

import cn.nukkit.Server;
import cn.stevei5mc.NewTipsVariables.Main;

public class GetServerVarInfo {

    private static final Main main = Main.getInstance();

    /**
     * 获取服务器TPS
     * @return 服务器TPS
     */
    public static String getServerTps() {
        float tpsValue = Server.getInstance().getTicksPerSecond();
        String color = main.getConfigInServer().getString("TPS.color.low");
        if (tpsValue >= main.getConfigInServer().getInt("TPS.value.high")) {
            color = main.getConfigInServer().getString("TPS.color.high");
        }else if (tpsValue >= main.getConfigInServer().getInt("TPS.value.medium")) {
            color = main.getConfigInServer().getString("TPS.color.medium");
        }
        return color + tpsValue;
    }
}