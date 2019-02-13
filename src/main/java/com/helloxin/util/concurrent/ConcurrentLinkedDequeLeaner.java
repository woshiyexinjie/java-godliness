package com.helloxin.util.concurrent;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by nandiexin on 2018/12/5.
 */
public class ConcurrentLinkedDequeLeaner {

    public static void main(String[] args) {

        ConcurrentLinkedDeque c = new ConcurrentLinkedDeque();

        for(Integer i=0,l;i<10;i++){
            l =i;
            System.out.println(l);
        }


    }
}
