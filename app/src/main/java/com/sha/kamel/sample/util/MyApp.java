package com.sha.kamel.sample.util;

import android.app.Application;
import android.content.Context;

import com.sha.kamel.navigator.NavigatorData;
import com.sha.kamel.sample.R;


/**
 * Created by Sha on 13/04/17.
 */

public final class MyApp extends Application {

    private static Context context;

    public static Context getContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        NavigatorData.instance().frameLayoutResource = R.id.mainFrame;

        context = getApplicationContext();

    }

}
