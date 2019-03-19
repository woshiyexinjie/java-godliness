package com.helloxin.lang.cloneable;

import java.util.Arrays;

/**
 * Created by nandiexin on 2019/3/18.
 */
public class ArrayCopyLeaner {

    public static void main(String[] args) {


        //clone
//        int[] arr1 = {1, 2};
//        int[] arr2 = arr1.clone();
//
//        arr1[0] = 50;
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
//
//
//        String[] arr3 = {"a1", "a2"};
//        String[] arr4 = arr3.clone();
//
//        arr3[0] = "b1";
//        System.out.println(Arrays.toString(arr3));
//        System.out.println(Arrays.toString(arr4));

          //system.arraycopy
//        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
//        int[] arr2 = new int[16];
//
//        System.arraycopy(arr1, 1, arr2, 4, 3);
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));


        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOf(arr1, 3);

        System.out.println(Arrays.toString(arr1)) ;
        System.out.println(Arrays.toString(arr2));


//        int[] arr1 = {1, 2, 3, 4, 5};
//        int[] arr2 = Arrays.copyOfRange(arr1, 1, 3);
//
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));




    }
}
