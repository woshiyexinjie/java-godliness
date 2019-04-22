package com.helloxin.util.concurrent;

import java.util.concurrent.*;

/**
 * Created by nandiexin on 2019/4/18.
 */
public class ThreadXinPoolService {

    /**
     * 主线程数
     */
    private int corePoolSize = 2;

    /**
     * 最大线程数
     */
    private int maximumPoolSize = 60;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    private long keepAliveTime = 2000;

    /**
     * 单例的线程池类
     */
    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * 线程池所使用的缓冲队列的大小
     */
    private int queueSize = 100;


    public ThreadXinPoolService() {

        this.threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize), new BlockingQueuePut());

        threadPoolExecutor.allowCoreThreadTimeOut(false);

    }

    private static class BlockingQueuePut implements RejectedExecutionHandler {
        /**
         * define the reject policy when executor queue is full
         *
         * @see java.util.concurrent.RejectedExecutionHandler
         * #rejectedExecution(java.lang.Runnable, java.util.concurrent.ThreadPoolExecutor)
         */
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void addTask(Runnable task) {

        threadPoolExecutor.execute(task);

    }

    public <T> Future<T> addTask(Callable<T> task) {

        return threadPoolExecutor.submit(task);
    }

    public void stop() {

        threadPoolExecutor.shutdownNow();
    }


}
