package com.sha.kamel.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sha.kamel.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sha on 11/11/17.
 */

public class BaseFragment extends Fragment {

    @BindView(R.id.tv)
    protected TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }


    protected void setText(String text){
        tv.setText(text);
    }

    protected void addText(String text){
        String s = tv.getText() + "\n" + text;
        tv.setText(s);
    }

}
