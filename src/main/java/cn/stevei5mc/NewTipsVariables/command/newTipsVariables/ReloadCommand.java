package cn.stevei5mc.NewTipsVariables.command.newTipsVariables;

import cn.stevei5mc.NewTipsVariables.command.BaseSubCommand;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;

/**
 * @author LT_Name
 */
public class ReloadCommand extends BaseSubCommand {

    public ReloadCommand(String name) {
        super(name);
    }

    @Override
    public boolean canUser(CommandSender sender) {
        return sender.hasPermission("newtipsariables.admin.reload");
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        this.main.reload();
        sender.sendMessage("重载配置完成！");
        return true;
    }

    @Override
    public CommandParameter[] getParameters() {
        return new CommandParameter[0];
    }
}
