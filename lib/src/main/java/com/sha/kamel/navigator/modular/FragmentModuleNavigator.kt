package com.sha.kamel.navigator.modular

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.sha.kamel.navigator.FragmentNavigator
import com.sha.kamel.navigator.NavigatorOptions

class FragmentModuleNavigator(private val activity: FragmentActivity) {

    fun <T: Fragment> fragmentOf(addressableFragment: AddressableFragment): T {
        return Class.forName(addressableFragment.className).newInstance() as T
    }

    @JvmOverloads
    fun add(
            addressableFragment: AddressableFragment,
            addToBackStack: Boolean = true,
            @IdRes frameResourceId: Int = NavigatorOptions.frameLayoutId
    ) {
        FragmentNavigator(activity, frameResourceId)
                .add(fragmentOf(addressableFragment), addToBackStack)
    }

    @JvmOverloads
    fun replace(
            addressableFragment: AddressableFragment,
            addToBackStack: Boolean = true,
            @IdRes frameResourceId: Int = NavigatorOptions.frameLayoutId
    ) {
        FragmentNavigator(activity, frameResourceId)
                .replace(fragmentOf(addressableFragment), addToBackStack)
    }

}