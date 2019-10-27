package com.sha.kamel.navigator.model

import android.content.Intent

import java.util.ArrayList

class Flags {

    var flags: MutableList<Int>? = ArrayList()

    fun newTask(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_NEW_TASK)
        return this
    }

    fun singleTop(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        return this
    }

    fun clearTop(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        return this
    }

    @Deprecated("Don't use this flag anymore")
    fun clearWhenTaskReset(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
        return this
    }

    fun excludeFromRecents(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        return this
    }

    fun forwardResult(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_FORWARD_RESULT)
        return this
    }

    fun launchedFromHistory(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY)
        return this
    }

    fun launchAdjacent(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT)
        return this
    }

    fun multipleTask(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        return this
    }

    fun newDocument(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
        return this
    }

    fun noAnimation(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        return this
    }

    fun noHistory(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_NO_HISTORY)
        return this
    }

    fun noUserAction(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_NO_USER_ACTION)
        return this
    }

    fun previousIsTop(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
        return this
    }

    fun reorderToFront(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        return this
    }

    fun resetTaskIfNeeded(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
        return this
    }

    fun retainInRecents(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS)
        return this
    }

    fun taskOnHome(): Flags {
        flags!!.add(Intent.FLAG_ACTIVITY_TASK_ON_HOME)
        return this
    }

    fun addFlag(flag: Int) {
        this.flags!!.add(flag)
    }

    fun addToIntent(intent: Intent) {
        if (flags == null || flags!!.isEmpty()) return

        for (flag in flags!!) {
            intent.addFlags(flag)
        }
    }
}
