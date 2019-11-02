package com.sha.kamel.navigator.modular

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.sha.kamel.navigator.FragmentNavigator
import com.sha.kamel.navigator.NavigatorOptions

class FragmentModuleNavigator(
        private val activity: FragmentActivity,
        private val frameResourceId: Int = NavigatorOptions.frameLayoutId
) {

    fun <T: Fragment> fragmentOf(addressableFragment: AddressableFragment): T {
        return Class.forName(addressableFragment.className).newInstance() as T
    }

    /**
     * add [Fragment]
     * @param addressableFragment  container of the [Fragment]
     * @param addToBackStack If true, will be added to back stack, true by default
     */
    @JvmOverloads
    fun add(
            addressableFragment: AddressableFragment,
            addToBackStack: Boolean = true
    ) {
        FragmentNavigator(activity, frameResourceId)
                .add(fragmentOf(addressableFragment), addToBackStack)
    }

    /**
     * replace [Fragment]
     * @param addressableFragment  container of the [Fragment]
     * @param addToBackStack If true, will be added to back stack, true by default
     */
    @JvmOverloads
    fun replace(
            addressableFragment: AddressableFragment,
            addToBackStack: Boolean = true
    ) {
        FragmentNavigator(activity, frameResourceId)
                .replace(fragmentOf(addressableFragment), addToBackStack)
    }

}