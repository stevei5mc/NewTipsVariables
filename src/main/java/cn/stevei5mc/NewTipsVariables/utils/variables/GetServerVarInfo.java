package cn.stevei5mc.NewTipsVariables.utils.variables;

import cn.nukkit.Nukkit;
import cn.nukkit.Server;
import cn.stevei5mc.NewTipsVariables.Main;

import java.util.concurrent.TimeUnit;

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

    public static String getServerRuntime() {
        long runtime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - Nukkit.START_TIME);

        long days = runtime / 86400;
        long hours = (runtime % 86400) / 3600;
        long minutes = (runtime % 3600) / 60;
        long seconds = runtime % 60;

        return main.getConfigInServer().getString("runtime", "§a{0} §e天 §a{1} §e小时 §a{2} §e分钟 §a{3} §e秒").replace("{0}", String.valueOf(days)).replace("{1}", String.valueOf(hours))
                .replace("{2}", String.valueOf(minutes)).replace("{3}", String.valueOf(seconds));
    }
}