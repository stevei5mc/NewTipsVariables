package cn.stevei5mc.NewTipsVariables.variables;

import AwakenSystem.data.DamageMath;
import AwakenSystem.data.baseAPI;
import AwakenSystem.data.defaultAPI;
import AwakenSystem.utils.nbtItems;
import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.stevei5mc.NewTipsVariables.utils.PluginsState;
import com.task.utils.tasks.PlayerFile;
import com.task.utils.tasks.taskitems.PlayerTask;
import healthapi.PlayerHealth;
import net.player.api.Point;
import ore.area.AreaMainClass;
import ore.area.utils.Tools;
import ore.area.utils.area.AreaClass;
import ore.area.utils.player.PlayerClass;
import tip.utils.variables.BaseVariable;
import weapon.items.Armor;
import weapon.items.Weapon;
import weapon.utils.PlayerAddAttributes;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class SmallasWaterPlugins extends BaseVariable {
    public SmallasWaterPlugins(Player player) {
        super(player);
    }

    public void strReplace() {
        if (player != null && player.isOnline()) {
            PluginsState ps = PluginsState.getInstance();
            if (ps.playerPoints) {
                playerPoint();
            }
            if (ps.rSTask) {
                RsTask(); 
            }
            if (ps.oreArea) {
                OreArea();
            }
            if (ps.healthAPI) {
                HealthAPI();
            }
            if (ps.rSWeapon) {
                RSWeapon();
            }
            if (ps.levelAwakenSystem) {
                LevelAwakenSystem();
            }
        }
    }
/**
 * @author SmallasWater
 */
    public void playerPoint() {
        addStrReplaceString("{point}", String.format("%.2f", Point.myPoint(player)));
    }

    public void RsTask() {
        PlayerFile file = PlayerFile.getPlayerFile(this.player.getName());
        LinkedList<PlayerTask> tasks = file.getInviteTasks();
        String taskName = "暂无";
        if (tasks.size() > 0) {
            PlayerTask task = (PlayerTask)tasks.get(0);
            if (task != null) {
              taskName = task.getTaskName();
            }
        }
        this.addStrReplaceString("{task-name}", taskName);
        this.addStrReplaceString("{task-count}", file.getCount() + "");
    }

    public void OreArea() {
        PlayerClass playerClass = PlayerClass.getPlayerClass(player.getName());
        addStrReplaceString("{orearea-level-this}", playerClass.getMaxAreaLevel() + "");
        addStrReplaceString("{orearea-level-next}", playerClass.getMaxAreaLevel() + 1 + "");
        //参考(复制但有改动) https://github.com/SmallasWater/OreArea/blob/master/src/main/java/ore/area/utils/OreAreaVariable.java
        AreaClass areaClass = Tools.getDefaultArea(player, 2);
        String time = "§c不在范围，无法获取可使用时间";
        String reset = "§c不在范围,无法获取刷新时间";
        String name = "§c没有解锁矿区";
        if(areaClass != null){
            if(AreaMainClass.getInstance().useTime.containsKey(player.getName())) {
                LinkedHashMap<String,Integer> map = AreaMainClass.getInstance().useTime.get(player.getName());
                if(map.containsKey(areaClass.getName())){
                    int i = Math.round(map.get(areaClass.getName()) /60);
                    if(i != 0) {
                        time = "§7" +i + "§2分钟";
                    }else{
                        time = "§7" +areaClass.getUseTime() + "§2秒";
                    }
                }
            }else{
                if(!areaClass.isKey()){
                    time = "§c未开启";
                }else{
                    if(playerClass.canKey(areaClass.getName())) {
                        if(areaClass.getUseTime() == -1) {
                            time = "§7无时限";
                        }else{
                            int i = Math.round(areaClass.getUseTime() /60);
                            if(i != 0) {
                                time = "§7" +i + "§2分钟";
                            }else{
                                time = "§7" +areaClass.getUseTime() + "§2秒";
                            }
                        }
                    }else{
                        time = "§c未解锁矿区";
                    }
                }
            }
            if(AreaMainClass.timer.containsKey(areaClass.getName())) {
                reset = String.valueOf(AreaMainClass.timer.get(areaClass.getName()));
            }else{
                reset = "§c未刷新";
            }
            name = areaClass.getName();
        }
        addStrReplaceString("{orearea-time-use}", time);
        addStrReplaceString("{orearea-time-reset}", reset);
        addStrReplaceString("{orearea-name}", name);
    }

    public void HealthAPI() {
        PlayerHealth health = PlayerHealth.getPlayerHealth(this.player);
        addStrReplaceString("{h}", String.format("%.1f", health.getHealth()));
        addStrReplaceString("{mh}", health.getMaxHealth() + "");
        addStrReplaceString("{hb}", String.format("%.2f", health.getHealthPercentage() * 100.0D));
    }

    public void RSWeapon() {
        try {
            Item item = this.player.getInventory().getItemInHand();
            Weapon weapon = Weapon.getInstance(item);
            String name = "§c无神器";
            int c = 0;
            if (weapon != null) {
                name = weapon.getName();
                if (!weapon.canUse(this.player)) {
                    name = name + " §c(无法使用)";
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
            String hetName = "§c无头盔";
            String chestName = "§c无胸凯";
            String leggingName = "§c无护腿";
            String bootName = "§c无靴子";
            Armor armorHet = Armor.getInstance(het);
            Armor armorChest = Armor.getInstance(chest);
            Armor armorLegging = Armor.getInstance(legging);
            Armor armorBoot = Armor.getInstance(boot);
            if (armorHet != null) {
                hetName = armorHet.getName();
                if (!armorHet.canUse(this.player)) {
                    hetName = hetName + " §c(无法使用)";
                }
                hSize = armorHet.getGemStones().size();
            }
            if (armorChest != null) {
                chestName = armorChest.getName();
                if (!armorChest.canUse(this.player)) {
                    chestName = chestName + " §c(无法使用)";
                }
                cSize = armorChest.getGemStones().size();
            }
            if (armorLegging != null) {
                leggingName = armorLegging.getName();
                if (!armorLegging.canUse(this.player)) {
                   leggingName = leggingName + " §c(无法使用)";
                }
                lSize = armorLegging.getGemStones().size();
            }
            if (armorBoot != null) {
                bootName = armorBoot.getName();
                if (!armorBoot.canUse(this.player)) {
                    bootName = bootName + " §c(无法使用)";
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
        } catch (Exception var23) {}
    }

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