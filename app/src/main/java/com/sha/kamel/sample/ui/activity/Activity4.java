package com.sha.kamel.sample.ui.activity;

import android.os.Bundle;

public class Activity4 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("This is " + getClass().getSimpleName());
        addText("no history using '.noHistory()'");
        addText("if you tried to press home button then return to app, you won't see this activity as it's not in history");

    }



}

