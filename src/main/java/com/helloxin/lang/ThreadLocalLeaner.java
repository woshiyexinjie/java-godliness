package com.helloxin.lang;

/**
 * Created by nandiexin on 2019/2/16.
 */
public class ThreadLocalLeaner {



    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();

        @Override
        public void run() {
            if(null == threadLocal.get() ) {
                threadLocal.set((int) (Math.random() * 100D));
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args) throws InterruptedException {


       /* ThreadLocal myThreadLocal = new ThreadLocal();
        myThreadLocal.set("helloxin,one");


        ThreadLocal<String> myThreadLocal2 = new ThreadLocal<String>();
        myThreadLocal2.set("helloxin,two");

        ThreadLocal myThreadLocal3 = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "This is the initial value";
            }


        };*/

        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate


    }
}
