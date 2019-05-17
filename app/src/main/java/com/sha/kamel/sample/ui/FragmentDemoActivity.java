package com.sha.kamel.sample.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.sha.kamel.navigator.FragmentNavigator;
import com.sha.kamel.sample.R;
import com.sha.kamel.sample.model.CustomerInfo;

public class FragmentDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        findViewById(R.id.btnReplaceFragment).setOnClickListener(v ->
                new FragmentNavigator(this).replace(
                        ExampleFragment.newInstance("Replaced"),
                        true
                )
        );

        findViewById(R.id.btnAddFragment).setOnClickListener(v ->
                new FragmentNavigator(this, R.id.mainFrame).add(
                        ExampleFragment.newInstance("Added"),
                        true
                )
        );

        findViewById(R.id.btnAddFragmentDelayed).setOnClickListener(v ->
                new FragmentNavigator(this).addDelayed(
                        ExampleFragment.newInstance("Replaced after 1 second"),
                        true,
                        1000
                )
        );

        findViewById(R.id.btnReplaceFragmentDelayed).setOnClickListener(v ->
                new FragmentNavigator(this).replaceDelayed(
                        ExampleFragment.newInstance("Replaced after 1 second"),
                        true,
                        1000
                )
        );

        findViewById(R.id.btnShowDialogFragment).setOnClickListener(v ->
                new FragmentNavigator(this)
                        .showDialogFragment(
                                CustomerDialogFragment.newInstance(new CustomerInfo())
                        )
        );
    }



}
