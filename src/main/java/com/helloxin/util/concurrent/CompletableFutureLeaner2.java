package com.helloxin.util.concurrent;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * create by nandiexin on 2017/12/14
 **/
public class CompletableFutureLeaner2 {


    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello xin");
            System.out.println("Test");
            return "A PIG";
        });

        return completableFuture;
    }

    public Future<String> calculateAsyncSimple() throws InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(()->"hello xin");

        CompletableFuture<String> future2 = completableFuture
                .thenApply(s -> s + " World");

        CompletableFuture<Void> future3 = future2.thenAccept(
                s-> System.out.println(s+" so !")
        );

        return future2;
    }

    public void multiFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");
        //其实很少情况需要多个一起完成的情况
//        CompletableFuture<Void> combinedFuture
//                = CompletableFuture.allOf(future1, future2, future3);
//        combinedFuture.get();
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());

    }

    public void dealException() throws ExecutionException, InterruptedException {

        String name = " 异常";


        CompletableFuture<String> completableFuture
                =  CompletableFuture.supplyAsync(() -> {
            if (name == null) {
//                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

//        completableFuture.completeExceptionally(
//                new RuntimeException("Calculation failed!"));

        System.out.println(completableFuture.get());

    }

    //假如不使用 future 特性的情况下
    public void noFuture(){
        AtomicReference<String> reference = new AtomicReference<>();

        new Thread(() -> {
            //do something that is time-consuming
            reference.set("I'm done");  //任务完成完设置 reference 的值
            throw new RuntimeException("Computation error!");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(reference.get() == null) { //耐心的等待，直到 reference.get() 有值为止

        }

        System.out.println("Finally, " + reference.get());

    }

    //使用 whenComplete 不阻塞后续操作
    public void testWhenComplete(){
        CompletableFuture<Double> futurePrice = getPriceAsync();

        //do anything you want, 当前线程不被阻塞
        System.out.println(111);

        //线程任务完成的话，执行回调函数，不阻塞后续操作
        futurePrice.whenComplete((aDouble, throwable) -> {
            System.out.println(aDouble);
            //do something else
        });

        System.out.println(222);
    }

    private CompletableFuture<Double> getPriceAsync() {
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            futurePrice.complete(23.55);
//        }).start();
//        return futurePrice;
        return CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 23.55;
        });
    }

    //使用get 或者 whenComplete 如果在另一个线程发生异常，那么会持续等待


    public void waitALways() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                if (true) {
                    throw new RuntimeException("Something wrong");
                }
                futurePrice.complete(23.5);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex); //捕获的异常还会由 ExecutionException 包裹一下
            }
            //程序在捕获到异常到终止，异常类型是 ExecutionException, 而不是原始的 RuntimeExeption。
        }).start();

        System.out.println(futurePrice.get(10,TimeUnit.SECONDS));
    }

    public void waitALwaysSimple() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(()->{
            if (true) {
                throw new RuntimeException("Something wrong");
            }
            return 23.55;
        });


        System.out.println(futurePrice.get(10,TimeUnit.SECONDS));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFutureLeaner2 future = new CompletableFutureLeaner2();
//        Future<String> result = future.calculateAsyncSimple();
//        System.out.println(result.get());
//         try {

             future.waitALwaysSimple();
           TimeUnit.SECONDS.sleep(8);
//         }catch (Exception e) {
//
//         }

    }



}
