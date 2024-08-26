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
import cn.stevei5mc.NewTipsVariables.utils.PluginsState;
import java.util.*;

public class LoadSupportPlugins{
    private static LuckPerms luckperms;
    public static LuckPerms getLP() {
        return luckperms;
    }
    
    //需要加载的变量的插件
    public static void loadSupportVariables(Player player) {
        PluginsState ps = PluginsState.getInstance();
        String successMsg = Main.debugPrefix+"§a找到插件§e【§b{0}§e】§a相关变量已加载";
        String failureMsg = Main.debugPrefix+"§c无法找到插件§e【§b{0}§e】§c相关变量加载失败,请安装相关插件再试";
        boolean debug = Main.debug;
        List<String> pluginList = Arrays.asList("playerPoints","EconomyAPI","OreArea","RSTask","HealthAPI","LevelAwakenSystem","RSWeapon","LuckPerms");
        for(String plugin: pluginList){
            if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
                ps.setPluginState(plugin);
                if (debug) {Main.getInstance().getLogger().info(successMsg.replace("{0}",plugin));}
            } else if (debug) {
                Main.getInstance().getLogger().info(failureMsg.replace("{0}",plugin));
            }
        }
        Api.registerVariables("SmallasWaterPlugins", SmallasWaterPlugins.class);
        if (ps.economyAPI) {
            Api.registerVariables("economyApiVariable", economyApiVariable.class);
        }
        if (ps.luckPerms) {
            luckperms = LuckPermsProvider.get();
            Api.registerVariables("LuckPermsVar", LuckPermsVar.class);
        }
    }
}