package com.example.ryanhsueh.rxbussample;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * Created by ryanhsueh on 2018/7/25
 */
public class RxBus2 {

    // Backpressure solution
    private final FlowableProcessor<Object> subject;

    private RxBus2() {
        // toSerialized for thread safe
        subject = PublishProcessor.create().toSerialized();
    }

    public static RxBus2 getInstance() {
        return Holder.BUS;
    }

    public void post(Object obj) {
        subject.onNext(obj);
    }

    public <T> Flowable<T> toFlowable(Class<T> eventType) {
        return subject.ofType(eventType);
    }

    public Flowable<Object> toFlowable() {
        return subject;
    }

    public boolean hasSubscribers() {
        return subject.hasSubscribers();
    }

    private static class Holder {
        private static final RxBus2 BUS = new RxBus2();
    }

}
