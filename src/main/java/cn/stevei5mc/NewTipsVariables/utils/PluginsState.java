package cn.stevei5mc.NewTipsVariables.utils;

import cn.stevei5mc.NewTipsVariables.Main;
import lombok.Getter;

import java.util.HashMap;

public class PluginsState {
    
    private static PluginsState instance;
    @Getter
    private static HashMap<String, Boolean> pluginsStates;
    private static Main main = Main.getInstance();


    public static void initPluginStates() {
        pluginsStates = new HashMap<>();
        for (PluginsListEnum plugin: PluginsListEnum.values()) {
            try{
                Class.forName(plugin.getMainClass());
                pluginsStates.put(plugin.getName(), true);
                main.getLogger().info(Main.debugPrefix + "§a找到插件§e【§b" + plugin.getName() + "§e】§a相关变量已加载");
            }catch (Exception ignore) {
                pluginsStates.put(plugin.getName(), false);
                main.getLogger().info(Main.debugPrefix + "§a无法找到插件§e【§b" + plugin.getName() + "§e】§a相相关变量加载失败,请安装相关插件再试");
            }
        }
    }

    public static boolean getPluginState(String pluginName) {
        return pluginsStates.getOrDefault(pluginName, false);
    }

    public static PluginsState getInstance() {
        if (instance == null) {
            instance = new PluginsState();
        }
        return instance;
    }

    // 插件的状态
    public boolean playerPoints = false;
    public boolean oreArea = false;
    public boolean rSTask = false;
    public boolean healthAPI = false;
    public boolean levelAwakenSystem = false;
    public boolean rSWeapon = false;

}