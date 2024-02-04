package cn.stevei5mc.NewTipsVariables.variables.supportPlugins.smallasWater;

import cn.nukkit.Player;
import tip.utils.variables.BaseVariable;
import com.task.utils.tasks.PlayerFile;
import com.task.utils.tasks.taskitems.PlayerTask;
import java.util.LinkedList;

public class RsTaskVariable extends BaseVariable {
    public RsTaskVariable(Player player) {
        super(player);
    }

    public void strReplace() {
        RsTaskVar();
    }

    public void RsTaskVar() {
        //这个代码的是复制TipsVeriable的
        PlayerFile file = PlayerFile.getPlayerFile(this.player.getName());
        LinkedList<PlayerTask> tasks = file.getInviteTasks();
        String taskName = "暂无";
        if (tasks.size() > 0) {
           PlayerTask task = (PlayerTask)tasks.get(0);
           if (task != null) {
              taskName = task.getTaskName();
           }
        }

        this.addStrReplaceString("{task-name}", taskName);
        this.addStrReplaceString("{task-count}", file.getCount() + "");
    }
}