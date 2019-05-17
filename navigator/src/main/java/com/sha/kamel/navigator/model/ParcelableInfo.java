package com.sha.kamel.navigator.model;

import android.content.Intent;
import android.os.Parcelable;

public class ParcelableInfo {
    public Parcelable parcelable;
    public String name;

    public void addToIntent(Intent intent) {
        if (parcelable == null) return;
        intent.putExtra(name, parcelable);
    }
}
