package com.helloxin.lang;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

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

        WeakReference<String> sr2 = new WeakReference<String>(new String("abc"));

        System.out.println(sr2.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr2.get());



    }
}
