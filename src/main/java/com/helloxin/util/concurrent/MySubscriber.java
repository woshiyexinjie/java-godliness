package com.helloxin.util.concurrent;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class MySubscriber<T> implements Flow.Subscriber<T> {
    private Flow.Subscription subscription;
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1); //这里要使用Long.MAX_VALUE就会被认为获取无穷的数据。
    }
    @Override
    public void onNext(T item) {
        System.out.println("Got : " + item);
        subscription.request(1); //这里也可以使用Long.MAX_VALUE
    }
    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }
    @Override
    public void onComplete() {
        System.out.println("Done");
    }

    public static void main(String[] args) throws InterruptedException {

//        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
//        //Register Subscriber
//        MySubscriber<String> subscriber = new MySubscriber<>();
//        publisher.subscribe(subscriber);
//        //Publish items
//        System.out.println("Publishing Items...");
//        String[] items = {"11", "x", "22", "x", "33", "x"};
//        Arrays.asList(items).stream().forEach(i -> publisher.submit(i));
//        publisher.close();
//        Thread.sleep(20000);

        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }
}