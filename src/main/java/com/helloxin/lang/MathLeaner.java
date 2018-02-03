package com.helloxin.lang;

/**
 * Created by nandiexin on 2018/1/23.
 */
public class MathLeaner {


    public static void main(String[] args) {

        //圆周率
        System.out.println("Math.PI:"+Math.PI);
        //这个一般好像用不到
        System.out.println("Math.E:"+Math.E);

        System.out.println("Math.abs:"+Math.abs(-10));

        //这边里面的计算取得是 strictMath 的值
        System.out.println("Math.acos:"+Math.acos(45));

        System.out.println("Math.addExact:"+Math.addExact(10,10));

        System.out.println("Math.cbrt:"+Math.cbrt(34.12));

        System.out.println("Math.ceil:"+Math.ceil(10.12));

        System.out.println("Math.max:"+Math.max(10,20));

        System.out.println("Math.multiplyExact:"+Math.multiplyExact(10,15));

        System.out.println("Math.multiplyFull:"+Math.multiplyFull(10,15));

        System.out.println("Math.multiplyHigh:"+Math.multiplyHigh(10,15));

        System.out.println("Math.negateExact:"+Math.negateExact(89));

        System.out.println("Math.negateExact:"+Math.random());

        System.out.println("Math.negateExact:"+Math.toIntExact(90));

        //看不懂这是什么东西
        System.out.println("Math.ulp:"+Math.ulp(90));



        System.out.println("StrictMath.tan:"+StrictMath.tan(10));



    }

}
