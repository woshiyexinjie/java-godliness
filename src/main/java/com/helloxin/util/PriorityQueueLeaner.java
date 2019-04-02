package com.helloxin.util;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Created by nandiexin on 2018/10/10.
 */
public class PriorityQueueLeaner {

    public static void main(String[] args) {

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
//        priorityQueue.add(5);
//        priorityQueue.add(2);
//        priorityQueue.add(8);
//        priorityQueue.add(7);
//        priorityQueue.add(1);
//        priorityQueue.add(10);
//
//        System.out.println(priorityQueue);
//        System.out.println(priorityQueue.peek());
//        System.out.println(priorityQueue.add(3));
//
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int n = sc.nextInt();
//            int minPower = 0;
//            Queue<Integer> queue = new PriorityQueue<>();
//
//            for(int i=0; i<n; i++){
//                queue.add(sc.nextInt());
//            }
//
//            int first = 0, second = 0, temp = 0;
//            while (queue.size() > 1){
//                first = queue.poll();
//                second = queue.poll();
//                temp = first + second;
//                queue.add(temp);
//
//                minPower += temp;
//            }
//            System.out.println(minPower);
//        }

        //神奇的split方法
//        String str = "a,b,c,,,,";
//        String[] ary = str.split(","); //预期大于 3，结果是 3
//        System.out.println(ary.length);


        //在for-each模式下的 删除
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }

    }
}
