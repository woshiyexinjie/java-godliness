package com.helloxin.lang;

/**
 * Created by nandiexin on 2018/1/31.
 */
public class BooleanLeaner {


    public static void testNUll(){
        boolean result = false ;
        if(!result){
            System.out.println("result:"+result);
        }
        Boolean result2 = null;
        //这个 ！操作 对于 null 的时候会报错 对 null 做这种操作 报错还是可以理解的
        if(!result2){
            System.out.println("result2:"+result2);
        }

        //这种Boolean 类型 与 null
        Boolean a = false;
        if( a == null){
            System.out.println("hhhh");
        }

    }


    public static void main(String[] args) {
        testNUll();

    }
}
