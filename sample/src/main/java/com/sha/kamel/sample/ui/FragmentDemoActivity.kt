package com.sha.kamel.sample.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sha.kamel.navigator.FragmentNavigator
import com.sha.kamel.sample.R
import com.sha.kamel.sample.model.CustomerInfo

class FragmentDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_demo)

        findViewById<Button>(R.id.btnReplaceFragment).setOnClickListener {
            FragmentNavigator(this).replace(
                    ExampleFragment.newInstance("Replaced"),
                    true
            )
        }

        findViewById<Button>(R.id.btnAddFragment).setOnClickListener {
            FragmentNavigator(this, R.id.mainFrame).add(
                    ExampleFragment.newInstance("Added"),
                    true
            )
        }

        findViewById<Button>(R.id.btnAddFragmentDelayed).setOnClickListener {
            FragmentNavigator(this).addDelayed(
                    ExampleFragment.newInstance("Replaced after 1 second"),
                    true,
                    1000
            )
        }

        findViewById<Button>(R.id.btnReplaceFragmentDelayed).setOnClickListener {
            FragmentNavigator(this).replaceDelayed(
                    ExampleFragment.newInstance("Replaced after 1 second"),
                    true,
                    1000
            )
        }

        findViewById<Button>(R.id.btnShowDialogFragment).setOnClickListener {
            FragmentNavigator(this)
                    .showDialogFragment(
                            CustomerDialogFragment.newInstance(CustomerInfo())
                    )
        }
    }


}
