package com.helloxin.util.colletction.queue.bloking;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by yexin on 2019/9/17.
 */
public class QueueProducer implements Runnable{

    private SynchronousQueue queue;

    public QueueProducer(SynchronousQueue queue) {
        this.queue=queue;
    }
    @Override
    public void run() {

        String event = "SYNCHRONOUS_EVENT";
        String another_event ="ANOTHER_EVENT";
        try {
            queue.put(event);
            System.out.printf("[%s] published event : %s %n", Thread
                    .currentThread().getName(), event);

            queue.put(another_event);
            System.out.printf("[%s] published event : %s %n", Thread
                    .currentThread().getName(), another_event);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
