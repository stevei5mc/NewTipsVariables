package cn.stevei5mc.NewTipsVariables.command.sub;

import cn.stevei5mc.NewTipsVariables.command.BaseSubCommand;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import cn.stevei5mc.NewTipsVariables.utils.PluginsState;

/**
 * @author LT_Name
 */
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
        sender.sendMessage("Plugins status");
        sender.sendMessage("playerPoints plugin = " + ps.playerPoints);
        sender.sendMessage("EconomyAPI status = " + ps.economyAPI);
        sender.sendMessage("OreArea status = " + ps.oreArea);
        sender.sendMessage("RSTask status = " + ps.rSTask);
        sender.sendMessage("HealthAPI status = " + ps.healthAPI);
        sender.sendMessage("LevelAwakenSystem status = " + ps.levelAwakenSystem);
        sender.sendMessage("RSWeapon status = " + ps.rSWeapon);
        sender.sendMessage("LuckPerms status = " + ps.luckPerms);
        return true;
    }

    @Override
    public CommandParameter[] getParameters() {
        return new CommandParameter[0];
    }
}