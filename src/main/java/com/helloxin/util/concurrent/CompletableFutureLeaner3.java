package com.helloxin.util.concurrent;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * create by nandiexin on 2017/12/14
 **/
public class CompletableFutureLeaner3 {

    public void  struct() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        completableFuture.complete("hello xin");
        System.out.println(completableFuture.get());
        System.out.println(completableFuture.get());
        System.out.println(completableFuture.get());
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFutureLeaner3   completableFutureLeaner3 = new CompletableFutureLeaner3();
        completableFutureLeaner3.struct();

    }



}
