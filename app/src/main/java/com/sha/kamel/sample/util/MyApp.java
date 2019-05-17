package com.sha.kamel.sample.util;

import android.app.Application;

import com.sha.kamel.navigator.NavigatorOptions;
import com.sha.kamel.sample.R;


/**
 * Created by Sha on 13/04/17.
 */

public final class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NavigatorOptions.instance().frameLayoutId = R.id.mainFrame;
    }

}
