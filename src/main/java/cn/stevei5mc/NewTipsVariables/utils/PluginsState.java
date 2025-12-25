package cn.stevei5mc.NewTipsVariables.utils;

import cn.stevei5mc.NewTipsVariables.Main;
import lombok.Getter;

import java.util.HashMap;

public class PluginsState {

    @Getter
    private static HashMap<String, Boolean> pluginsState;
    private static final Main main = Main.getInstance();


    public static void initPluginStates() {
        pluginsState = new HashMap<>();
        for (PluginsListEnum plugin: PluginsListEnum.values()) {
            checkPluginState(plugin);
        }
    }

    public static void checkPluginState(PluginsListEnum plugin) {
        try{
            Class.forName(plugin.getMainClass());
            setPluginsState(plugin.getName(), true);
            main.getLogger().info(Main.debugPrefix + "§a找到插件§e【§b" + plugin.getName() + "§e】§a相关变量已加载");
        }catch (Exception ignore) {
            setPluginsState(plugin.getName(), false);
            main.getLogger().info(Main.debugPrefix + "§a无法找到插件§e【§b" + plugin.getName() + "§e】§a相关变量加载失败,请安装相关插件再试");
        }
    }

    public static boolean getPluginState(String pluginName) {
        return pluginsState.getOrDefault(pluginName, false);
    }

    private static void setPluginsState(String pluginName, boolean state) {
        if(pluginsState.containsKey(pluginName)) {
            pluginsState.replace(pluginName, state);
        }else {
            pluginsState.put(pluginName, state);
        }
    }
}