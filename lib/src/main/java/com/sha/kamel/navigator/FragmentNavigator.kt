package com.sha.kamel.navigator

import androidx.annotation.IdRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


/**
 * Created by Sha on 4/1/17.
 */
class FragmentNavigator @JvmOverloads constructor(
        private val activity: FragmentActivity,
        @IdRes private val frameResourceId: Int = NavigatorOptions.frameLayoutId
) {

    /**
     * Add a fragment to Frame
     * @param fragment instance
     * @param addToBackStack flag
     */
    @JvmOverloads
    fun add(fragment: Fragment, addToBackStack: Boolean = true) {
        navigate(fragment, addToBackStack, TransactionBehavior.ADD)
    }

    /**
     * Replace a fragment in Frame
     * @param fragment instance
     * @param addToBackStack flag
     */
    @JvmOverloads
    fun replace(fragment: Fragment, addToBackStack: Boolean = true) {
        navigate(fragment, addToBackStack, TransactionBehavior.REPLACE)
    }
    
    /**
     * Remove the Fragment
     * @param fragment instance
     */
    fun remove(fragment: Fragment) {
        activity.supportFragmentManager
                .beginTransaction()
                .remove(fragment)
                .commitAllowingStateLoss()
    }

    /**
     * Show a DialogFragment with a tag equal to the name of its class
     * @param dialog instance
     * @param tag The tag for this fragment
     */
    fun showDialogFragment(dialog: DialogFragment, tag: String) {
        dialog.show(activity.supportFragmentManager, tag)
    }

    /**
     * Show a DialogFragment with a tag equal to the name of its class
     */
    fun showDialogFragment(dialog: DialogFragment) {
        showDialogFragment(dialog, dialog.javaClass.name)
    }

    private fun navigate(
            fragment: Fragment,
            addToBackStack: Boolean,
            transactionBehavior: TransactionBehavior
    ) {
        val ft = activity.supportFragmentManager.beginTransaction()

        when (transactionBehavior) {
            TransactionBehavior.ADD -> ft.add(
                    frameResourceId,
                    fragment,
                    fragment.javaClass.name
            )

            TransactionBehavior.REPLACE -> ft.replace(
                    frameResourceId,
                    fragment,
                    fragment.javaClass.name
            )
        }

        if (addToBackStack)
            ft.addToBackStack(fragment.javaClass.name)

        ft.commitAllowingStateLoss()
    }

    private enum class TransactionBehavior {
        REPLACE,
        ADD
    }

}
