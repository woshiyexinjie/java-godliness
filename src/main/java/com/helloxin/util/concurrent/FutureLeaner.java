package com.helloxin.util.concurrent;

import java.util.concurrent.*;

/**
 * create by nandiexin on 2017/12/14
 **/
public class FutureLeaner {

     public static void getMethod() throws ExecutionException, InterruptedException {

         ExecutorService executorService = Executors.newCachedThreadPool();
         Callable<String> task = () -> {
             TimeUnit.SECONDS.sleep(5);
             return "select user from User";
         } ;
         Future<String> future = executorService.submit(task) ;
         System.out.println(future.get()+" time:"+System.currentTimeMillis());  // blocking
         System.out.println("End！"+" time:"+System.currentTimeMillis());
     }

    public static void main(String[] args) {

        try {

            getMethod();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
