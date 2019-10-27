package com.sha.kamel.navigator.model

import android.content.Intent
import android.os.Parcelable

class ParcelableInfo {
    var parcelable: Parcelable? = null
    var name: String? = null

    fun addToIntent(intent: Intent) {
        if (parcelable == null) return
        intent.putExtra(name, parcelable)
    }
}
