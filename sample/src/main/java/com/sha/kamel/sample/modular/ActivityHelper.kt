package com.sha.kamel.sample.modular

import com.sha.kamel.navigator.modular.AddressableActivity

/**
 * All addressable activities.
 *
 * Can contain intent extra names or functions associated with the activity creation.
 */
object Activities {
    object Profile: AddressableActivity {
        override val className: String = "com.sha.navigator.profile.ProfileActivity"
    }
}