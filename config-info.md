# **配置文件使用说明**
## **[config.yml](src/main/resources/config.yml)**
> **主配置文件**
### **是否释放新的变量说明文档**
```
save-variables-doc: true
```
> 1、该配置项启用后，服务器每次启动后都会生成新的变量文档  
> 2、若关闭后，就算删除变量文档也不会生成新的变量文档  
> 3、该配置项默认启用
## **[server.yml](src/main/resources/server.yml)**
> **服务器相关变量配置文件**
```
TPS:
  low_color: "§c"
  medium_value: 9
  medium_color: "§e"
  high_value: 15
  high_color: "§a"
```
> 1、color设置显示的颜色，low、medium、high为显示的范围  
> 2、value是一个范围值，medium、high为可设置的范围值，low值只能为0