package com.helloxin.lang;

import java.sql.SQLOutput;
import java.util.Collections;

/**
 * Created by nandiexin on 2018/12/18.
 */
public class RepeatCharString {

     //需求是 我想创建一个字符串 里面的构造是 xxxxxyyyyyyytttt 然后字符的数量是不一定的
    //主要是不想那么写for循环
    public static void main(String[] args) {

        String s= "A";
        int n = 6;

        //可是只有单个呀
        System.out.println(String.format("%0" + n + "d", 0).replace("0",s));

        System.out.println(new String(new char[n]).replace("\0", s));

        System.out.println(String.join("", Collections.nCopies(n, s)));


        //char的数组 默认值居然是这个
        System.out.println(new char[n]);

    }


}
