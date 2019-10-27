package com.sha.kamel.sample.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.sha.kamel.navigator.ActivityNavigator
import com.sha.kamel.navigator.NavigatorOptions
import com.sha.kamel.sample.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigatorOptions.frameLayoutId = R.id.mainFrame

        findViewById<Button>(R.id.btnActivities).setOnClickListener {
            ActivityNavigator(this).navigate(ActivitiesDemoActivity::class.java)
        }

        findViewById<Button>(R.id.btnFragments).setOnClickListener {
            ActivityNavigator(this).navigate(FragmentDemoActivity::class.java)
        }

        findViewById<Button>(R.id.btnModularNavigation).setOnClickListener {
            ActivityNavigator(this).navigate(ModularNavActivity::class.java)
        }

    }

}
