package com.helloxin.util.concurrent;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by nandiexin on 2018/10/30.
 */
public class DelayqueueLeaner {


    public static void main(String[] args) {


        System.out.println(new Date());
        DelayQueue<Message> queue = new DelayQueue<Message>();
        Message m1 = new Message(14534545, "xin", 3000);
        Message m2 = new Message(23453453, "hi", 100);
        queue.offer(m2);
        queue.offer(m1);
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(new Consumer(queue));
        exec.shutdown();
    }
}

class Message implements Delayed {

    private int msgId;
    private String body;
    private long excuteTime;

    public int getMsgId() {
        return msgId;
    }

    public String getBody() {
        return body;
    }

    public long getExcuteTime() {
        return excuteTime;
    }

    public Message(int msgId, String body, long delayTime) {
        this.msgId = msgId;
        this.body = body;
        this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    @Override
    public int compareTo(Delayed delayed) {
        Message msg = (Message) delayed;
        return this.excuteTime > msg.excuteTime ? 1
                : (this.excuteTime < msg.excuteTime ? -1 : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }
}

class Consumer implements Runnable {
    // 延时队列 ,消费者从其中获取消息进行消费
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            try {
                Message take = queue.take();
                System.out.println("消费消息msgId：" + take.getMsgId() + " 消息内容：" + take.getBody());
                System.out.println(new Date());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
