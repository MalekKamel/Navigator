package com.sha.kamel.navigator.modular

import android.app.Activity
import android.content.Intent
import com.sha.kamel.navigator.ActivityNavigator

class ActivityModuleNavigator(
        private val activity: Activity,
        private val packageName: String
) {

    /**
     * Create an Intent with [Intent.ACTION_VIEW] to an [AddressableActivity].
     */
    fun intentTo(addressableActivity: AddressableActivity): Intent {
        return Intent(Intent.ACTION_VIEW)
                .setClassName(packageName, addressableActivity.className)
    }

    /**
     * @param addressableActivity container of the activity
     */
    fun navigate(addressableActivity: AddressableActivity) {
        ActivityNavigator(activity).navigate(intentTo(addressableActivity))
    }

}