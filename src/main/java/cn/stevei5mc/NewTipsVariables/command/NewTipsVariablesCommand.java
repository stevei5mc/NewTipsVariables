package cn.stevei5mc.NewTipsVariables.command;

import cn.nukkit.command.CommandSender;
import cn.stevei5mc.NewTipsVariables.command.sub.CheckStateCommand;
import cn.stevei5mc.NewTipsVariables.command.sub.ReloadCommand;

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
        String cmdName = "§a/" + getName();
        sender.sendMessage("§bNewTipsVariables 命令帮助");
        sender.sendMessage(cmdName + "reload §e重载配置文件");
        sender.sendMessage(cmdName +" checkstatus §e检查插件的状态");
    }
}