package com.sha.kamel.sample.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sha.kamel.navigator.DataReceivable;
import com.sha.kamel.navigator.Navigator;
import com.sha.kamel.sample.ClientInfo;
import com.sha.kamel.sample.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sha on 11/11/17.
 */

public class ClientInfoDialogFragment extends DialogFragment implements DataReceivable<ClientInfo>{

    @BindView(R.id.tv)
    TextView tv;

    @BindView(R.id.tv_name)
    TextView tv_name;

    @BindView(R.id.tv_age)
    TextView tv_age;

    @BindView(R.id.tv_mobile)
    TextView tv_mobile;

    private ClientInfo clientInfo;
    private boolean isFromReceivedData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog_client_info,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
        setText("This is " + getClass().getSimpleName());

        if (getArguments() != null){
            ClientInfo info = Parcels.unwrap(getArguments().getParcelable(Navigator.DEFAULT_PARCELABLE_NAME));
            if (info != null)
                clientInfo = info;
        }

        tv_name.setText(clientInfo.getName());
        tv_age.setText(String.valueOf(clientInfo.getAge()));
        tv_mobile.setText(clientInfo.getMobile());

        if (isFromReceivedData)
            addText("Passed data using '.fragmentData(new ClientInfo())'");
        else
            addText("Passed data using '.parcelable(Parcels.wrap(new ClientInfo()))'");

    }

    @Override
    public void receivedData(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
        isFromReceivedData = true;
    }

    protected void setText(String text){
        tv.setText(text);
    }

    protected void addText(String text){
        String s = tv.getText() + "\n" + text;
        tv.setText(s);
    }
}
