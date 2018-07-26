package com.example.ryanhsueh.rxbussample;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by ryanhsueh on 2018/7/24
 */
public class RxBus {

    // no backpressure
    private final Subject<Object> subject;

    private RxBus() {
        // toSerialized for thread safe
        subject = PublishSubject.create().toSerialized();
    }

    public static RxBus getInstance() {
        return Holder.BUS;
    }

    public void post(Object obj) {
        subject.onNext(obj);
    }

    public <T> Observable<T> toObservable(Class<T> eventType) {
        return subject.ofType(eventType);
    }

    public Observable<Object> toObservable() {
        return subject;
    }

    public boolean hasObservers() {
        return subject.hasObservers();
    }

    private static class Holder {
        private static final RxBus BUS = new RxBus();
    }

}
