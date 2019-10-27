package com.sha.kamel.sample.ui

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import com.sha.kamel.sample.R
import com.sha.kamel.sample.model.Message

import org.parceler.Parcels

class ExampleActivity : AppCompatActivity() {

    private var tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)

        tv = findViewById(R.id.tv)

        val message = Parcels.unwrap<Message>(intent.getParcelableExtra<Parcelable>("message"))
                ?: return

        tv!!.text = message.message

        findViewById<View>(R.id.btnBack).setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

}
