package com.sha.kamel.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Sha on 11/11/17.
 */

public class Fragment1 extends BaseFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setText("This is " + getClass().getSimpleName());
        addText("We used '.navigateToFragment(new Fragment1(), true)'");

    }

}
