package com.helloxin.util.colletction;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nandiexin on 2019/3/28.
 */
public class HashMapTest {

    public static void main(String[] args) throws InterruptedException {


        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(new Random().nextInt(1000000000) + Thread.currentThread().getName(), 1);
                    System.out.println("FINISH --- HAHAH" + Thread.currentThread().getName());
                }
            }
            ).start();


        }
        Thread.sleep(20000L);
        System.out.println(map.size());
        Thread.sleep(1000000L);
    }
}
