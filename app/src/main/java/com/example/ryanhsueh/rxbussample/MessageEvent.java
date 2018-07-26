package com.example.ryanhsueh.rxbussample;

/**
 * Created by ryanhsueh on 2018/7/24
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
