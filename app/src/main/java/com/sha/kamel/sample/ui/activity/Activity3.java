package com.sha.kamel.sample.ui.activity;

import android.os.Bundle;

import com.sha.kamel.sample.ClientInfo;

public class Activity3 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("This is " + getClass().getSimpleName());
        addText("Passed data using '.parcelable(Parcels.wrap(new ClientInfo()))' using '.parcelableName(\"my_parcel\")'");

        ClientInfo info = parseParcelable("my_parcel");
        addText("Client name: ");
        addText(info.getName());
    }

}

