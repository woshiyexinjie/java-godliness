package com.helloxin.util.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nandiexin on 2019/3/8.
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();

        Thread.sleep(4000);
    }
}
