package cn.stevei5mc.NewTipsVariables.command;

import cn.nukkit.command.CommandSender;
import cn.stevei5mc.NewTipsVariables.command.sub.CheckStateCommand;
import cn.stevei5mc.NewTipsVariables.command.sub.ReloadCommand;

/**
 * @author lt_name
 */
public class NewTipsVariablesCommand extends BaseCommand {

    public NewTipsVariablesCommand() {
        super("newtipsvariables", "NewTipsVariables 命令");
        this.setPermission("newtipsariables.admin");
        this.addSubCommand(new ReloadCommand("reload"));
        this.addSubCommand(new CheckStateCommand("checkstatus"));
        this.loadCommandBase();
    }

    @Override
    public void sendHelp(CommandSender sender) {
        String cmdname = "§a/newtipsvariables ";
        sender.sendMessage("§b=== NewTipsVariables ===");
        sender.sendMessage(cmdname+"reload §e重载配置文件");
        sender.sendMessage(cmdname+"checkstatus §e检查插件的状态");
    }
}