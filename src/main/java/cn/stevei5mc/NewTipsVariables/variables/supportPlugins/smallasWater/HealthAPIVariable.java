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

    public void HealthAPIVar() {
        PlayerHealth health = PlayerHealth.getPlayerHealth(this.player);
        addStrReplaceString("{h}", String.format("%.1f", health.getHealth()));
        addStrReplaceString("{mh}", health.getMaxHealth() + "");
        addStrReplaceString("{hb}", String.format("%.2f", health.getHealthPercentage() * 100.0D));
        addStrReplaceString("{Player-Health}", this.getPlayerHealth(player));
    }

    public String getPlayerHealth(Player player) {
        PlayerHealth health = PlayerHealth.getPlayerHealth(this.player);
        String playerHealthLowColor = Main.getInstance().getConfigInPlayer().getString("HP.low_color");//low值
        int playerHealthMediumValue = Main.getInstance().getConfigInPlayer().getInt("HP.medium_value");//medium值
        String playerHealthMediumColor = Main.getInstance().getConfigInPlayer().getString("HP.medium_color");
        int playerHealthHgihValue = Main.getInstance().getConfigInPlayer().getInt("HP.high_value");//hgih值
        String playerHealthHgihColor = Main.getInstance().getConfigInPlayer().getString("HP.high_color");
        String playerHealth;
        double healthValue = health.getHealth();
        String healthValue2 = String.valueOf(healthValue);
        String healthMaxValue = String.valueOf(health.getMaxHealth());
        //low=1
        if (healthValue >= playerHealthHgihValue) {
            playerHealth = playerHealthHgihColor.replace("{0}",healthValue2).replace("{1}",healthMaxValue);
        }else if (healthValue >= playerHealthMediumValue) {
            playerHealth = playerHealthMediumColor.replace("{0}",healthValue2).replace("{1}",healthMaxValue);
        }else {
            playerHealth = playerHealthLowColor.replace("{0}",healthValue2).replace("{1}",healthMaxValue);
        }
        return playerHealth;
    }
}