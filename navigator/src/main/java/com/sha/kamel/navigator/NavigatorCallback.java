package com.sha.kamel.navigator;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by Sha on 4/1/17.
 */

public interface NavigatorCallback {

    void navigateToActivity(@NonNull Class<?> clazz);

    void startActivityForResult(@NonNull Class<?> clazz, int key);

    void navigateToFragment(Fragment fragment, boolean addToBackStack);

    void navigateToFragment(Fragment fragment, int frameRes, boolean addToBackStack);

    Navigator parcelable(Parcelable parcelable);

    void removeFragmentFromFrame(Fragment fragment);
}
