package com.helloxin.util.timer;

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by nandiexin on 2019/3/29.
 */
@SuppressWarnings("ALL")
public class HelloTimerTask extends TimerTask {

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello,xin! time" + System.currentTimeMillis());
    }


    public static void main(String[] args) throws InterruptedException {

        @SuppressWarnings("AlibabaAvoidUseTimer")
        Timer timer = new Timer();

        timer.schedule(new HelloTimerTask(), 2000, 1000);

        timer.schedule(new HiTimerTask(), 1000, 500);


//        timer.scheduleAtFixedRate(new HelloTimerTask(),2000,1000);
//
//        timer.scheduleAtFixedRate(new HiTimerTask(),2000,1000);
    }
}
