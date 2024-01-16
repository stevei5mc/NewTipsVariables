package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;

public class tipstext extends BaseVariable {
    public tipstext(Player player) {
        super(player);
    }

    public void strReplace() {
        tc();
    }

    public void tc() {
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
}