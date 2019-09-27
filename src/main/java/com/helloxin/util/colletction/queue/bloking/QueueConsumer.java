package com.helloxin.util.colletction.queue.bloking;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by yexin on 2019/9/17.
 */
public class QueueConsumer implements Runnable {

    private SynchronousQueue queue;

    public QueueConsumer(SynchronousQueue queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
            String event = (String) queue.take();
            // thread will block here
            System.out.printf("[%s] consumed event : %s %n", Thread
                    .currentThread().getName(), event);

            String event2 = (String) queue.take();
            // thread will block here
            System.out.printf("[%s] consumed event : %s %n", Thread
                    .currentThread().getName(), event2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

