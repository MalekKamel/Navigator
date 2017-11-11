package com.sha.kamel.sample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity5 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("This is " + getClass().getSimpleName());
        addText("Started this activity for result");
        addText("We used DEFAULT_START_ACTIVITY_FOR_RESULT_KEY");

        btn_press.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClickPressBtn(View v) {
        setResult(RESULT_OK, new Intent().putExtra("activity", getClass().getSimpleName()));
        finish();
    }
}

