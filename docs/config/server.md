[![0](https://img.shields.io/badge/%3C%3D-%E8%BF%94%E5%9B%9E-a?style=plastic&color=yellow)](../../README.md)
[![1](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E5%9F%BA%E7%A1%80%E5%8F%98%E9%87%8F-%E5%95%8A?style=plastic&color=blue)](../Variables/base-variables.md)
[![2](https://img.shields.io/badge/%E5%8F%98%E9%87%8F-%E6%94%AF%E6%8C%81%E7%9A%84%E6%8F%92%E4%BB%B6-a?style=plastic&color=blue)](../Variables/SupportPluginsVariables.md)
[![3](https://img.shields.io/badge/%E6%96%87%E6%A1%A3-config.yml-a?style=plastic&color=blue)](config.md)
[![4](https://img.shields.io/badge/%E6%96%87%E6%A1%A3-player.yml-a?style=plastic&color=blue)](player.md)
[![5](https://img.shields.io/badge/%E6%96%87%E6%A1%A3-server.yml-a?style=plastic)](server.md)

# **server.yml**

**[查看原文件](../src/main/resources/server.yml)**

<details>
<summary>server.yml</summary>

```yaml
#使用说明:
#https://github.com/stevei5mc/NewTipsVariables/blob/main/README.md
#https://gitee.com/stevei5mc/NewTipsVariables/blob/main/README.md
#配置文件版本，勿动
version: 2
TPS:
  value:
    medium: 9
    high: 15
  color:
    low: "§c"
    medium: "§e"
    high: "§a"
```

</details>

## **配置项讲解**

1. `TPS`配置项，为服务器的tps状态显示
    - `color` 配置显示范围的颜色，`low`、`medium`、`high`为显示的范围
    - `value` 配置显示范围的值，`medium`、`high`为可设置的范围值，`low`值为`0`不可更改