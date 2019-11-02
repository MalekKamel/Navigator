package com.sha.kamel.navigator.modular

import android.app.Activity
import android.content.Intent
import android.os.Parcelable
import com.sha.kamel.navigator.ActivityNavigator
import com.sha.kamel.navigator.model.Flags

class ActivityModuleNavigator(
        activity: Activity,
        private val packageName: String
) {

    internal var navigator = ActivityNavigator(activity)

    /**
     * Create an Intent with [Intent.ACTION_VIEW] to an [AddressableActivity].
     */
    fun intentTo(addressableActivity: AddressableActivity): Intent? {
        return Intent(Intent.ACTION_VIEW)
                .setClassName(packageName, addressableActivity.className)
    }

    /**
     * navigate to [Activity]
     * @param addressableActivity container of the activity
     */
    fun navigate(addressableActivity: AddressableActivity) {
        val intent: Intent? = intentTo(addressableActivity)
        navigator.navigate(intent!!)
    }

    /**
     * Pass Parcelable with the intent
     * @param parcelable object
     * @param name key for parcelable
     */
    fun withParcelable(parcelable: Parcelable, name: String): ActivityModuleNavigator {
        navigator.withParcelable(parcelable, name)
        return this
    }

    /**
     * add flags
     * @param flags intent flags
     */
    fun withFlags(flags: Flags): ActivityModuleNavigator {
        navigator.withFlags(flags)
        return this
    }

    /**
     * add flags
     * @param flags intent flags
     */
    fun withFlags(vararg flags: Int): ActivityModuleNavigator {
        navigator.withFlags(*flags)
        return this
    }

}