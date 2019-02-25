package com.helloxin.util.concurrent.volatiletest;

/**
 * Created by nandiexin on 2019/2/21.
 */
public class ThreadA extends Thread {
    private MyList myList;

    public ThreadA(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        // try {
        System.out.println("a run");
//            for (int i = 0; i < 10; i++) {
//                myList.add();
//                System.out.println("添加了"+(i+1)+"个元素");
//                Thread.sleep(1000);
//            }
        for (int i = 0; i < 10; i++) {
            synchronized (myList) {
                if (myList.flag) {
                    try {
                        myList.wait();
                    } catch (InterruptedException e) {
                    }
                }
                myList.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                myList.flag = true;
                myList.notify();
            }
        }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
