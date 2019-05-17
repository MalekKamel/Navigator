package com.sha.kamel.sample.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sha.kamel.navigator.FragmentNavigator;
import com.sha.kamel.sample.R;

/**
 * Created by Sha on 11/11/17.
 */

public class ExampleFragment extends Fragment {

    private String message;

    public static ExampleFragment newInstance(String message) {
        ExampleFragment fragment = new ExampleFragment();
        fragment.message = message;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.tv);
        tv.setText(message);

        view.findViewById(R.id.btnRemove).setOnClickListener(v ->
                new FragmentNavigator(getActivity()).remove(this)
        );
    }

}
