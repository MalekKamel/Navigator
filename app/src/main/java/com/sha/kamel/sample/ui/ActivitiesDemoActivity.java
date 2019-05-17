package com.sha.kamel.sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sha.kamel.navigator.ActivityNavigator;
import com.sha.kamel.navigator.model.Flags;
import com.sha.kamel.sample.R;
import com.sha.kamel.sample.model.Message;

import org.parceler.Parcels;

public class ActivitiesDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_demo);

        findViewById(R.id.btnNavigateImmediately).setOnClickListener(v ->
                new ActivityNavigator(this)
                        .withParcelable(Parcels.wrap(new Message("Navigated Immediately")), "message")
                        .navigate(ExampleActivity.class)
        );

        findViewById(R.id.btnNavigateDelayed).setOnClickListener(v ->
                new ActivityNavigator(this)
                        .withParcelable(Parcels.wrap(new Message("Navigated after 1 second")), "message")
                        .navigateDelayed(ExampleActivity.class, 1000)
        );

        findViewById(R.id.btnStartActivityForResult).setOnClickListener(v ->
                new ActivityNavigator(this)
                        .withParcelable(Parcels.wrap(new Message("Started for result")), "message")
                        .startActivityForResult(ExampleActivity.class, 1)
        );

        findViewById(R.id.btnAddFlag).setOnClickListener(v ->
                new ActivityNavigator(this)
                        .withParcelable(Parcels.wrap(new Message("Added new task & single top flags")), "message")
                        .withFlags(new Flags().newTask().singleTop()) // OR
//                      .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK, Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        .navigate(ExampleActivity.class)
        );

        findViewById(R.id.btnOpenInGooglePlay).setOnClickListener(v ->
                new ActivityNavigator(this).openInGooglePlay()
        );

        findViewById(R.id.btnOpenCamera).setOnClickListener(v ->
                new ActivityNavigator(this).openCamera(2)
        );

        findViewById(R.id.btnOpenSettings).setOnClickListener(v ->
                new ActivityNavigator(this).navigateToSettings()
        );

        findViewById(R.id.btnShowLocationInGoogleMaps).setOnClickListener(v ->
                new ActivityNavigator(this).showRouteInGoogleMap(
                        25.095549,
                        29.644703,
                        24.457151,
                        27.184841
                )
        );


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1 :
                Log.i("Result of request 1", "code = " + resultCode);
                break;

            case 2 :
                Log.i("Result of request 2", "code = " + resultCode);
                break;
        }
    }
}
