package cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import weapon.items.Armor;
import weapon.items.Weapon;
import weapon.utils.PlayerAddAttributes;
import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.Server;

public class RSWeaponVariable extends BaseVariable {   
    public RSWeaponVariable(Player player) {
        super(player);
    }

    public void strReplace() {
        RSWeapon();
    }

/**
 * @author SmallasWater
 */
    public void RSWeapon() {
        try {
            Item item = this.player.getInventory().getItemInHand();
            if (Server.getInstance().getPluginManager().getPlugin("RSWeapon") != null) {
               Weapon weapon = Weapon.getInstance(item);
               String name = TextFormat.RED + "无神器";
               int c = 0;
               if (weapon != null) {
                    name = weapon.getName();
                    if (!weapon.canUse(this.player)) {
                        name = name + TextFormat.RED + " (无法使用)";
                }
                c = weapon.getGemStones().size();
            }
                Item het = this.player.getInventory().getHelmet();
                Item chest = this.player.getInventory().getChestplate();
                Item legging = this.player.getInventory().getLeggings();
                Item boot = this.player.getInventory().getBoots();
                int hSize = 0;
                int cSize = 0;
                int lSize = 0;
                int bSize = 0;
                String hetName = TextFormat.RED + "无头盔";
                String chestName = TextFormat.RED + "无胸凯";
                String leggingName = TextFormat.RED + "无护腿";
                String bootName = TextFormat.RED + "无靴子";
                Armor armorHet = Armor.getInstance(het);
                Armor armorChest = Armor.getInstance(chest);
                Armor armorLegging = Armor.getInstance(legging);
                Armor armorBoot = Armor.getInstance(boot);
                if (armorHet != null) {
                    hetName = armorHet.getName();
                    if (!armorHet.canUse(this.player)) {
                        hetName = hetName + TextFormat.RED + " (无法使用)";
                    }
                    hSize = armorHet.getGemStones().size();
                }
                if (armorChest != null) {
                    chestName = armorChest.getName();
                    if (!armorChest.canUse(this.player)) {
                        chestName = chestName + TextFormat.RED + " (无法使用)";
                    }
                    cSize = armorChest.getGemStones().size();
                }
                if (armorLegging != null) {
                    leggingName = armorLegging.getName();
                    if (!armorLegging.canUse(this.player)) {
                        leggingName = leggingName + TextFormat.RED + " (无法使用)";
                    }
                    lSize = armorLegging.getGemStones().size();
                }
                if (armorBoot != null) {
                    bootName = armorBoot.getName();
                    if (!armorBoot.canUse(this.player)) {
                        bootName = bootName + TextFormat.RED + " (无法使用)";
                    }
                    bSize = armorBoot.getGemStones().size();
                }
                try {
                    PlayerAddAttributes playerAddAttributes = new PlayerAddAttributes();
                    this.string = playerAddAttributes.getStrReplace(this.player, this.string);
                } catch (Exception var22) {}
                this.addStrReplaceString("{头盔}", hetName);
                this.addStrReplaceString("{头盔宝石}", hSize + "");
                this.addStrReplaceString("{胸甲}", chestName);
                this.addStrReplaceString("{胸甲宝石}", cSize + "");
                this.addStrReplaceString("{护腿}", leggingName);
                this.addStrReplaceString("{护腿宝石}", lSize + "");
                this.addStrReplaceString("{靴子}", bootName);
                this.addStrReplaceString("{靴子宝石}", bSize + "");
                this.addStrReplaceString("{武器名称}", name);
                this.addStrReplaceString("{宝石个数}", c + "");
                this.addStrReplaceString("{we-damage}", PlayerAddAttributes.getDamage(this.player) + "");
                this.addStrReplaceString("{we-armor}", PlayerAddAttributes.getArmor(this.player) + "");
                this.addStrReplaceString("{we-health}", PlayerAddAttributes.getHealth(this.player) + "");
                this.addStrReplaceString("{we-kick}", String.format("%.2f", PlayerAddAttributes.getKick(this.player)));
                this.addStrReplaceString("{we-dkick}", String.format("%.2f", PlayerAddAttributes.getDKick(this.player)));
                this.addStrReplaceString("{we-todamage}", PlayerAddAttributes.getToDamage(this.player) + "");
            }
        } catch (Exception var23) {}
    }
}