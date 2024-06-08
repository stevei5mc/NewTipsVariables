package cn.stevei5mc.NewTipsVariables.variables.supportPlugins;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.LuckPermsProvider;

public class LuckPermsVar extends BaseVariable {
    public LuckPerms luckperms;
    public LuckPermsVar(Player player) {
        super(player);
    }
    public void strReplace() {
        lpvar();
    }

    public void lpvar() {
        User user = LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId());
        String pf = "";
        String sf = "";
        String gp = "";
        String pfx = user.getCachedData().getMetaData().getPrefix();
        String sfx = user.getCachedData().getMetaData().getSuffix();
        String gup = user.getPrimaryGroup();
        if (pfx != null) {
            pf = pfx;
        }
        if (sfx != null) {
            sf = sfx;
        }
        if (gup != null) {
            gp = gup;
        }
        addStrReplaceString("{LuckPerms-prefix}", pf);
        addStrReplaceString("{LuckPerms-suffix}", sf);
        addStrReplaceString("{LuckPerms-group}", gp);
    }
}