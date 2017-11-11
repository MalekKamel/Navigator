package com.sha.kamel.sample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sha.kamel.navigator.Navigator;
import com.sha.kamel.sample.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    protected TextView tv;

    @BindView(R.id.btn_press)
    protected Button btn_press;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
    }

    protected void setText(String text){
        tv.setText(text);
    }

    protected void addText(String text){
        String s = tv.getText() + "\n" + text;
        tv.setText(s);
    }

    protected void toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    protected <T> T parseParcelable(String key){
        Intent intent = getIntent();
        return Parcels.unwrap(intent.getParcelableExtra(key));
    }

    protected <T> T parseParcelable(){
        return parseParcelable(Navigator.DEFAULT_PARCELABLE_NAME);
    }


    @OnClick( R.id.btn_press)
    public void onClickPressBtn(View v) {
    }
}

