package com.sha.kamel.sample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sha.kamel.navigator.Navigator;
import com.sha.kamel.sample.ClientInfo;
import com.sha.kamel.sample.R;
import com.sha.kamel.sample.ui.ClientInfoDialogFragment;
import com.sha.kamel.sample.ui.fragment.Fragment1;
import com.sha.kamel.sample.ui.fragment.Fragment2;
import com.sha.kamel.sample.ui.fragment.Fragment3;
import com.sha.kamel.sample.ui.fragment.Fragment4;
import com.sha.kamel.sample.ui.fragment.Fragment5;
import com.sha.kamel.sample.ui.fragment.Fragment6;

import org.parceler.Parcels;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.btn_a1,
            R.id.btn_a2,
            R.id.btn_a3,
            R.id.btn_a4,
            R.id.btn_a5,
            R.id.btn_a6,
            R.id.btn_a7,
            R.id.btn_a8,
            R.id.btn_a9,
            R.id.btn_a10,
            R.id.btn_a11,
            R.id.btn_a12,
            R.id.btn_a13,
            R.id.btn_a14,
            R.id.btn_a15,
    })
    public void onClick(View v) {

        Navigator navigator =  new Navigator(this);

        switch (v.getId()) {

            case R.id.btn_a1:
                navigator.navigateToActivity(Activity1.class);
                break;

            case R.id.btn_a2:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .navigateToActivity(Activity2.class);
                break;

            case R.id.btn_a3:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .parcelableName("my_parcel")
                        .navigateToActivity(Activity3.class);
                break;

            case R.id.btn_a4:
                navigator
                        .noHistory()
                        .navigateToActivity(Activity4.class);
                break;

            case R.id.btn_a5:
                navigator.startActivityForResult(Activity5.class);
                break;

            case R.id.btn_a6:
                navigator
                        .startActivityForResultKey(3)
                        .startActivityForResult(Activity6.class);
                break;

            case R.id.btn_a7:
                navigator.startActivityForResult(Activity7.class, 3);
                break;

            case R.id.btn_a8:
                navigator.navigateToFragment(new Fragment1(), true);
                break;

            case R.id.btn_a9:
                navigator
                        .fragmentData(new ClientInfo())
                        .navigateToFragment(new Fragment2(), true);
                break;

            case R.id.btn_a10:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .navigateToFragment(new Fragment3(), true);

                break;

            case R.id.btn_a11:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .parcelableName("my_parcelable")
                        .navigateToFragment(new Fragment4(), true);
                break;

            case R.id.btn_a12:
                navigator
                        .frameResource(R.id.anotherFrame)
                        .navigateToFragment(new Fragment5(), true);
                break;

            case R.id.btn_a13:
                navigator.navigateToFragment(new Fragment6(), R.id.anotherFrame,true);
                break;

            case R.id.btn_a14:
                navigator
                        .fragmentData(new ClientInfo())
                        .showDialogFragment(new ClientInfoDialogFragment());
                break;

            case R.id.btn_a15:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .showDialogFragment(new ClientInfoDialogFragment());
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;

        toast("result from activity: " + data.getStringExtra("activity"));
    }

    protected void toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

