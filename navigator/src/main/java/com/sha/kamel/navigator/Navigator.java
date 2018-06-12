package com.sha.kamel.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sha on 4/1/17.
 */

public class Navigator {
    public static final String DEFAULT_PARCELABLE_NAME = "default_intent_parcelable";
    public static final int DEFAULT_START_ACTIVITY_FOR_RESULT_KEY = 1;
    public static final int DEFAULT_OPEN_CAMERA_REQUEST = 2;

    private Context context;
    private Parcelable extraParcelable;
    private List<Integer> flags = new ArrayList<>();
    private int frameResource;
    private Object fragmentData;
    private String parcelableName;
    private int requestCode;

    public Navigator(Context context) {
        if (context == null) throw new RuntimeException("Context can't be null");
        this.context = context;
    }

    public void openInGooglePlay(){
        openInGooglePlay(context.getPackageName());
    }

    public void openInGooglePlay(String packageName){
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + packageName));
        newTask();
        navigateToActivity(intent);
    }

    public void navigateToActivity(Intent intent) {
        activityFlags(intent);
        activityParcelable(intent);
        context.startActivity(intent);
    }

    public void navigateToActivity(@NonNull Class<?> clazz) {
        Intent intent = new Intent(context,clazz);
        activityFlags(intent);
        activityParcelable(intent);
        context.startActivity(intent);
    }

    public void navigateToActivityDelayed(
            @NonNull Class<?> clazz,
            long delayMillis,
            Func callbackAfterNavigation
    ) {
        new Handler().postDelayed(
                () -> {
                    navigateToActivity(clazz);
                    callbackAfterNavigation.call();
                },
                delayMillis);
    }

    public void navigateToActivityDelayed(
            @NonNull Class<?> clazz,
            long delayMillis) {
        new Handler().postDelayed(
                () -> navigateToActivity(clazz),
                delayMillis);
    }

    public void openGoogleMapApp(double lat1, double lng1, double lat2, double lng2){
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
        context.startActivity(intent);
    }

    public void startActivityForResult(@NonNull Class<?> clazz) {
        startActivityForResult(clazz, requestCode);
    }

    public void startActivityForResult(@NonNull Class<?> clazz, int key) {
        this.requestCode = key;

        Intent intent = new Intent(context,clazz);
        activityParcelable(intent);
        ((Activity)context).startActivityForResult(intent, getRequestCode());
    }

    public void navigateToFragment(Fragment fragment, boolean addToBackStack) {
        navigateToFragment(fragment, frameResource, addToBackStack);
    }

    public void navigateToFragmentDelayed(
            Fragment fragment,
            boolean addToBackStack,
            long delayMillis
    ) {
        new Handler().postDelayed(
                () -> navigateToFragment(fragment, frameResource, addToBackStack),
                delayMillis);

    }

    public void navigateToFragmentDelayed(
            Fragment fragment,
            boolean addToBackStack,
            long delayMillis,
            Func callbackAfterNavigation
    ) {
        new Handler().postDelayed(
                () -> {
                    navigateToFragment(fragment, frameResource, addToBackStack);
                    callbackAfterNavigation.call();
                },
                delayMillis);

    }

    public void replaceAndroidContent(Fragment fragment) {
        FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
        if (fm.findFragmentById(android.R.id.content) == null) {
            fm.beginTransaction().add(android.R.id.content, fragment).commit();
        }
    }

    public void navigateToFragment(Fragment fragment, int frameResource, boolean addToBackStack) {
        this.frameResource = frameResource;
        passFragmentData(fragment);
        fragmentParcelable(fragment);

        FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();

        if (fragment.isAdded()){
            Log.e(getClass().getSimpleName(), "fragment: " + fragment.getClass().getSimpleName() +" already added.");
            return;
        }

        ft.replace(getFrameResource(),fragment,fragment.getClass().getSimpleName());
        if (addToBackStack)
            ft.addToBackStack(fragment.getClass().getSimpleName());
        ft.commitAllowingStateLoss();
    }

    public void removeFragmentFromFrame(Fragment fragment) {
        ((FragmentActivity)context).getSupportFragmentManager()
                .beginTransaction()
                .remove(fragment)
                .commit();
    }

    public void openCamera(Fragment fragment){
        startCamera(fragment);
    }

    public void openCamera(){
        startCamera(null);
    }

    private void startCamera(Fragment fragment) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
            if (fragment == null)
                ((Activity)context).startActivityForResult(takePictureIntent, DEFAULT_OPEN_CAMERA_REQUEST);
            else
                fragment.startActivityForResult(takePictureIntent, DEFAULT_OPEN_CAMERA_REQUEST);
        }
    }

    public void showDialogFragment(DialogFragment dialog){
        fragmentParcelable(dialog);
        passFragmentData(dialog);

        dialog.show(
                ((AppCompatActivity) context).getSupportFragmentManager(),
                dialog.getClass().getSimpleName()
        );
    }

    public void navigateToSettings(){
        Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
        activityFlags(intent);
        context.startActivity(intent);
    }

    public void navigateToOperatorSettings(){
        Intent intent = new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
        activityFlags(intent);
        context.startActivity(intent);
    }

    public Navigator parcelable(Parcelable parcelable) {
        this.extraParcelable = parcelable;
        return this;
    }

    public Navigator parcelableName(String name){
        this.parcelableName = name;
        return this;
    }

     public Navigator fragmentData(Object object){
        this.fragmentData = object;
        return this;
    }

    public Navigator frameResource(int resource){
        this.frameResource = resource;
        return this;
    }

    public Navigator newTask(){
        addFlag(Intent.FLAG_ACTIVITY_NEW_TASK);
        return this;
    }

    public Navigator requestCode(int key){
        requestCode = key;
        return this;
    }

    public Navigator singleTop(){
        addFlag(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return this;
    }

    public Navigator clearTop(){
        addFlag(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return this;
    }

    public Navigator clearWhenTaskReset(){
        addFlag(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        return this;
    }

    public Navigator excludeFromRecents(){
        addFlag(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        return this;
    }

    public Navigator forwardResult(){
        addFlag(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        return this;
    }

    public Navigator launchedFromHistory(){
        addFlag(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        return this;
    }

    public Navigator launchAdjacent(){
        addFlag(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT);
        return this;
    }

    public Navigator multipleTask(){
        addFlag(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        return this;
    }

    public Navigator newDocument(){
        addFlag(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        return this;
    }

    public Navigator noAnimation(){
        addFlag(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        return this;
    }

    public Navigator noHistory(){
        addFlag(Intent.FLAG_ACTIVITY_NO_HISTORY);
        return this;
    }

    public Navigator noUserAction(){
        addFlag(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
        return this;
    }

    public Navigator previousIsTop(){
        addFlag(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        return this;
    }

    public Navigator reorderToFront(){
        addFlag(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        return this;
    }

    public Navigator resetTaskIfNeeded(){
        addFlag(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        return this;
    }

    public Navigator retainInRecents(){
        addFlag(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS);
        return this;
    }

    public Navigator taskOnHome(){
        addFlag(Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        return this;
    }

    // Private methods ------------------------

    private void activityFlags(Intent intent) {
        if (flags == null || flags.isEmpty()) return;

        for (int flag : flags){
            intent.addFlags(flag);
        }
    }

    private void addFlag(int flag) {
        if (flags == null) flags = new ArrayList<>();
        this.flags.add(flag);
    }

    private void activityParcelable(Intent intent) {
        if (extraParcelable != null)
            intent.putExtra(getParcelableName(), extraParcelable);
    }

    private String getParcelableName() {
       return TextUtils.isEmpty(parcelableName) ? DEFAULT_PARCELABLE_NAME : parcelableName;
    }

    private void fragmentParcelable(Fragment fragment) {
        if (extraParcelable != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(getParcelableName(), extraParcelable);
            fragment.setArguments(bundle);
        }
    }

    private int getFrameResource(){
        if (frameResource > 0)
            return frameResource;

        else if (NavigatorOptions.instance().frameLayoutResource > 0)
            return NavigatorOptions.instance().frameLayoutResource;

        else
            throw new RuntimeException("FrameLayout resource must be provided.");
    }

    private int getRequestCode() {
        if (requestCode > 0)
            return requestCode;
        return DEFAULT_START_ACTIVITY_FOR_RESULT_KEY;
    }

    private void passFragmentData(Fragment fragment) {
        if (fragmentData != null && fragment instanceof DataReceivable){
            DataReceivable dataReceivable = (DataReceivable) fragment;
            dataReceivable.receivedData(fragmentData);
        }
    }

}
