package cn.stevei5mc.NewTipsVariables.variables;

import cn.nukkit.Player;
import cn.stevei5mc.NewTipsVariables.utils.LoadVariables;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import tip.utils.variables.BaseVariable;

import java.util.OptionalInt;

public class LuckPermsVar extends BaseVariable {
    public static LuckPerms luckperms = LoadVariables.getLP();
    public LuckPermsVar(Player player) {
        super(player);
    }
    public void strReplace() {
        if (player != null && player.isOnline()) {
            lpvar();
        }
    }

    public void lpvar() {
        User user = luckperms.getUserManager().getUser(player.getUniqueId());
        Group group = luckperms.getGroupManager().getGroup(user.getPrimaryGroup()) != null ? luckperms.getGroupManager().getGroup(user.getPrimaryGroup()) : null;

        String pf = user.getCachedData().getMetaData().getPrefix() != null ? user.getCachedData().getMetaData().getPrefix() : "";
        String sf = user.getCachedData().getMetaData().getSuffix() != null ? user.getCachedData().getMetaData().getSuffix() : "";
        user.getPrimaryGroup();
        String gp = user.getPrimaryGroup();

        OptionalInt weight = group.getWeight();
        int weight2 = weight.orElse(0);
        
        addStrReplaceString("{LuckPerms-prefix}", pf);
        addStrReplaceString("{LuckPerms-suffix}", sf);
        addStrReplaceString("{LuckPerms-group}", gp);
        addStrReplaceString("{LuckPerms-group-weight}", String.valueOf(weight2));
    }
}