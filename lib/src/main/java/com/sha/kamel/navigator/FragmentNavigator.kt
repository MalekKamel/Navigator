package com.sha.kamel.navigator

import android.os.Handler
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
    fun add(fragment: Fragment, addToBackStack: Boolean) {
        navigate(fragment, addToBackStack, TransactionBehavior.ADD)
    }

    /**
     * Add a fragment to Frame after delay time
     * @param fragment instance
     * @param addToBackStack flag
     * @param delayMillis time to delay
     * @param callbackAfterNavigation will be called after submitting navigation
     */
    @JvmOverloads
    fun addDelayed(
            fragment: Fragment,
            addToBackStack: Boolean,
            delayMillis: Long,
            callbackAfterNavigation: (() -> Unit)? = null
    ) {
        navigateDelayed(
                fragment,
                addToBackStack,
                delayMillis,
                callbackAfterNavigation,
                TransactionBehavior.ADD
        )
    }

    /**
     * Replace a fragment in Frame
     * @param fragment instance
     * @param addToBackStack flag
     */
    fun replace(fragment: Fragment, addToBackStack: Boolean) {
        navigate(fragment, addToBackStack, TransactionBehavior.REPLACE)
    }

    /**
     * Replace a fragment in Frame after delay time
     * @param fragment instance
     * @param addToBackStack flag
     * @param delayMillis time to delay
     * @param callbackAfterNavigation will be called after submitting navigation
     */
    @JvmOverloads
    fun replaceDelayed(
            fragment: Fragment,
            addToBackStack: Boolean,
            delayMillis: Long,
            callbackAfterNavigation: (() -> Unit)? = null
    ) {
        navigateDelayed(
                fragment,
                addToBackStack,
                delayMillis,
                callbackAfterNavigation,
                TransactionBehavior.REPLACE
        )
    }

    private fun navigateDelayed(
            fragment: Fragment,
            addToBackStack: Boolean,
            delayMillis: Long,
            callbackAfterNavigation: (() -> Unit)? = null,
            transactionBehavior: TransactionBehavior
    ) {
        Handler().postDelayed(
                {
                    navigate(fragment, addToBackStack, transactionBehavior)

                    callbackAfterNavigation?.invoke()
                },
                delayMillis)
    }

    /**
     * Remove the Fragment
     * @param fragment instance
     */
    fun remove(fragment: Fragment) {
        activity.supportFragmentManager
                .beginTransaction()
                .remove(fragment)
                .commit()
    }

    /**
     * Show a DialogFragment with a tag equal to the name of its class
     * @param dialog instance
     */
    fun showDialogFragment(dialog: DialogFragment) {
        dialog.show(
                activity.supportFragmentManager,
                dialog.javaClass.simpleName
        )
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
                    fragment.javaClass.simpleName
            )

            TransactionBehavior.REPLACE -> ft.replace(
                    frameResourceId,
                    fragment,
                    fragment.javaClass.simpleName
            )
        }

        if (addToBackStack)
            ft.addToBackStack(fragment.javaClass.simpleName)

        ft.commitAllowingStateLoss()
    }

    private enum class TransactionBehavior {
        REPLACE,
        ADD
    }

}
