package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Level;
import cn.stevei5mc.NewTipsVariables.utils.GetConfigInfo;
import tip.utils.variables.BaseVariable;

public class BaseVariables extends BaseVariable {
    public BaseVariables(Player player) {
        super(player);
    }

    public void strReplace() {
        if (player != null && player.isOnline()) {
            text();
            player();
            server();
            unicode();
        }
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
        addStrReplaceString("{Player-Yaw}",String.valueOf((int) player.getYaw()));
        addStrReplaceString("{Player-Pitch}",String.valueOf((int) player.getPitch()));
        addStrReplaceString("{Player-HeadYaw}",String.valueOf((int) player.getHeadYaw()));
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
        addStrReplaceString("{Server-Tps}", GetConfigInfo.getServerTps());
    }

    public void unicode() {
        String start = "\\ue000";
        String end = "\\uf8ff";
        // 解析起始和结束的Unicode码点（code point），从字符串的第三个字符开始，以16进制进行解析。
        int startCodePoint = Integer.parseInt(start.substring(2), 16);
        int endCodePoint = Integer.parseInt(end.substring(2), 16);
        // 从起始码点遍历到结束码点。
        for (int i = startCodePoint; i <= endCodePoint; i++) {
            String hex = String.format("%04X", i);
            String key = "{" + hex.toUpperCase() + "}"; // 生成替换的键（将16进制数转换为大写并放在大括号内）
            String value = new String(Character.toChars(i)); // 将键对应的值转为unicode码
            addStrReplaceString(key, value);
        }
    }
}