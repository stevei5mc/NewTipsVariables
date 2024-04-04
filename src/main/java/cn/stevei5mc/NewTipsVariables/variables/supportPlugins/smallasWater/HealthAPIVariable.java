package cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import healthapi.PlayerHealth;

public class HealthAPIVariable extends BaseVariable {
    public HealthAPIVariable(Player player) {
        super(player);
    }

    public void strReplace() {
        HealthAPIVar();
    }

    public void HealthAPIVar() {
        PlayerHealth health = PlayerHealth.getPlayerHealth(this.player);
        this.addStrReplaceString("{h}", String.format("%.1f", health.getHealth()));
        this.addStrReplaceString("{mh}", health.getMaxHealth() + "");
        this.addStrReplaceString("{hb}", String.format("%.2f", health.getHealthPercentage() * 100.0D));
    }
}