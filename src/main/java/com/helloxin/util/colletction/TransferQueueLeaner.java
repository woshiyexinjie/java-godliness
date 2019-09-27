package com.helloxin.util.colletction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by yexin on 2019/9/16.
 */
public class TransferQueueLeaner {

    static LinkedTransferQueue<String> lnkTransQueue = new LinkedTransferQueue<String>();
    public static void main(String[] args) {
        //不知道为什么这里换成自定义的线程池就会报错
        ExecutorService exService = Executors.newFixedThreadPool(2);
        Producer producer = new TransferQueueLeaner().new Producer();
        Consumer consumer = new TransferQueueLeaner().new Consumer();
        exService.execute(producer);
        exService.execute(consumer);
        exService.shutdown();
    }
    class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<3;i++){
                try {
                    System.out.println("Producer is waiting to transfer...");
                    lnkTransQueue.transfer("A"+i);
                    System.out.println("producer transfered element: A"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<3;i++){
                try {
                    System.out.println("Consumer is waiting to take element...");
                    String s= lnkTransQueue.take();
                    System.out.println("Consumer received Element: "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
