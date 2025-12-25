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
            try{
                main.getLogger().info("Enabled: " + main.getServer().getPluginManager().getPlugin(plugin.getName()).isEnabled());
                main.getLogger().info("Disabled: " + main.getServer().getPluginManager().getPlugin(plugin.getName()).isDisabled());
                Class.forName(plugin.getMainClass());
                pluginsState.put(plugin.getName(), true);
                main.getLogger().info(Main.debugPrefix + "§a找到插件§e【§b" + plugin.getName() + "§e】§a相关变量已加载");
            }catch (Exception ignore) {
                pluginsState.put(plugin.getName(), false);
                main.getLogger().info(Main.debugPrefix + "§a无法找到插件§e【§b" + plugin.getName() + "§e】§a相相关变量加载失败,请安装相关插件再试");
            }
        }
    }

    public static boolean getPluginState(String pluginName) {
        return pluginsState.getOrDefault(pluginName, false);
    }
}