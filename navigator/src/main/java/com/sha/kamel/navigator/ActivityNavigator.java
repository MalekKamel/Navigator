package com.sha.kamel.navigator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sha.kamel.navigator.model.Flags;
import com.sha.kamel.navigator.model.ParcelableInfo;

import java.util.Arrays;

public class ActivityNavigator {

    private Activity activity;
    private ParcelableInfo parcelableInfo = new ParcelableInfo();
    private Flags flags = new Flags();

    public ActivityNavigator(Activity activity) {
        this.activity = activity;
    }

    /**
     * Navigate with a class
     * @param clazz type
     */
    public void navigate(@NonNull Class<?> clazz) {
        Intent intent = new Intent(activity, clazz);
        navigate(intent);
    }

    /**
     * Navigate with an Intent
     * @param intent instance
     */
    public void navigate(Intent intent) {
        flags.addToIntent(intent);
        parcelableInfo.addToIntent(intent);
        activity.startActivity(intent);
    }

    public void navigateDelayed(
            @NonNull Class<?> clazz,
            long delayMillis,
            Procedure callbackAfterNavigation
    ) {
        new Handler().postDelayed(
                () -> {
                    navigate(clazz);

                    if (callbackAfterNavigation != null)
                        callbackAfterNavigation.run();
                },
                delayMillis);
    }

    public void navigateDelayed(
            @NonNull Class<?> clazz,
            long delayMillis
    ) {
        navigateDelayed(clazz, delayMillis, null);
    }

    public void navigateDelayed(
            @NonNull Intent intent,
            long delayMillis,
            Procedure callbackAfterNavigation
    ) {
        new Handler().postDelayed(
                () -> {
                    navigate(intent);

                    if (callbackAfterNavigation != null)
                        callbackAfterNavigation.run();
                },
                delayMillis);
    }

    public void navigateDelayed(
            @NonNull Intent intent,
            long delayMillis
    ) {
        navigateDelayed(intent, delayMillis, null);
    }

    public void startActivityForResult(@NonNull Class<?> clazz, int requestCode) {
        Intent intent = new Intent(activity, clazz);
        parcelableInfo.addToIntent(intent);
        flags.addToIntent(intent);
        activity.startActivityForResult(intent, requestCode);
    }

    public void showRouteInGoogleMap(double lat1, double lng1, double lat2, double lng2){
        String url = new StringBuilder()
                .append("http://maps.google.com/maps?saddr=")
                .append(lat1)
                .append(",")
                .append(lng1)
                .append("&daddr=")
                .append(lat2)
                .append(",")
                .append(lng2)
                .toString();
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url));
        flags.addToIntent(intent);
        activity.startActivity(intent);
    }

    public void navigateToSettings(){
        Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
        flags.addToIntent(intent);
        activity.startActivity(intent);
    }

    public void openCamera(Fragment fragment, int requestCode){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(activity.getPackageManager()) == null)  return;
        fragment.startActivityForResult(takePictureIntent, requestCode);
    }

    public void openCamera(int requestCode){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(activity.getPackageManager()) == null)  return;
        flags.addToIntent(intent);
        activity.startActivityForResult(intent, requestCode);
    }

    public void openInGooglePlay(){
        openInGooglePlay(activity.getPackageName());
    }

    public void openInGooglePlay(String packageName){
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + packageName));
        flags.newTask();
        navigate(intent);
    }

    public ActivityNavigator withParcelable(Parcelable parcelable, String name) {
        this.parcelableInfo.parcelable = parcelable;
        this.parcelableInfo.name = name;
        return this;
    }

    public ActivityNavigator withFlags(Flags flags){
        this.flags = flags;
        return this;
    }

    public ActivityNavigator withFlags(Integer... flags){
        this.flags.flags = Arrays.asList(flags);
        return this;
    }

}
