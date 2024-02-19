[返回](../README.md) [支持的插件](./SupportPluginsVariables.md)
# **配置文件使用说明**
> **若未在此说明中写配置项出则代表该配置项还没有支持**
## **[config.yml](../src/main/resources/config.yml)**
> **主配置文件**
### **是否释放新的变量说明文档**
```
save-variables-doc: true
```
> **1、该配置项启用后，服务器每次启动后都会生成新的变量文档**  
> **2、若关闭后，就算删除变量文档也不会生成新的变量文档**  
> **3、该配置项默认启用**
## **[server.yml](../src/main/resources/server.yml)**
> **服务器相关变量配置文件**
```
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
```
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
    Unknown: "未知的系统"
  UIProfile:
    classic: "classic ui"
    pocket: "pocket ui"
    Unknown: "Unknown ui
```
> 1、**```OS```玩家的设备系统**  
> 2、**```UIProfile```玩家的设备UI**
```
ping:
  low_color: "§a"
  medium_value: 80
  medium_color: "§e"
  high_value: 120
  high_color: "§c"
HP:
  symbols: "§7/"
  low_color: "§c"
  medium_value: 9
  medium_color: "§e"
  high_value: 15
  high_color: "§a"
Food:
  symbols: "§7/"
  low_color: "§c"
  medium_value: 9 
  medium_color: "§e"
  high_value: 15
  high_color: "§a"
```
> **1、```color```设置显示的颜色，```low```、```medium```、```high```为显示的范围**  
> **2、```value```是一个范围值，```medium```、```high```为可设置的范围值，```low```值只能为```0```**  
> **3、```symbols```是用来设置分割符号的，例如: ```HP: 20/20```**