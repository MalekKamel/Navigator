package com.sha.kamel.sample

import android.app.Application
import com.sha.kamel.navigator.NavigatorOptions


/**
 * Created by Sha on 13/04/17.
 */

class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        NavigatorOptions.frameLayoutId = R.id.mainFrame
    }

}
