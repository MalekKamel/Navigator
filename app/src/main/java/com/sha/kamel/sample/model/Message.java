package com.sha.kamel.sample.model;

import org.parceler.Parcel;

@Parcel
public class Message {

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public String message;
}
