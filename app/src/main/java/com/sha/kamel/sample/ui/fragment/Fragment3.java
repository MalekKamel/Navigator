package com.sha.kamel.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.sha.kamel.navigator.Navigator;
import com.sha.kamel.sample.ClientInfo;

import org.parceler.Parcels;

/**
 * Created by Sha on 11/11/17.
 */

public class Fragment3 extends BaseFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setText("This is " + getClass().getSimpleName());

        ClientInfo info = Parcels.unwrap(getArguments().getParcelable(Navigator.DEFAULT_PARCELABLE_NAME));
        addText("Client name = " + info.getName());
        addText("");
        addText("Passed data using '.parcelable(Parcels.wrap(new ClientInfo()))'");
        addText("used 'Navigator.DEFAULT_PARCELABLE_NAME)'");

    }

}
