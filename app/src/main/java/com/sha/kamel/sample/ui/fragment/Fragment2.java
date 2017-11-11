package com.sha.kamel.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.sha.kamel.navigator.DataReceivable;
import com.sha.kamel.navigator.Navigator;
import com.sha.kamel.sample.ClientInfo;

import org.parceler.Parcels;

/**
 * Created by Sha on 11/11/17.
 */

public class Fragment2 extends BaseFragment implements DataReceivable<ClientInfo> {

    private ClientInfo clientInfo;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setText("This is " + getClass().getSimpleName());

        addText("Client name = " + clientInfo.getName());
        addText("Passed data using '.fragmentData(new ClientInfo())'");
    }

    @Override
    public void receivedData(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
