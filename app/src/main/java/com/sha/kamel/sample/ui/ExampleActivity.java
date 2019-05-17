package com.sha.kamel.sample.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sha.kamel.sample.R;
import com.sha.kamel.sample.model.Message;

import org.parceler.Parcels;

public class ExampleActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        tv = findViewById(R.id.tv);

        Message message = Parcels.unwrap(getIntent().getParcelableExtra("message"));

        if (message == null) return;

        tv.setText(message.message);

        findViewById(R.id.btnBack).setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });
    }

}
