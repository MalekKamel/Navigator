package com.sha.kamel.navigator;

/**
 * Created by Sha on 11/11/17.
 */

public class NavigatorData {
    private static final NavigatorData ourInstance = new NavigatorData();

    public static NavigatorData instance() {
        return ourInstance;
    }

    private NavigatorData() {}

    public int frameLayoutResource;


}
