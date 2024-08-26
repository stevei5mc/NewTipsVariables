package cn.stevei5mc.NewTipsVariables.utils;

public class PluginsState {
    
    private static PluginsState instance;


    public static PluginsState getInstance() {
        if (instance == null) {
            instance = new PluginsState();
        }
        return instance;
    }

    // 插件的状态
    public boolean playerPoints = false;
    public boolean EconomyAPI = false;
    public boolean OreArea = false;
    public boolean RSTask = false;
    public boolean HealthAPI = false;
    public boolean LevelAwakenSystem = false;
    public boolean RSWeapon = false;
    public boolean LuckPerms = false;

    public void setPluginState(String pluginName) {

    }
}