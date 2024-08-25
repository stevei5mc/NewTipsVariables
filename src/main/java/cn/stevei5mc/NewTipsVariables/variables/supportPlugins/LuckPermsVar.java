package cn.stevei5mc.NewTipsVariables.variables.supportPlugins;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import cn.stevei5mc.NewTipsVariables.variables.LoadSupportPlugins;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.group.Group;
import java.util.OptionalInt;

public class LuckPermsVar extends BaseVariable {
    public static LuckPerms luckperms = LoadSupportPlugins.getLP();
    public LuckPermsVar(Player player) {
        super(player);
    }
    public void strReplace() {
        lpvar();
    }

    public void lpvar() {
        User user = luckperms.getUserManager().getUser(player.getUniqueId());
        Group group = luckperms.getGroupManager().getGroup(user.getPrimaryGroup());

        String pf = "";
        String sf = "";
        String gp = "";
        if (user.getCachedData().getMetaData().getPrefix() != null) {
            pf = user.getCachedData().getMetaData().getPrefix();
        }
        if (user.getCachedData().getMetaData().getSuffix() != null) {
            sf = user.getCachedData().getMetaData().getSuffix();
        }
        if (user.getPrimaryGroup() != null) {
            gp = user.getPrimaryGroup();
        }
        OptionalInt weight = group.getWeight();
        int weight2 = weight.orElse(0);
        
        addStrReplaceString("{LuckPerms-prefix}", pf);
        addStrReplaceString("{LuckPerms-suffix}", sf);
        addStrReplaceString("{LuckPerms-group}", gp);
        addStrReplaceString("{LuckPerms-group-weight}", String.valueOf(weight2));
    }
}