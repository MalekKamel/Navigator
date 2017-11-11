package com.sha.kamel.sample;

import org.parceler.Parcel;

/**
 * Created by Sha on 11/10/17.
 */

@Parcel
public class ClientInfo {
     String name = "Shaban Kamel";
     int age = 28;
     String mobile = "01020485203";
     String area = "Cairo";

    public ClientInfo setName(String name) {
        this.name = name;
        return this;
    }

    public ClientInfo setAge(int age) {
        this.age = age;
        return this;
    }

    public ClientInfo setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ClientInfo setArea(String area) {
        this.area = area;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }

    public String getArea() {
        return area;
    }
}
