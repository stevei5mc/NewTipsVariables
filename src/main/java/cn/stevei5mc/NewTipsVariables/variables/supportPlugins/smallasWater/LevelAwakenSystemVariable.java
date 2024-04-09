package cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import AwakenSystem.data.DamageMath;
import AwakenSystem.data.defaultAPI;
import AwakenSystem.data.baseAPI;
import AwakenSystem.utils.nbtItems;
import cn.nukkit.item.Item;

public class LevelAwakenSystemVariable extends BaseVariable {   
    public LevelAwakenSystemVariable(Player player) {
        super(player);
    }

    public void strReplace() {
        LevelAwakenSystem();
    }

/**
 * @author SmallasWater
 */
    public void LevelAwakenSystem() {
        Item item = this.player.getInventory().getItem(35);
        String add = null;
        if (nbtItems.can_use(this.player, item)) {
           add = nbtItems.getName(item);
        }
        this.addStrReplaceString("{天赋}", defaultAPI.getChatBySetting(this.player.getName()));
        this.addStrReplaceString("{level}", String.valueOf(defaultAPI.getPlayerAttributeInt(this.player.getName(), baseAPI.PlayerConfigType.LEVEL)));
        this.addStrReplaceString("{exp}", String.valueOf(defaultAPI.getPlayerAttributeInt(this.player.getName(), baseAPI.PlayerConfigType.EXP)));
        this.addStrReplaceString("{mexp}", String.valueOf(DamageMath.getUpDataEXP(this.player)));
        this.addStrReplaceString("{dw}", String.valueOf(defaultAPI.getPlayerFinalAttributeInt(this.player, baseAPI.ItemADDType.DAMAGE_W)));
        this.addStrReplaceString("{df}", String.valueOf(defaultAPI.getPlayerFinalAttributeInt(this.player, baseAPI.ItemADDType.DAMAGE_F)));
        this.addStrReplaceString("{dlw}", String.valueOf(defaultAPI.getPlayerFinalAttributeInt(this.player, baseAPI.ItemADDType.DEFENSE_W)));
        this.addStrReplaceString("{dlf}", String.valueOf(defaultAPI.getPlayerFinalAttributeInt(this.player, baseAPI.ItemADDType.DEFENSE_F)));
        this.addStrReplaceString("{b}", String.valueOf(defaultAPI.getPlayerFinalAttributeInt(this.player, baseAPI.ItemADDType.CRriT)));
        this.addStrReplaceString("{kb}", String.valueOf(defaultAPI.getPlayerFinalAttributeInt(this.player, baseAPI.ItemADDType.ANTI_RIOT)));
        this.addStrReplaceString("{kx}", String.valueOf(defaultAPI.getPlayerFinalAttributeInt(this.player, baseAPI.ItemADDType.RESISTANCE)));
        this.addStrReplaceString("{c}", String.valueOf(defaultAPI.getPlayerFinalAttributeInt(this.player, baseAPI.ItemADDType.PENETRATION)));
        this.addStrReplaceString("{饰品}", add != null ? add : "无");
        this.addStrReplaceString("{属性}", "null".equals(defaultAPI.getPlayerAttributeString(this.player.getName(), baseAPI.PlayerConfigType.ATTRIBUTE)) ? "无属性" : defaultAPI.getPlayerAttributeString(this.player.getName(), baseAPI.PlayerConfigType.ATTRIBUTE));
    }
}