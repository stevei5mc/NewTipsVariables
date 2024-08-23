package cn.stevei5mc.NewTipsVariables.variables;

import tip.utils.Api;
import cn.nukkit.Server;
import cn.nukkit.Player;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.economyApiVariable;
import cn.stevei5mc.NewTipsVariables.Main;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.SmallasWaterPlugins;
import cn.stevei5mc.NewTipsVariables.variables.supportPlugins.LuckPermsVar;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

public class LoadSupportPlugins{
    private static LuckPerms luckperms;
    public static LuckPerms getLP() {
        return luckperms;
    }

    public static boolean pl1 = false;
    public static boolean pl3 = false;
    public static boolean pl4 = false;
    public static boolean pl5 = false;
    public static boolean pl6 = false;
    public static boolean pl7 = false;
    //加载相关插件的变量时的提示
    public static String successMsg = Main.debugPrefix+"§a找到插件§e【§b{0}§e】§a相关变量已加载";
    public static String failureMsg = Main.debugPrefix+"§c无法找到插件§e【§b{0}§e】§c相关变量加载失败,请安装相关插件再试";
    //需要加载的变量的插件
    public static void loadSupportVariables(Player player) {
        boolean debug = Main.debug;
        String plugin;
        plugin = "playerPoints";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            pl1 = true;
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
        plugin = "EconomyAPI";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            Api.registerVariables("economyApiVariable", economyApiVariable.class);
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
        plugin = "OreArea";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            pl3 = true;
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }       
        plugin = "RSTask";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            pl4 = true;
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
        plugin = "HealthAPI";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            pl5 = true;
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
        plugin = "LevelAwakenSystem";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            pl6 = true;
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
        plugin = "RSWeapon";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            pl7 = true;
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
        Api.registerVariables("SmallasWaterPlugins", SmallasWaterPlugins.class);
        plugin = "LuckPerms";
        if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
            luckperms = LuckPermsProvider.get();
            Api.registerVariables("LuckPermsVar", LuckPermsVar.class);
            if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
        } else if (debug) {
            Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
        }
    }
}