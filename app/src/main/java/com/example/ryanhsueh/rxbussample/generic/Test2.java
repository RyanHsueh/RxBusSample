package com.example.ryanhsueh.rxbussample.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanhsueh on 2018/7/25
 */
public class Test2<T> {

    private List<T> list;

    public T get(int i) {
        return list.get(i);
    }

    public void add(T t) {
        this.list.add(t);
    }

    public Test2() {
        this.list = new ArrayList<>();
    }
}
