package cn.stevei5mc.NewTipsVariables.variables.supportPlugins;

import tip.utils.Api;
import cn.nukkit.Server;
import cn.nukkit.Player;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.economyApiVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.playerPointsVariable;

public class loadSupportPlugins {
    
    public static void loadSupportVariables(Player player) {
        //加载相关插件的变量时的提示
        String loadSuccessMsg1 = "§a识别到插件§e【§b";
        String loadSuccessMsg2 = "§e】§a相关变量已加载";
        String loadFailureMsg1 = "§c无法识别到插件§e【§b";
        String loadFailureMsg2 = "§e】§c相关变量加载失败,请安装相关插件再试";
        //需要加载的变量的插件
        String loadPlugin1 = "playerPoints";
        String loadPlugin2 = "EconomyAPI";
        
        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin1) != null) {
            //存在
            Api.registerVariables("playerPointsVariable", playerPointsVariable.class);
            Server.getInstance().getLogger().info(loadSuccessMsg1 + loadPlugin1 + loadSuccessMsg2);
        }  else {
            //不存在
            String loadPlugin1Failure = loadFailureMsg1 + loadPlugin1 + loadFailureMsg2;
            Server.getInstance().getLogger().info(loadPlugin1Failure);
            Api.addVariable("{point}", loadPlugin1Failure);
        }

        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin2) != null) {
            //存在
            Api.registerVariables("economyApiVariable", economyApiVariable.class);
            Server.getInstance().getLogger().info(loadSuccessMsg1 + loadPlugin2 + loadSuccessMsg2);
        }  else {
            //不存在
            String loadPlugin2Failure = loadFailureMsg1 + loadPlugin2 + loadFailureMsg2;
            Server.getInstance().getLogger().info(loadPlugin2Failure);
            Api.addVariable("{economy}", loadPlugin2Failure);
        }      
    }
}