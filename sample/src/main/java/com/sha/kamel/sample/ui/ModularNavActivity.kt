package com.sha.kamel.sample.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sha.kamel.navigator.modular.ActivityModuleNavigator
import com.sha.kamel.navigator.modular.FragmentModuleNavigator
import com.sha.kamel.sample.R
import com.sha.kamel.sample.modular.Activities
import com.sha.kamel.sample.modular.Fragments

class ModularNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modular_nav)

        findViewById<Button>(R.id.btnShowActivityModular).setOnClickListener {
            ActivityModuleNavigator(this, packageName).navigate(Activities.Profile);
        }

        findViewById<Button>(R.id.btnShowFragmentModular).setOnClickListener {
            FragmentModuleNavigator(this).add(Fragments.Profile)
        }
    }


}
