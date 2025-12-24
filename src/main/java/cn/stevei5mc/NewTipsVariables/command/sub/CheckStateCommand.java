package cn.stevei5mc.NewTipsVariables.command.sub;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import cn.stevei5mc.NewTipsVariables.command.BaseSubCommand;
import cn.stevei5mc.NewTipsVariables.utils.PluginsListEnum;
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
        for (PluginsListEnum plugin : PluginsListEnum.values()) {
            String name = plugin.getName();
            boolean state = PluginsState.getPluginState(name);
            sender.sendMessage("§b" + name + "§7=§a" + state);
        }
        return true;
    }

    @Override
    public CommandParameter[] getParameters() {
        return new CommandParameter[0];
    }
}