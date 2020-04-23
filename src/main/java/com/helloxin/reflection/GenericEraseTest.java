package com.helloxin.reflection;

import com.google.common.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by yebanxian on 2020/4/22.
 */
public class GenericEraseTest {
    public static void main(String[] args) {
//        ArrayList<String> stringList = Lists.newArrayList();
//        ArrayList<Integer> intList = Lists.newArrayList();
//        System.out.println(stringList.getClass().isAssignableFrom(intList.getClass()));

        TypeToken<ArrayList<String>> typeToken = new TypeToken<ArrayList<String>>() {
        };
        TypeToken<?> genericTypeToken = typeToken.resolveType(ArrayList.class.getTypeParameters()[0]);
        System.out.println(genericTypeToken.getType());

    }
}
