package cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import net.player.api.Point;

public class playerPointsVariable extends BaseVariable {
    public playerPointsVariable(Player player) {
        super(player);
    }

    public void strReplace() {
        playerPoint();
    }

    public void playerPoint() {
        this.addStrReplaceString("{point}", String.format("%.2f", Point.myPoint(player))); //这个代码的是复制TipsVeriable的
    }
}