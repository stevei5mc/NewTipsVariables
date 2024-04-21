package cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import ore.area.utils.player.PlayerClass;
import ore.area.utils.area.AreaClass;
import ore.area.utils.Tools;
import ore.area.AreaMainClass;
import java.util.LinkedHashMap;

public class OreAreaVariable extends BaseVariable {
    public OreAreaVariable(Player player) {
        super(player);
    }

    public void strReplace() {
        OreAreaVarPlayer();
        OreAreaVarArea();
    }

    public void OreAreaVarPlayer() {
        //这个代码的是复制TipsVeriable的
        PlayerClass playerClass = PlayerClass.getPlayerClass(player.getName());
        addStrReplaceString("{orearea-level-this}", playerClass.getMaxAreaLevel() + "");
        addStrReplaceString("{orearea-level-next}", playerClass.getMaxAreaLevel() + 1 + "");
    }

    //参考(复制但有改动) https://github.com/SmallasWater/OreArea/blob/master/src/main/java/ore/area/utils/OreAreaVariable.java
    public void OreAreaVarArea() {
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
                    PlayerClass playerClass = PlayerClass.getPlayerClass(player.getName());
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
}