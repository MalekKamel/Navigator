package com.sha.kamel.sample.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.sha.kamel.navigator.ActivityNavigator;
import com.sha.kamel.sample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnActivities).setOnClickListener(v ->
                new ActivityNavigator(this).navigate(ActivitiesDemoActivity.class)
        );

        findViewById(R.id.btnFragments).setOnClickListener(v ->
                new ActivityNavigator(this).navigate(FragmentDemoActivity.class)
        );

    }

}
