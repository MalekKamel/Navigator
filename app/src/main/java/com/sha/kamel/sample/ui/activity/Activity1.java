package com.sha.kamel.sample.ui.activity;

import android.os.Bundle;

public class Activity1 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("This is " + getClass().getSimpleName());
        addText("started by 'navigator.navigateToActivity(Activity1.class)'");
    }

}

