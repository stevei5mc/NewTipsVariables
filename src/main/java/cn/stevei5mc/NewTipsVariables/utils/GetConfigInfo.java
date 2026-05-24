package cn.stevei5mc.NewTipsVariables.utils;

import cn.nukkit.Player;
import cn.stevei5mc.NewTipsVariables.Main;
import cn.stevei5mc.NewTipsVariables.utils.variables.GetPlayerVarInfo;
import cn.stevei5mc.NewTipsVariables.utils.variables.GetServerVarInfo;

public class GetConfigInfo {
    private static final Main main = Main.getInstance();
    
    /**
     * @deprecated 本方法即将移除，请改用 GetServerVarInfo.getServerTps()
     * 获取服务器TPS
     * @return 服务器TPS
    */
    @Deprecated
    public static String getServerTps() {
        return GetServerVarInfo.getServerTps();
    }

    /**
     * @deprecated 本方法即将移除，请改用 GetPlayerVarInfo.getPlayerWorld(player)
     * 获取玩家所在的世界的世界名
     * @return 玩家所在的世界的世界名
    */
    @Deprecated
    public static String getPlayerWorld(Player player) {
        return GetPlayerVarInfo.getPlayerWorld(player);
    }

    /**
     * @deprecated 本方法即将移除，请改用 GetPlayerVarInfo.getPlayerPing
     * 获取玩家的延迟
     * @return 玩家的延迟
    */
    @Deprecated
    public static String getPlayerPing(Player player) {
        return GetPlayerVarInfo.getPlayerPing(player);
    }

    /**
     * @deprecated 本方法即将移除，请改用 GetPlayerVarInfo.getPlayerHealth
     * 获取玩家的生命值的当前值和最大值状态
     * @return 玩家的生命值当前值和最大值状态
    */
    @Deprecated
    public static String getPlayerHealth(Player player) {
        return GetPlayerVarInfo.getPlayerHealth(player);
    }

    /**
     * @deprecated 本方法即将移除，请改用 GetPlayerVarInfo.getPlayerFood
     * 获取玩家的饱食度状态
     * @return 玩家的饱食度状态
    */
    public static String getPlayerFood(Player player) {
        return GetPlayerVarInfo.getPlayerFood(player);
    }

    /**
     * @deprecated GetPlayerVarInfo.getPlayerUi
     * 获取玩家的UI Profile
     * @return 玩家的UI Profile
    */
    @Deprecated
    public static String getPlayerUi(int ui) {
        switch (ui) {
            case 0: return main.getConfigInPlayer().getString("Device.UIProfile.classic");
            case 1: return main.getConfigInPlayer().getString("Device.UIProfile.pocket");
            default: return main.getLanguage().getString("Unknown_Device_UIProfile");
        }
    }

    /**
     * @deprecated GetPlayerVarInfo.getDeviceControls
     * 获取玩家的操作方式
     * @return 玩家的操作方式
    */
    @Deprecated
    public static String getDeviceControls(int ctrl) {
        switch (ctrl) {
            case 1: return main.getConfigInPlayer().getString("Device.Controls.Keyboard");
            case 2: return main.getConfigInPlayer().getString("Device.Controls.Touch");
            case 3: return main.getConfigInPlayer().getString("Device.Controls.pad");
            case 4: return main.getConfigInPlayer().getString("Device.Controls.motion_controller");
            default: return main.getLanguage().getString("Unknown_Device_controls");
       }
    }

    /**
     * @deprecated GetPlayerVarInfo.getDeviceOS
     * 获取玩家设备的系统
     * @return 玩家设备的系统
    */
    @Deprecated
    public static String getDeviceOS(int os) {
        switch (os) {
            case 1: return main.getConfigInPlayer().getString("Device.OS.Android");
            case 2: return main.getConfigInPlayer().getString("Device.OS.iOS");
            case 3: return main.getConfigInPlayer().getString("Device.OS.macOS");
            case 4: return main.getConfigInPlayer().getString("Device.OS.Fire_OS");
            case 5: return main.getConfigInPlayer().getString("Device.OS.Gear_VR");
            case 6: return main.getConfigInPlayer().getString("Device.OS.HoloLens");
            case 7: return main.getConfigInPlayer().getString("Device.OS.Windows_10");
            case 8: return main.getConfigInPlayer().getString("Device.OS.Windows");
            case 9: return main.getConfigInPlayer().getString("Device.OS.Dedicated");
            case 10: return main.getConfigInPlayer().getString("Device.OS.tvOS");
            case 11: return main.getConfigInPlayer().getString("Device.OS.PlayStation");
            case 12: return main.getConfigInPlayer().getString("Device.OS.Switch");
            case 13: return main.getConfigInPlayer().getString("Device.OS.Xbox");
            case 14: return main.getConfigInPlayer().getString("Device.OS.Windows_Phone");
            default: return main.getLanguage().getString("Unknown_Device_OS");
        }
    }
}