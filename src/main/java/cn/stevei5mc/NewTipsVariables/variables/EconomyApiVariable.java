package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import me.onebone.economyapi.EconomyAPI;
import tip.utils.variables.BaseVariable;

public class EconomyApiVariable extends BaseVariable {
    public EconomyApiVariable(Player player) {
        super(player);
    }

    public void strReplace() {
        if (player != null && player.isOnline()) {
            economyApi();
        }
    }

    public void economyApi() {
        addStrReplaceString("{economyApi-money}", String.format("%.2f", EconomyAPI.getInstance().myMoney(player))); //这个代码的是复制TipsVeriable的
    }
}