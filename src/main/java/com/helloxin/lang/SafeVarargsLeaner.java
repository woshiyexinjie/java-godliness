package com.helloxin.lang;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nandiexin on 2018/12/3.
 *
 * @SafeVarargs在JDK 7中引入，主要目的是处理可变长参数中的泛型，此注解告诉编译器：在可变长参数中的泛型是类型安全的。可变长参数是使用数组存储的，而数组和泛型不能很好的混合使用
 */
public class SafeVarargsLeaner {





    @SafeVarargs
    public static <T> void printSome(T ...nums){
        Arrays.stream(nums).forEach(x-> System.out.println(x));
    }

//    @SafeVarargs // 其实并不安全！
    static void unsafeMethod(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42, 56);
        array[0] = tmpList; // tmpList是一个List对象（类型已经擦除），赋值给Object类型的对象是允许的（向上塑型），能够编译通过
        String s = stringLists[0].get(0);
    }


    public static void main(String[] args) {

//        printSome(1,2,3,4,5,6);

        List<String> list1 = Arrays.asList("one", "two");
        List<String> list2 = Arrays.asList("three","four");
        unsafeMethod(list1, list2);

    }

}
