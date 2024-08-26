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
    public boolean economyAPI = false;
    public boolean oreArea = false;
    public boolean rSTask = false;
    public boolean healthAPI = false;
    public boolean levelAwakenSystem = false;
    public boolean rSWeapon = false;
    public boolean luckPerms = false;

    public void setPluginState(String pluginName) {
        switch (pluginName) {
            case "playerPoints":
                playerPoints = true;
                break;
            case "EconomyAPI":
                economyAPI = true;
                break;
            case "OreArea":
                oreArea = true;
                break;
            case "RSTask":
                rSTask = true;
                break;
            case "HealthAPI":
                healthAPI = true;
                break;
            case "LevelAwakenSystem":
                levelAwakenSystem = true;
                break;
            case "RSWeapon":
                rSWeapon = true;
                break;
            case "LuckPerms":
                luckPerms = true;
                break;
            default:
                // 对于其他插件，不做任何操作，因为没有必要
                break;
        }
    }
}