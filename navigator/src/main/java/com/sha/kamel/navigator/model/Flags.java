package com.sha.kamel.navigator.model;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class Flags {

    public List<Integer> flags = new ArrayList<>();

    public Flags newTask(){
        flags.add(Intent.FLAG_ACTIVITY_NEW_TASK);
        return this;
    }

    public Flags singleTop(){
        flags.add(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return this;
    }

    public Flags clearTop(){
        flags.add(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return this;
    }

    public Flags clearWhenTaskReset(){
        flags.add(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        return this;
    }

    public Flags excludeFromRecents(){
        flags.add(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        return this;
    }

    public Flags forwardResult(){
        flags.add(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        return this;
    }

    public Flags launchedFromHistory(){
        flags.add(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        return this;
    }

    public Flags launchAdjacent(){
        flags.add(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT);
        return this;
    }

    public Flags multipleTask(){
        flags.add(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        return this;
    }

    public Flags newDocument(){
        flags.add(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        return this;
    }

    public Flags noAnimation(){
        flags.add(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        return this;
    }

    public Flags noHistory(){
        flags.add(Intent.FLAG_ACTIVITY_NO_HISTORY);
        return this;
    }

    public Flags noUserAction(){
        flags.add(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
        return this;
    }

    public Flags previousIsTop(){
        flags.add(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        return this;
    }

    public Flags reorderToFront(){
        flags.add(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        return this;
    }

    public Flags resetTaskIfNeeded(){
        flags.add(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        return this;
    }

    public Flags retainInRecents(){
        flags.add(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS);
        return this;
    }

    public Flags taskOnHome(){
        flags.add(Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        return this;
    }

    public void addFlag(int flag) {
        this.flags.add(flag);
    }

    public void addToIntent(Intent intent) {
        if (flags == null || flags.isEmpty()) return;

        for (int flag : flags){
            intent.addFlags(flag);
        }
    }
}
