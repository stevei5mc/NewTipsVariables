[![0](https://img.shields.io/badge/%3C%3D-%E8%BF%94%E5%9B%9E-a?style=plastic&color=yellow)](../../README.md)
[![1](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E5%9F%BA%E7%A1%80%E5%8F%98%E9%87%8F-%E5%95%8A?style=plastic&color=blue)](../Variables/base-variables.md)
[![2](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E6%94%AF%E6%8C%81%E7%9A%84%E6%8F%92%E4%BB%B6-a?style=plastic&color=blue)](../Variables/SupportPluginsVariables.md)
[![3](https://img.shields.io/badge/%E6%96%87%E6%A1%A3-config.yml-a?style=plastic&color=blue)](config.md)
[![4](https://img.shields.io/badge/%E6%96%87%E6%A1%A3-player.yml-a?style=plastic)](player.md)
[![5](https://img.shields.io/badge/%E6%96%87%E6%A1%A3-server.yml-a?style=plastic&color=blue)](server.md)
# **player.yml**
**[查看原文件](../../src/main/resources/player.yml)**

<details>
<summary>player.yml</summary>

```yaml
#使用说明:
#https://github.com/stevei5mc/NewTipsVariables/blob/main/README.md
#https://gitee.com/stevei5mc/NewTipsVariables/blob/main/README.md
#配置文件版本，勿动
version: 2
Device:
  OS:
    Android: "Android"
    iOS: "iOS"
    macOS: "macOS"
    Fire_OS: "Fire OS"
    Gear_VR: "Gear VR"
    HoloLens: "HoloLens"
    Windows_10: "Windows 10"
    Windows: "Windows"
    Dedicated: "Dedicated"
    tvOS: "tvOS"
    PlayStation: "PlayStation"
    Switch: "Switch"
    Xbox: "Xbox"
    Windows_Phone: "Windows Phone"
  Controls:
    Keyboard: Keyboard
    Touch: Touch
    pad: pad
    motion_controller: motion_controller
  UIProfile:
    classic: "classic ui"
    pocket: "pocket ui"
ping:
  value:
    medium: 80
    high: 120
  color:
    low: "§c"
    medium: "§e"
    high: "§a"
HP:
  value:
    medium: 9
    high: 15
  color:
    low: "§c"
    medium: "§e"
    high: "§a"
  dynamic:
    low: "§c{0}§7/§c{1}"
    medium: "§e{0}§7/§e{1}"
    high: "§a{0}§7/§a{1}"
Food:
  value:
    medium: 9
    high: 15
  color:
    empty: "§7{0}/{1}"
    low: "§c{0}§7/§c{1}"
    medium: "§e{0}§7/§e{1}"
    high: "§a{0}§7/§a{1}"
```

</details>

## **讲解**

- **配置项说明**

1. **`ping` 玩家的延迟**
2. **`HP`  玩家的血量**
    - **该配置项会有`dynamic`的子配置项，作用跟`color`子配置项相同**
3. **`Food` 玩家的饥饿值**
4. **`Device`玩家的设备信息**
    - **`OS`玩家的设备系统**
    - **`Controls`获取玩家设备的操作方式**
    - **`UIProfile`玩家的设备UI**
5. `color`设置显示的颜色，`low`、`medium`、`high`为显示的范围
    - **注：`Food`配置项会多出`empty`范围的配置项**
6. `value`是一个范围值，`medium`、`high` 为可设置的范围值
    - **注：`empty`值只能为`0`（只在`Food`配置项存在），`low`值只能为`0`或`1`，这两个范围值不可更改**