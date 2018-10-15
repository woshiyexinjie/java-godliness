package com.helloxin.util;

import java.sql.SQLOutput;
import java.util.PriorityQueue;

/**
 * Created by nandiexin on 2018/10/10.
 */
public class PriorityQueueLeaner {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(8);
        priorityQueue.add(7);
        priorityQueue.add(1);
        priorityQueue.add(10);

        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.add(3));

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }
}
