package com.sha.kamel.navigator;

/**
 * Created by Sha on 11/11/17.
 */

public class NavigatorOptions {
    private static final NavigatorOptions ourInstance = new NavigatorOptions();

    public static NavigatorOptions instance() {
        return ourInstance;
    }

    private NavigatorOptions() {}

    public int frameLayoutResource;


}
