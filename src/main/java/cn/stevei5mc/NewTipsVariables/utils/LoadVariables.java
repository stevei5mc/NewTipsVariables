package cn.stevei5mc.NewTipsVariables.utils;

import cn.stevei5mc.NewTipsVariables.variables.EconomyApiVariable;
import cn.stevei5mc.NewTipsVariables.variables.LuckPermsVar;
import cn.stevei5mc.NewTipsVariables.variables.SmallasWaterPlugins;
import lombok.Getter;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import tip.utils.Api;

public class LoadVariables{
    @Getter
    private static LuckPerms luckperms;
    
    //需要加载的变量的插件
    public static void pluginVariables() {
        PluginsState.initPluginStates();

        Api.registerVariables("SmallasWaterPlugins", SmallasWaterPlugins.class);
        if (PluginsState.getPluginState(PluginsListEnum.ECONOMY_API.getName())) {
            Api.registerVariables("EconomyApiVariable", EconomyApiVariable.class);
        }
        if (PluginsState.getPluginState(PluginsListEnum.LUCK_PERMS.getName())) {
            luckperms = LuckPermsProvider.get();
            Api.registerVariables("LuckPermsVar", LuckPermsVar.class);
        }
    }
}