package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import cn.nukkit.Server;
import cn.nukkit.level.Level;
import cn.stevei5mc.NewTipsVariables.utils.GetConfigInfo;

public class BaseVariables extends BaseVariable {
    public BaseVariables(Player player) {
        super(player);
    }

    public void strReplace() {
        text();
        player();
        server();
    }

    public void text() {
        addStrReplaceString("{text-s0}", "§0");
        addStrReplaceString("{text-s1}", "§1");
        addStrReplaceString("{text-s2}", "§2");
        addStrReplaceString("{text-s3}", "§3");
        addStrReplaceString("{text-s4}", "§4");
        addStrReplaceString("{text-s5}", "§5");
        addStrReplaceString("{text-s6}", "§6");
        addStrReplaceString("{text-s7}", "§7");
        addStrReplaceString("{text-s8}", "§8");
        addStrReplaceString("{text-s9}", "§9");
        addStrReplaceString("{text-sa}", "§a");
        addStrReplaceString("{text-sb}", "§b");
        addStrReplaceString("{text-sc}", "§c");
        addStrReplaceString("{text-sd}", "§d");
        addStrReplaceString("{text-se}", "§e");
        addStrReplaceString("{text-sf}", "§f");
        addStrReplaceString("{text-bold}", "§l");
        addStrReplaceString("{text-italic}", "§o");
        addStrReplaceString("{text-reset}", "§r");
        addStrReplaceString("{text-mess}", "§k");
        addStrReplaceString("{text-next}", "\n");
    }

    public void player() {
        addStrReplaceString("{Player-Xp}", String.valueOf(player.getExperienceLevel()));
        addStrReplaceString("{Device-Model}", player.getLoginChainData().getDeviceModel());
        addStrReplaceString("{XUID}", String.valueOf(player.getLoginChainData().getXUID()));
        addStrReplaceString("{Player-Lang}", player.getLoginChainData().getLanguageCode());
        addStrReplaceString("{Player-Uuid}", String.valueOf(player.getLoginChainData().getClientUUID()));
        int yaw = (int) player.getYaw();
        addStrReplaceString("{Player-Yaw}",String.valueOf(yaw));
        int pitch = (int) player.getPitch();
        addStrReplaceString("{Player-Pitch}",String.valueOf(pitch));
        int headYaw = (int) player.getHeadYaw();
        addStrReplaceString("{Player-HeadYaw}",String.valueOf(headYaw));
        addStrReplaceString("{Player-World}", GetConfigInfo.getPlayerWorld(player));
        addStrReplaceString("{Player-Ping}", GetConfigInfo.getPlayerPing(player));
        addStrReplaceString("{Player-Health}", GetConfigInfo.getPlayerHealth(player));
        addStrReplaceString("{Player-Food}", GetConfigInfo.getPlayerFood(player));
        addStrReplaceString("{Player-Ui}", GetConfigInfo.getPlayerUi(player.getLoginChainData().getUIProfile()));
        addStrReplaceString("{Player-Controls}",GetConfigInfo.getDeviceControls(player.getLoginChainData().getCurrentInputMode()));
        addStrReplaceString("{Device-Os}", GetConfigInfo.getDeviceOS(player.getLoginChainData().getDeviceOS()));
    }

    public void server() {
        addStrReplaceString("{Server-Motd}", Server.getInstance().getMotd());
        addStrReplaceString("{Server-SubMotd}", Server.getInstance().getSubMotd());
        addStrReplaceString("{Server-Ip}", Server.getInstance().getIp());
        addStrReplaceString("{Server-Port}", String.valueOf(Server.getInstance().getPort()));
        //参考了RsNpcVariable的写法
        for (Level level : Server.getInstance().getLevels().values()) {
            addStrReplaceString("{WorldOnline@"+ level.getFolderName() +"}", String.valueOf(level.getPlayers().size()));
        }
        addStrReplaceString("{Server-Tps}", GetConfigInfo.getServerTps(player));
    }
}