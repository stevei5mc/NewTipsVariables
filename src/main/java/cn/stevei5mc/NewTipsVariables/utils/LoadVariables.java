package cn.stevei5mc.NewTipsVariables.utils;

import cn.nukkit.Server;
import cn.stevei5mc.NewTipsVariables.Main;
import cn.stevei5mc.NewTipsVariables.variables.EconomyApiVariable;
import cn.stevei5mc.NewTipsVariables.variables.LuckPermsVar;
import cn.stevei5mc.NewTipsVariables.variables.SmallasWaterPlugins;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import tip.utils.Api;

import java.util.Arrays;
import java.util.List;

public class LoadVariables{
    private static LuckPerms luckperms;
    public static LuckPerms getLP() {
        return luckperms;
    }
    
    //需要加载的变量的插件
    public static void pluginVariables() {
        PluginsState.initPluginStates();

        PluginsState ps = PluginsState.getInstance();
        boolean debug = Main.debug;
        List<String> pluginList = Arrays.asList("playerPoints","EconomyAPI","OreArea","RSTask","HealthAPI","LevelAwakenSystem","RSWeapon","LuckPerms");
        /*for(String plugin: pluginList){
            if (Server.getInstance().getPluginManager().getPlugin(plugin) != null) {
                ps.setPluginState(plugin);
                if (debug) {Main.getInstance().getLogger().info(Main.debugPrefix+"§a找到插件§e【§b"+plugin+"§e】§a相关变量已加载");}
            } else if (debug) {
                Main.getInstance().getLogger().info(Main.debugPrefix+"§a无法找到插件§e【§b"+plugin+"§e】§a相相关变量加载失败,请安装相关插件再试");
            }
        }*/
//        Api.registerVariables("SmallasWaterPlugins", SmallasWaterPlugins.class);
//        if (ps.economyAPI) {
//            Api.registerVariables("EconomyApiVariable", EconomyApiVariable.class);
//        }
        if (PluginsState.getPluginsStates().get(PluginsListEnum.LUCK_PERMS.getName())) {
            luckperms = LuckPermsProvider.get();
            Api.registerVariables("LuckPermsVar", LuckPermsVar.class);
        }
    }
}