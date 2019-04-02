package com.helloxin.util.timer;

import java.util.TimerTask;

/**
 * Created by nandiexin on 2019/3/29.
 */
@SuppressWarnings("ALL")
public class HiRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (1 == 1) {
            throw new RuntimeException("hih");
        }
        System.out.println("hi,xin!    time" + System.currentTimeMillis());
    }


}
