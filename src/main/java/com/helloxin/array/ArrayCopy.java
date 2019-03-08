package com.helloxin.array;

import java.util.Arrays;

/**
 * Created by nandiexin on 2019/3/1.
 */
public class ArrayCopy {

    public static void main(String[] args) {
        //基本数据类型（String ，boolean，char，byte，short，float ，double，long）都可以直接使用clone方法进行克隆，注意String类型是因为其值不可变所以才可以使用
/*        int[] a1 = {1, 3};
        int[] a2 = a1.clone();

        a1[0]=666;
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
*/

/*
        //String
        String[] a1 = {"a1", "a2"};
        String[] a2 = a1.clone();

        a1[0] = "b1"; //更改a1数组中元素的值
        System.out.println(Arrays.toString(a1));   //[b1, a2]
        System.out.println(Arrays.toString(a2));   //[a1, a2]
*/

//        int[] a1 = {1, 2, 3, 4, 5};
//        int[] a2 = Arrays.copyOf(a1, 3);
//
//        System.out.println(Arrays.toString(a1)) ;
//        System.out.println(Arrays.toString(a2));

        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = Arrays.copyOfRange(a1, 0, 1);

        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [1]


    }


}
