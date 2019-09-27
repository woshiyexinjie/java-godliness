package com.helloxin.util.colletction.queue.bloking;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by yexin on 2019/9/17.
 */
public class JavaSynchronousQueueExample {

    public static void main(String args[]) {


        //SynchroousQueue 真的是需要同时存在消费者和生产者才可以  put 和 take 操作会阻塞
        final SynchronousQueue queue = new SynchronousQueue();

        // start publisher thread
        new Thread(new QueueProducer(queue)).start();

        // start consumer thread
        new Thread(new QueueConsumer(queue)).start();

    }
}
