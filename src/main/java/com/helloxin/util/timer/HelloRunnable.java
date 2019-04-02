package com.helloxin.util.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by nandiexin on 2019/3/29.
 */
@SuppressWarnings("ALL")
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello,xin! time" + System.currentTimeMillis());
    }


    public static void main(String[] args) throws InterruptedException {


        //noinspection AlibabaThreadPoolCreation
        @SuppressWarnings("AlibabaThreadPoolCreation")
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        executorService.scheduleAtFixedRate(new HelloRunnable(), 2, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new HiRunnable(), 1, 1, TimeUnit.SECONDS);

    }
}
