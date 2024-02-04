package cn.stevei5mc.NewTipsVariables.variables.supportPlugins;

import tip.utils.Api;
import cn.nukkit.Server;
import cn.nukkit.Player;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.economyApiVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.playerPointsVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.OreAreaVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.RsTaskVariable;

public class loadSupportPlugins {
    
    public static void loadSupportVariables(Player player) {
        //加载相关插件的变量时的提示
        String loadSuccessMsg1 = "§a找到插件§e【§b";
        String loadSuccessMsg2 = "§e】§a相关变量已加载";
        String loadFailureMsg1 = "§c无法找到插件§e【§b";
        String loadFailureMsg2 = "§e】§c相关变量加载失败,请安装相关插件再试";
        //需要加载的变量的插件
        
        String loadPlugin1 = "playerPoints";
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

        String loadPlugin2 = "EconomyAPI";
        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin2) != null) {
            //存在
            Api.registerVariables("economyApiVariable", economyApiVariable.class);
            Server.getInstance().getLogger().info(loadSuccessMsg1 + loadPlugin2 + loadSuccessMsg2);
        }  else {
            //不存在
            String loadPlugin2Failure = loadFailureMsg1 + loadPlugin2 + loadFailureMsg2;
            Server.getInstance().getLogger().info(loadPlugin2Failure);
            Api.addVariable("{economyApi-money}", loadPlugin2Failure);
        }
        
        String loadPlugin3 = "OreArea";
        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin3) != null) {
            //存在
            Api.registerVariables("OreAreaVariable", OreAreaVariable.class);
            Server.getInstance().getLogger().info(loadSuccessMsg1 + loadPlugin3 + loadSuccessMsg2);
        }  else {
            //不存在
            String loadPlugin3Failure = loadFailureMsg1 + loadPlugin3 + loadFailureMsg2;
            Server.getInstance().getLogger().info(loadPlugin3Failure);
            Api.addVariable("{orearea-level-this}", loadPlugin3Failure);Api.addVariable("{orearea-level-next}", loadPlugin3Failure);
            Api.addVariable("{orearea-time-use}", loadPlugin3Failure);Api.addVariable("{orearea-time-reset}", loadPlugin3Failure);
            Api.addVariable("{orearea-name}", loadPlugin3Failure);
        }
        
        String loadPlugin4 = "RsTask";
        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin4) != null) {
            //存在
            Api.registerVariables("RsTaskVariable", RsTaskVariable.class);
            Server.getInstance().getLogger().info(loadSuccessMsg1 + loadPlugin4 + loadSuccessMsg2);
        }  else {
            //不存在
            String loadPlugin4Failure = loadFailureMsg1 + loadPlugin4 + loadFailureMsg2;
            Server.getInstance().getLogger().info(loadPlugin4Failure);
            Api.addVariable("{task-name}", loadPlugin4Failure);Api.addVariable("{task-count}", loadPlugin4Failure);
        }
    }
}