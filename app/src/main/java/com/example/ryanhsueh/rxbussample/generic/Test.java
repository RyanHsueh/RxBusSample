package com.example.ryanhsueh.rxbussample.generic;

/**
 * Created by ryanhsueh on 2018/7/25
 */
public class Test<T> {

    private T t;

    public Test(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
