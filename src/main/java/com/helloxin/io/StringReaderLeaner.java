package com.helloxin.io;

import com.helloxin.util.concurrent.ThreadXinPoolService;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nandiexin on 2019/4/18.
 */
public class StringReaderLeaner {

    @SuppressWarnings("AlibabaThreadPoolCreation")
    public static void main(String[] args) throws IOException, InterruptedException {


        StringReader reader = new StringReader("Helloxin");
        System.out.println((char) reader.read());
        System.out.println((char) reader.read());


        //使用多线程看一下

//        ExecutorService executors = Executors.newFixedThreadPool(5);
        ThreadXinPoolService executors = new ThreadXinPoolService();

        executors.addTask(() -> {
            try {
                Thread.sleep(1000L);
                System.out.println((char) reader.read());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executors.addTask(() -> {
            try {
                System.out.println((char) reader.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(2000L);

        executors.stop();

    }
}
