package com.helloxin.util.concurrent;

import java.util.concurrent.*;

/**
 * Created by nandiexin on 2019/3/6.
 */
public class BlockQueueLeaner {

    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue queue = new ArrayBlockingQueue(1024);
//
//        Producer producer = new Producer(queue);
//        Consumer2 consumer = new Consumer2(queue);
//
//        new Thread(producer).start();
//        new Thread(consumer).start();
//
//        Thread.sleep(4000);

//        SynchronousQueue<String> synchronousQueue = new SynchronousQueue();
//        synchronousQueue.take();
//        synchronousQueue.offer("xin");
//        synchronousQueue.take();
//        synchronousQueue.put("hello");


        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {

                    queue.put(1);
                    System.out.println("putThread:1");
                    queue.put(2);
                    System.out.println("putThread:2");
                    queue.put(3);
                    System.out.println("putThread:3");
                    queue.put(4);
                    System.out.println("putThread:4");
                    queue.put(5);
                    System.out.println("putThread:5");
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                    Thread.sleep(2000);
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        takeThread.start();
        putThread.start();


    }

}

class Producer implements Runnable {

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer2 implements Runnable {

    protected BlockingQueue queue = null;

    public Consumer2(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

