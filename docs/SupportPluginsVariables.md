[![0](https://img.shields.io/badge/%3C%3D-%E8%BF%94%E5%9B%9E-a?style=plastic&color=yellow)](.././README.md)
[![1](https://img.shields.io/badge/doc-%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E8%AF%B4%E6%98%8E-a?style=plastic&color=blue)
](./config-info.md)
[![2](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E6%96%87%E5%AD%97%E7%9B%B8%E5%85%B3-a?style=plastic&color=blue)
](./text-variables.md)
[![3](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E7%8E%A9%E5%AE%B6%E7%9B%B8%E5%85%B3-a?style=plastic&color=blue)
](./player-variables.md)
[![4](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E6%9C%8D%E5%8A%A1%E5%99%A8%E7%9B%B8%E5%85%B3-a?style=plastic&color=blue)
](./server-variables.md)
[![5](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E6%94%AF%E6%8C%81%E7%9A%84%E6%8F%92%E4%BB%B6-a?style=plastic)
](./SupportPluginsVariables.md)
# **变量文档(支持的插件)**
---
- **按插件的英文字母排序**  
- **TipsVeriable 相关变量移值中,部分变量名有改动**
---
## **[EconomyAPI](https://github.com/Nukkit-coders/EconomyAPI)**
|变量名|变量介绍|
|:-:|:-:|
|{economyApi-money}|玩家金钱数量|
---
## **[HealthAPI](https://github.com/SmallasWater/HealthAPI)**
|变量名|变量介绍|
|:-:|:-:|
|{h}|玩家血量|
|{mh}|玩家血量上限|
|{hb}|玩家血量百分比|
---
## **[LevelAwakenSystem](https://github.com/SmallasWater/LevelAwakenSystem)**
|变量名|变量介绍|
|:-:|:-:|
|{属性}|玩家的RPG属性|
|{天赋}|玩家评分|
|{level}|玩家等级|
|{exp}|玩家当前经验|
|{mexp}|玩家当前经验最大值|
|{dw}|玩家物理攻击|
|{df}|玩家法术攻击|
|{dlw}|玩家物理防御|
|{dlf}|玩家法术防御|
|{b}|玩家暴击|
|{kb}|玩家抗暴|
|{kx}|玩家抗性|
|{c}|玩家穿透|
|{饰品}|玩家当前装备的饰品|
|{pvp}|玩家PVP 状态 (暂时不可用)|
## **[LuckPerms](https://luckperms.net/)**
- **LuckPerms相关变量名请以该文档为准，仅有部分变量名跟官方给出的变量名一至**
|变量名|变量介绍|
|:-:|:-:|
|{LuckPerms-prefix}|获取玩家的prefix(前缀)|
|{LuckPerms-suffix}|获取玩家的suffix(后缀)|
|{LuckPerms-group}|获取玩家所在的权限组|
---
## **[OreArea](https://github.com/SmallasWater/OreArea)**
**注意: 变量`{orearea-time-use}`在有限时的矿区会有BUG(到秒就不动了)**
|变量名|变量介绍|
|:-:|:-:|
|{orearea-level-this}|获取玩家的矿区等级|
|{orearea-level-next}|获取玩家的矿区下一等级|
|{orearea-time-use}|获取玩家所在的矿区可以使用的时间|
|{orearea-time-reset}|获取玩家所在的刷新时间|
|{orearea-name}|获取玩家所在的矿区等级|
---
## **[playerPoints](https://github.com/SmallasWater/PlayerPoints)**
|变量名|变量介绍|
|:-:|:-:|
|{point}|获取玩家的点券数量|
---
## **[RsTask](https://github.com/MemoriesOfTime/RSTask)**
|变量名|变量介绍|
|:-:|:-:|
|{task-name}|正在进行中的任务 (显示第一个)|
|{task-count}|玩家任务积分|
---
## **[RsWeapon](https://github.com/SmallasWater/RsWeapon)**
|变量名|变量介绍|
|:-:|:-:|
|{武器名称}|玩家手持武器的名称|
|{宝石个数}|玩家手持武器的宝石个数|
|{头盔}|玩家装备的头盔|
|{胸甲}|玩家装备的胸甲|
|{护腿}|玩家装备的护腿|
|{靴子}|玩家装备的靴子|
|{头盔宝石}|玩家装备的头盔宝石个数|
|{胸甲宝石}|玩家装备的胸甲宝石个数|
|{护腿宝石}|玩家装备的护腿宝石个数|
|{靴子宝石}|玩家装备的靴子宝石个数|
|{we-damage}|玩家武器攻击力|
|{we-armor}|玩家盔甲护甲值|
|{we-health}|玩家盔甲生命值|
|{we-kick}|玩家武器击退值|
|{we-dkick}|玩家盔甲抗击退值|
|{we-todamage}|玩家盔甲反伤百分比|
---