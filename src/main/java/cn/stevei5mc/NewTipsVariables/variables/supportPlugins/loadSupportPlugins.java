package cn.stevei5mc.NewTipsVariables.variables.supportPlugins;

import tip.utils.Api;
import cn.nukkit.Server;
import cn.nukkit.Player;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.economyApiVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.playerPointsVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.OreAreaVariable;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.RsTaskVariable;
import cn.stevei5mc.NewTipsVariables.Main;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater.HealthAPIVariable;

public class loadSupportPlugins{
    //加载相关插件的变量时的提示
    public static String debugPerfix = "§7[§cDEBUG§7] ";
    public static String successMsg = debugPerfix+"§a找到插件§e【§b{0}§e】§a相关变量已加载";
    public static String failureMsg = debugPerfix+"§c无法找到插件§e【§b{0}§e】§c相关变量加载失败,请安装相关插件再试";
    public static void loadSupportVariables(Player player) {
        boolean debug = Main.debug;
        String plugin;
        //需要加载的变量的插件
        plugin = "playerPoints";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            //存在
            Api.registerVariables("playerPointsVariable", playerPointsVariable.class);
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
        plugin = "EconomyAPI";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            //存在
            Api.registerVariables("economyApiVariable", economyApiVariable.class);
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
        plugin = "OreArea";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            //存在
            Api.registerVariables("OreAreaVariable", OreAreaVariable.class);
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }       
        plugin = "RSTask";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            Api.registerVariables("RsTaskVariable", RsTaskVariable.class);
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
        plugin = "HealthAPI";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            Api.registerVariables("HealthAPIVariable", HealthAPIVariable.class);
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
    }
}