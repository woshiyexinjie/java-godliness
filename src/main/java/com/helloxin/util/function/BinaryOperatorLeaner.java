package com.helloxin.util.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * Created by nandiexin on 2018/12/20.
 */
public class BinaryOperatorLeaner {

    public static void main(String[] args) {

        BinaryOperator<Integer> addStr = (n1, n2) -> n1 + n2;
        System.out.println(addStr.apply(3, 6));

        BinaryOperator<Integer> bi = BinaryOperator.minBy(Comparator.naturalOrder());
        System.out.println(bi.apply(2, 3));

        BinaryOperator<Integer> bi2 = BinaryOperator.maxBy(Comparator.naturalOrder());
        System.out.println(bi2.apply(2, 3));


//        XinBinaryOperator<String> xinBinaryOperator = (n1, n2) -> n1;
//        System.out.println(xinBinaryOperator.apply("3", "6"));

    }
}
