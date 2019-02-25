package com.helloxin.util.concurrent.volatiletest;

/**
 * Created by nandiexin on 2019/2/21.
 */
public class ThreadB extends Thread {
    private MyList myList;

    public ThreadB(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
//        try {
//            System.out.println("b run");
//            while (true){
//                if(myList.size() == 5){
//                    System.out.println("线程b要退出了");
//                    throw new InterruptedException();
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        synchronized (myList) {

            try {
                System.out.println("b run");
                while (true) {
                    if (!myList.flag) {
                        try {
                            myList.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    if (myList.size() == 5) {
                        System.out.println("线程b要退出了");
                        throw new InterruptedException();
                    }
                    myList.flag = false;
                    myList.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
