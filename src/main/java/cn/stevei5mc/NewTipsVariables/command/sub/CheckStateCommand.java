package cn.stevei5mc.NewTipsVariables.command.sub;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import cn.stevei5mc.NewTipsVariables.command.BaseSubCommand;
import cn.stevei5mc.NewTipsVariables.utils.PluginsState;

public class CheckStateCommand extends BaseSubCommand {

    public CheckStateCommand(String name) {
        super(name);
    }

    @Override
    public boolean canUser(CommandSender sender) {
        return sender.hasPermission("newtipsariables.admin.checkstate");
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        PluginsState ps = PluginsState.getInstance();
        sender.sendMessage("Plugins loading status");
        sender.sendMessage("playerPoints = " + ps.playerPoints);
        sender.sendMessage("EconomyAPI = " + ps.economyAPI);
        sender.sendMessage("OreArea = " + ps.oreArea);
        sender.sendMessage("RSTask = " + ps.rSTask);
        sender.sendMessage("HealthAPI = " + ps.healthAPI);
        sender.sendMessage("LevelAwakenSystem = " + ps.levelAwakenSystem);
        sender.sendMessage("RSWeapon = " + ps.rSWeapon);
        sender.sendMessage("LuckPerms = " + ps.luckPerms);
        return true;
    }

    @Override
    public CommandParameter[] getParameters() {
        return new CommandParameter[0];
    }
}