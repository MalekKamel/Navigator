package com.sha.kamel.sample.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sha.kamel.navigator.FragmentNavigator;
import com.sha.kamel.sample.model.CustomerInfo;
import com.sha.kamel.sample.R;

import org.parceler.Parcels;


/**
 * Created by Sha on 11/11/17.
 */

public class CustomerDialogFragment extends DialogFragment{

    private TextView tv;
    private TextView tv_name;
    private TextView tv_age;
    private TextView tv_mobile;

    private CustomerInfo customerInfo;

    public static CustomerDialogFragment newInstance(CustomerInfo customerInfo) {
        CustomerDialogFragment fragment = new CustomerDialogFragment();
        fragment.customerInfo = customerInfo;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog_client_info,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = getView().findViewById(R.id.tv);
        tv_name = getView().findViewById(R.id.tv_name);
        tv_age = getView().findViewById(R.id.tv_age);
        tv_mobile = getView().findViewById(R.id.tv_mobile);

        if (getArguments() != null){
            CustomerInfo info = Parcels.unwrap(getArguments().getParcelable(FragmentNavigator.DEFAULT_PARCELABLE_NAME));
            if (info != null)
                customerInfo = info;
        }

        tv_name.setText("Name: " + customerInfo.name);
        tv_age.setText("Age: " + customerInfo.age);
        tv_mobile.setText("Mobile: " + customerInfo.mobile);
    }


}
