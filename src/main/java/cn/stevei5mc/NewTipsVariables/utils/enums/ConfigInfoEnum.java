package cn.stevei5mc.NewTipsVariables.utils.enums;

import lombok.Getter;

public enum ConfigInfoEnum {

    DEFAULT_CONFIG("config", 2),
    PLAYER_VAR_INFO_CONFIG("player", 2),
    SERVER_VAR_INFO_CONFIG("server", 2),
    WORLD_NAME_CONFIG("world_name"),
    LANGUAGE_CONFIG("language");

    @Getter
    private final String name;
    @Getter
    private final int latestVersion;
    @Getter
    private final String path;

    ConfigInfoEnum(String name) {
        this.name = name + ".yml";
        this.path = "/" + this.name;
        this.latestVersion = 0;
    }

    ConfigInfoEnum(String name, int latestVersion) {
        this.name = name + ".yml";
        this.path = "/" + this.name;
        this.latestVersion = latestVersion;
    }
}