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
        addStrReplaceString("{economyApi-money}", String.format("%.2f", EconomyAPI.getInstance().myMoney(player))); //这个代码的是复制TipsVeriable的
    }
}