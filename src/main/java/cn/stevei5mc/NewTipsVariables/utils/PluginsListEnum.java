package cn.stevei5mc.NewTipsVariables.utils;

public enum PluginsListEnum {

    PLAYER_POINTS("playerPoints", "net.player.PlayerPoint"),
    ECONOMY_API("EconomyAPI", "me.onebone.economyapi.EconomyAPI"),
    ORE_AREA("OreArea", "ore.area.AreaMainClass"),
    RS_TASK("RSTask", "com.task.RsTask"),
    HEALTH_API("HealthAPI", "healthapi.HealthMainClass"),
    LEVEL_AWAKEN_SYSTEM("LevelAwakenSystem", "AwakenSystem.AwakenSystem"),
    RS_WEAPON("RSWeapon", "weapon.RsWeapon"),
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
