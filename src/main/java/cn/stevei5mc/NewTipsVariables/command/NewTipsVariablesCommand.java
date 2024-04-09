package cn.stevei5mc.NewTipsVariables.command;

import cn.stevei5mc.NewTipsVariables.command.newTipsVariables.ReloadCommand;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

/**
 * @author lt_name
 */
public class NewTipsVariablesCommand extends BaseCommand {

    public NewTipsVariablesCommand() {
        super("NewTipsVariables", "NewTipsVariables 命令");
        this.setPermission("newtipsariables.admin");
        this.addSubCommand(new ReloadCommand("reload"));
        this.loadCommandBase();
    }

    @Override
    public void sendHelp(CommandSender sender) {
        sender.sendMessage("§b=== NewTipsVariables ===");
        sender.sendMessage("§a/newtipsariables reload §e重载配置文件");
    }
}