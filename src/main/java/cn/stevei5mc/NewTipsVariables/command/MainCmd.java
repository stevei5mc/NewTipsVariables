package cn.stevei5mc.NewTipsVariables.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import cn.stevei5mc.NewTipsVariables.Main;
import cn.stevei5mc.NewTipsVariables.command.sub.CheckStateCommand;
import cn.stevei5mc.NewTipsVariables.command.sub.ReloadCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class MainCmd extends Command {

    private final ArrayList<BaseSubCommand> subCommand = new ArrayList<>();
    private final ConcurrentHashMap<String, Integer> subCommands = new ConcurrentHashMap<>();
    private final Main main = Main.getInstance();

    public MainCmd() {
        super("newtipsvariables", "NewTipsVariables 命令");
        this.setPermission("newtipsariables.admin");
        this.addSubCommand(new ReloadCommand("reload"));
        this.addSubCommand(new CheckStateCommand("checkstatus"));
        this.loadCommandBase();
    }

    public void sendHelp(CommandSender sender) {
        String cmdName = "§a/" + getName();
        sender.sendMessage("§bNewTipsVariables 命令帮助");
        sender.sendMessage(cmdName + "reload §e重载配置文件");
        sender.sendMessage(cmdName +" checkstatus §e检查插件的状态");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(this.hasPermission(sender)) {
            if(args.length > 0) {
                String subCommand = args[0].toLowerCase();
                if (subCommands.containsKey(subCommand)) {
                    BaseSubCommand command = this.subCommand.get(this.subCommands.get(subCommand));
                    if (command.canUser(sender)) {
                        return command.execute(sender, s, args);
                    }else if (sender.isPlayer()) {
                        sender.sendMessage("§c你没有权限使用此命令！");
                    }else {
                        sender.sendMessage("§c请在游戏内使用此命令！");
                    }
                }else {
                    this.sendHelp(sender);
                }
            }else {
                this.sendHelp(sender);
            }
            return true;
        }else {
            sender.sendMessage("§c你没有权限使用此命令！");
        }
        return true;
    }

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(this.getPermission());
    }

    protected void addSubCommand(BaseSubCommand cmd) {
        this.subCommand.add(cmd);
        int commandId = (this.subCommand.size()) - 1;
        this.subCommands.put(cmd.getName().toLowerCase(), commandId);
        for (String alias : cmd.getAliases()) {
            this.subCommands.put(alias.toLowerCase(), commandId);
        }
    }

    protected void loadCommandBase() {
        this.commandParameters.clear();
        for(BaseSubCommand subCommand : this.subCommand) {
            LinkedList<CommandParameter> parameters = new LinkedList<>();
            parameters.add(CommandParameter.newEnum(subCommand.getName(), new String[]{subCommand.getName()}));
            parameters.addAll(Arrays.asList(subCommand.getParameters()));
            this.commandParameters.put(subCommand.getName(), parameters.toArray(new CommandParameter[0]));
        }
    }
}