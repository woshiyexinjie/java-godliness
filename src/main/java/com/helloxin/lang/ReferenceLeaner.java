package com.helloxin.lang;

import java.lang.ref.*;
import java.util.LinkedList;

/**
 * Created by nandiexin on 2019/3/14.
 */
public class ReferenceLeaner {


    public static void main(String[] args) throws InterruptedException {


//        SoftReference<String> sr = new SoftReference<String>(new String("hello"));
//        System.out.println(sr.get());
//
//        String str=new String("abc");
//        WeakReference<String> abcWeakRef = new WeakReference<String>(str);
//        while(true){
//            if(null == str){
//
//                System.out.println(" I am scrached");
//
//            }else{
//
//                System.out.println(" I want to be scrached");
//
//            }
//            Thread.sleep(1000);
//            System.gc();
//        }


//        SoftReference<String> softRef=new SoftReference<String>("HELOO XIN");
//        System.out.println(softRef.get());


//        WeakReference<String> sr2 = new WeakReference<String>(new String("abc"));
//
//        System.out.println(sr2.get());
//        System.gc();                //通知JVM的gc进行垃圾回收
//        System.out.println(sr2.get());

//        PhantomReference<String> sr3 = new  PhantomReference<String>("Ceshi", new ReferenceQueue<>());
//
//        System.out.println(sr3.get());


        int size = 3;
        LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            weakList.add(new VeryBigWeakReference(new VeryBig("Weak " + i), rq));
            System.out.println("Just created weak: " + weakList.getLast());

        }

        System.gc();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkQueue();
    }

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> ref = null;
        while ((ref = rq.poll()) != null) {
            if (ref != null) {
                System.out.println("In queue: " + ((VeryBigWeakReference) (ref)).id);
            }
        }
    }
}


class VeryBig {
    public String id;
    // 占用空间,让线程进行回收
    byte[] b = new byte[2 * 1024];

    public VeryBig(String id) {
        this.id = id;
    }

    protected void finalize() {
        System.out.println("Finalizing VeryBig " + id);
    }
}

class VeryBigWeakReference extends WeakReference<VeryBig> {
    public String id;

    public VeryBigWeakReference(VeryBig big, ReferenceQueue<VeryBig> rq) {
        super(big, rq);
        this.id = big.id;
    }

    protected void finalize() {
        System.out.println("Finalizing VeryBigWeakReference " + id);
    }
}

