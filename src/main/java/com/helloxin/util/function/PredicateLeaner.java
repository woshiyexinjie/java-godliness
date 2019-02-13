package com.helloxin.util.function;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by nandiexin on 2018/12/12.
 */
public class PredicateLeaner {

    public static void testPredicate(){

        int nums[] = {3,5,6,32,23,67,434,2,45,8,3};
        Arrays.stream(nums)
                .filter(x->x>10)
                .forEach(s-> System.out.println(s));

    }


    public static void testBiPredicate(){

        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
        System.out.println(bi.test(2, 3));

    }



    public static void main(String[] args) {
//        testPredicate();


        IntStream.of(1,2,3,4,5,6,7).boxed()
                .collect(Collectors.toList());

    }

}
