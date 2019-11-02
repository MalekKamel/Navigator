package com.sha.kamel.navigator

import android.content.Intent
import com.sha.kamel.navigator.model.Flags
import org.junit.Before
import org.junit.Test

class FlagsTest {

     lateinit var flags: Flags

    @Before
    fun setup() {
        flags = Flags()
    }

    @Test
    fun newTask() {
        flags.newTask()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_NEW_TASK))
    }

    @Test
    fun singleTop() {
        flags.singleTop()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_SINGLE_TOP))
    }

    @Test
    fun clearTop() {
        flags.clearTop()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }

    @Test
    fun clearWhenTaskReset() {
        flags.clearWhenTaskReset()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET))
    }

    @Test
    fun excludeFromRecents() {
        flags.excludeFromRecents()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS))
    }

    @Test
    fun forwardResult() {
        flags.forwardResult()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_FORWARD_RESULT))
    }

    @Test
    fun launchedFromHistory() {
        flags.launchedFromHistory()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY))
    }

    @Test
    fun launchAdjacent() {
        flags.launchAdjacent()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT))
    }

    @Test
    fun multipleTask() {
        flags.multipleTask()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_MULTIPLE_TASK))
    }

    @Test
    fun newDocument() {
        flags.newDocument()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_NEW_DOCUMENT))
    }

    @Test
    fun noAnimation() {
        flags.noAnimation()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_NO_ANIMATION))
    }

    @Test
    fun noHistory() {
        flags.noHistory()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_NO_HISTORY))
    }

    @Test
    fun noUserAction() {
        flags.noUserAction()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_NO_USER_ACTION))
    }

    @Test
    fun previousIsTop() {
        flags.previousIsTop()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP))
    }

    @Test
    fun reorderToFront() {
        flags.reorderToFront()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
    }

    @Test
    fun resetTaskIfNeeded() {
        flags.resetTaskIfNeeded()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED))
    }

    @Test
    fun retainInRecents() {
        flags.retainInRecents()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS))
    }

    @Test
    fun taskOnHome() {
        flags.taskOnHome()
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_TASK_ON_HOME))
    }

    @Test
    fun addFlag() {
        flags.addFlag(Intent.FLAG_ACTIVITY_TASK_ON_HOME)
        assert(flags.flags.contains(Intent.FLAG_ACTIVITY_TASK_ON_HOME))
    }

}