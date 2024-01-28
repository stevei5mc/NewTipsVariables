package cn.stevei5mc.NewTipsVariables.variables.supportPlugins;

import tip.utils.Api;
import cn.nukkit.Server;

public class loadSupportPlugins {

    public static void loadSupportVariables() {
        //加载相关插件的变量时的提示
        String loadStartMsg1 = "§a识别到插件§e【§b";
        String loadStartMsg2 = "§e】§a相关变量加载中";
        String loadSuccessMsg1 = "§e【§b";
        String loadSuccessMsg2 = "§e】§a相关变量加载完成";
        String loadFailureMsg1 = "§c无法识别到插件§e【§b";
        String loadFailureMsg2 = "§e】§c相关变量加载失败,请安装相关插件再试";
        //需要加载的变量的插件
        String loadPlugin1 = "UnicodeVariables";
        
        if (Server.getInstance().getPluginManager().getPlugin(loadPlugin1) != null) {
            //存在
            Server.getInstance().getLogger().info(loadStartMsg1 + loadPlugin1 + loadStartMsg2);
            Server.getInstance().getLogger().info(loadSuccessMsg1 + loadPlugin1 + loadSuccessMsg2);
        }  else {
            //不存在
            Server.getInstance().getLogger().info(loadFailureMsg1 + loadPlugin1 + loadFailureMsg2);
        }
    }
}