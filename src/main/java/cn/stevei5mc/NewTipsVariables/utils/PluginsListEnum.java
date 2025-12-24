package cn.stevei5mc.NewTipsVariables.utils;

public enum PluginsListEnum {

//    PLAYER_POINTS("playerPoints"),
    ECONOMY_API("EconomyAPI", "me.onebone.economyapi.EconomyAPI"),
//    ORE_AREA("OreArea"),
//    RS_TASK("RSTask"),
//    HEALTH_API("HealthAPI"),
//    LEVEL_AWAKEN_SYSTEM("LevelAwakenSystem"),
//    RS_WEAPON("RSWeapon"),
    LUCK_PERMS("LuckPerms", "net.luckperms.api.LuckPermsProvider");

    private final String name;
    private final String mainClass;

    PluginsListEnum(String name, String mainClass) {
        this.name = name;
        this.mainClass = mainClass;
    }

    public String getName() {
        return name;
    }

    public String getMainClass() {
        return mainClass;
    }
}
