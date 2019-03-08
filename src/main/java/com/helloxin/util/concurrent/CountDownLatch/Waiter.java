package com.helloxin.util.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nandiexin on 2019/3/8.
 */
public class Waiter implements Runnable {

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }
}
