package com.helloxin.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nandiexin on 2019/1/9.
 */
public class ThreadLocalRandomLeaner {


    public static  void testRandom() throws InterruptedException {

        Long begin = System.currentTimeMillis();
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<Integer>> callables = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            callables.add(() -> {
                return random.nextInt();
            });
        }
        executor.invokeAll(callables);
        callables.stream().forEach(x-> {
            try {
                System.out.println(x.call());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("end time:"+(System.currentTimeMillis()-begin));
    }

    public static  void testThreadLocalRandom() throws InterruptedException {


        Long begin = System.currentTimeMillis();
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            callables.add(() -> {
                return ThreadLocalRandom.current().nextInt();
            });
        }
        executor.invokeAll(callables);
        callables.stream().forEach(x-> {
            try {
                System.out.println(x.call());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("end time:"+(System.currentTimeMillis()-begin));


    }


    public static void main(String[] args) throws InterruptedException {

//        System.out.println(ThreadLocalRandom.current().nextInt());
//        System.out.println(ThreadLocalRandom.current().nextInt(10));
//        System.out.println(ThreadLocalRandom.current().nextInt(10,12));

//        ThreadLocalRandom.current()
//                .ints()
//                .limit(10)
//                .forEach(x-> System.out.println(x));

        ThreadLocalRandomLeaner.testThreadLocalRandom();



    }
}
