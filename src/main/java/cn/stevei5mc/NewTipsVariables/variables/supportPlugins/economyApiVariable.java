package cn.stevei5mc.NewTipsVariables.variables.supportPlugins;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import me.onebone.economyapi.EconomyAPI;

public class economyApiVariable extends BaseVariable {
    public economyApiVariable(Player player) {
        super(player);
    }

    public void strReplace() {
        economyApi();
    }

    public void economyApi() {
        this.addStrReplaceString("{economy}", String.format("%.2f", EconomyAPI.getInstance().myMoney(player)));
    }
}