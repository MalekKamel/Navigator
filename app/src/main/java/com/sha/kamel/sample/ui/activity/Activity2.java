package com.sha.kamel.sample.ui.activity;

import android.os.Bundle;

import com.sha.kamel.sample.ClientInfo;

public class Activity2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("This is " + getClass().getSimpleName());
        addText("Passed data using '.parcelable(Parcels.wrap(new ClientInfo()))' using DEFAULT_PARCELABLE_NAME");

        ClientInfo info = parseParcelable();
        addText("Client name: ");
        addText(info.getName());
    }

}

