package cn.stevei5mc.NewTipsVariables.variables.supportPlugins;

import tip.utils.Api;
import cn.nukkit.Server;
import cn.nukkit.Player;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.economyApiVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.playerPointsVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.OreAreaVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.RsTaskVariable;
import cn.stevei5mc.NewTipsVariables.Main;

public class loadSupportPlugins {
    
    public static void loadSupportVariables(Player player) {
        boolean debug = Main.getInstance().getConfig().getBoolean("debug", false);
        //加载相关插件的变量时的提示
        String debugPerfix = "§7[§cDEBUG§7] ";
        String loadPlugin;
        String loadSuccessMsg = Main.getInstance().getLanguage().getString("debug_plugins_found");
        String loadFailureMsg = Main.getInstance().getLanguage().getString("debug_plugins_not_found");
        //需要加载的变量的插件
        loadPlugin = "playerPoints";
        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin) != null) {
            //存在
            Api.registerVariables("playerPointsVariable", playerPointsVariable.class);
            if (debug) {
                Main.getInstance().getLogger().info(loadSuccessMsg.replace("{0}",loadPlugin));
            }

        } else {
            if (debug) {
                Main.getInstance().getLogger().info(loadFailureMsg.replace("{0}",loadPlugin));
            }
        }
        loadPlugin = "EconomyAPI";
        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin) != null) {
            //存在
            Api.registerVariables("economyApiVariable", economyApiVariable.class);
            if (debug) {
                Main.getInstance().getLogger().info(loadSuccessMsg.replace("{0}",loadPlugin));
            }
        } else {
            if (debug) {
                Main.getInstance().getLogger().info(loadFailureMsg.replace("{0}",loadPlugin));
            }
        }        
        loadPlugin = "OreArea";
        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin) != null) {
            //存在
            Api.registerVariables("OreAreaVariable", OreAreaVariable.class);
            if (debug) {
                Main.getInstance().getLogger().info(loadSuccessMsg.replace("{0}",loadPlugin));
            }
        } else {
            if (debug) {
                Main.getInstance().getLogger().info(loadFailureMsg.replace("{0}",loadPlugin));
            }
        }       
        loadPlugin = "RSTask";
        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin) != null) {
            Api.registerVariables("RsTaskVariable", RsTaskVariable.class);
            if (debug) {
                Main.getInstance().getLogger().info(loadSuccessMsg.replace("{0}",loadPlugin));
            }
        } else {
            if (debug) {
                Main.getInstance().getLogger().info(loadFailureMsg.replace("{0}",loadPlugin));
            }
        }
    }
}