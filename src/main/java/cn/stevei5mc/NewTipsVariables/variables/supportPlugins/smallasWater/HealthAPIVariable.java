package cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import healthapi.PlayerHealth;
import cn.stevei5mc.NewTipsVariables.Main;

public class HealthAPIVariable extends BaseVariable {   
    public HealthAPIVariable(Player player) {
        super(player);
    }

    public void strReplace() {
        HealthAPIVar();
    }

/**
 * @author SmallasWater
 */
    public void HealthAPIVar() {
        PlayerHealth health = PlayerHealth.getPlayerHealth(this.player);
        addStrReplaceString("{h}", String.format("%.1f", health.getHealth()));
        addStrReplaceString("{mh}", health.getMaxHealth() + "");
        addStrReplaceString("{hb}", String.format("%.2f", health.getHealthPercentage() * 100.0D));
    }
}