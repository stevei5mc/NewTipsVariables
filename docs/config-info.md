[![0](https://img.shields.io/badge/%3C%3D-%E8%BF%94%E5%9B%9E-a?style=plastic&color=yellow)](.././README.md) [![1](https://img.shields.io/badge/doc-%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E8%AF%B4%E6%98%8E-a?style=plastic)](./config-info.md) [![1](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E6%96%87%E5%AD%97%E7%9B%B8%E5%85%B3-a?style=plastic&color=blue)](./text-variables.md)
[![2](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E7%8E%A9%E5%AE%B6%E7%9B%B8%E5%85%B3-a?style=plastic&color=blue)](./player-variables.md)
[![3](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E6%9C%8D%E5%8A%A1%E5%99%A8%E7%9B%B8%E5%85%B3-a?style=plastic&color=blue)](./server-variables.md)
[![4](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E6%94%AF%E6%8C%81%E7%9A%84%E6%8F%92%E4%BB%B6-a?style=plastic&color=blue)](./SupportPluginsVariables.md)

---
# **配置文件使用说明**
> **若未在此说明中写配置项出则代表该配置项还没有支持**
## **[config.yml](../src/main/resources/config.yml)**
> **主配置文件**
### **是否释放新的变量说明文档**
```yml
save-variables-doc: true
```
> **1、该配置项启用后，服务器每次启动后都会生成新的变量文档**  
> **2、若关闭后，就算删除变量文档也不会生成新的变量文档**  
> **3、该配置项默认启用**
### **debug功能**
```yml
debug: false
```
> 1、这个功能默认关闭并不在配置文件中，需要手动填写  
> 2、把`debug: true`复制进`config.yml`即可启用
## **[server.yml](../src/main/resources/server.yml)**
> **服务器相关变量配置文件**
```yml
TPS:
  low_color: "§c"
  medium_value: 9
  medium_color: "§e"
  high_value: 15
  high_color: "§a"
```
> **1、```color```设置显示的颜色，```low```、```medium```、```high```为显示的范围**  
> **2、```value```是一个范围值，```medium```、```high```为可设置的范围值，```low```值只能为```0```**
## **[player.yml](../src/main/resources/player.yml)**
> **玩家相关变量配置文件**
```yml
Device:
  OS:
    Android: "安卓"
    iOS: "苹果"
    macOS: "苹果但是电脑"
    Fire_OS: "Fire_OS"
    Gear_VR: "Gear_VR"
    HoloLens: "HoloLens"
    Windows_10: "Windows 10"
    Windows: "Windows"
    Dedicated: "Dedicated"
    tvOS: "tvOS"
    PlayStation: "PlayStation"
    Switch: "Switch"
    Xbox: "Xbox"
    Windows_Phone: "windows但是手机"
  UIProfile:
    classic: "classic ui"
    pocket: "pocket ui"
```
> 1、**```OS```玩家的设备系统**  
> 2、**```UIProfile```玩家的设备UI**
```yml
ping:
  low_color: "§a"
  medium_value: 80
  medium_color: "§e"
  high_value: 120
  high_color: "§c"
HP:
  low_color: "§c{0}§7/§c{1}"
  medium_value: 9
  medium_color: "§e{0}§7/§e{1}"
  high_value: 15
  high_color: "§a{0}§7/§a{1}"
Food:
  empty_color: "§7{0}/{1}"
  low_color: "§c{0}§7/§c{1}"
  medium_value: 9 
  medium_color: "§e{0}§7/§e{1}"
  high_value: 15
  high_color: "§a{0}§7/§a{1}"
```
> **1、```color```设置显示的颜色，```low```、```medium```、```high```为显示的范围**  
> **2、```value```是一个范围值，```medium```、```high```为可设置的范围值，```low```值只能为```0```**  
> **3、```symbols```是用来设置分割符号的，例如: ```HP: 20/20```**