package com.sha.kamel.sample.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.sha.kamel.navigator.ActivityNavigator
import com.sha.kamel.navigator.model.Flags
import com.sha.kamel.sample.R
import com.sha.kamel.sample.model.Message

import org.parceler.Parcels

class ActivitiesDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities_demo)

        findViewById<View>(R.id.btnNavigateImmediately).setOnClickListener {
            ActivityNavigator(this)
                    .withParcelable(Parcels.wrap(Message("Navigated Immediately")), "message")
                    .navigate(ExampleActivity::class.java)
        }

        findViewById<View>(R.id.btnNavigateDelayed).setOnClickListener {
            ActivityNavigator(this)
                    .withParcelable(Parcels.wrap(Message("Navigated after 1 second")), "message")
                    .navigateDelayed(ExampleActivity::class.java, 1000)
        }

        findViewById<View>(R.id.btnStartActivityForResult).setOnClickListener {
            ActivityNavigator(this)
                    .withParcelable(Parcels.wrap(Message("Started for result")), "message")
                    .startActivityForResult(ExampleActivity::class.java, 1)
        }

        findViewById<View>(R.id.btnAddFlag).setOnClickListener {
            ActivityNavigator(this)
                    .withParcelable(Parcels.wrap(Message("Added new task & single top flags")), "message")
                    .withFlags(Flags().newTask().singleTop()) // OR
                    //                      .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK, Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    .navigate(ExampleActivity::class.java)
        }

        findViewById<View>(R.id.btnOpenInGooglePlay).setOnClickListener { ActivityNavigator(this).openInGooglePlay() }

        findViewById<View>(R.id.btnOpenCamera).setOnClickListener { ActivityNavigator(this).openCameraApp(2) }

        findViewById<View>(R.id.btnOpenSettings).setOnClickListener { ActivityNavigator(this).navigateToSystemSettings() }

        findViewById<View>(R.id.btnShowLocationInGoogleMaps).setOnClickListener {
            ActivityNavigator(this).showRouteInGoogleMap(
                    25.095549,
                    29.644703,
                    24.457151,
                    27.184841
            )
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> Log.i("Result of request 1", "code = $resultCode")

            2 -> Log.i("Result of request 2", "code = $resultCode")
        }
    }
}
