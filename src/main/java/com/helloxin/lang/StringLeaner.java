package com.helloxin.lang;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nandiexin on 2018/1/29.
 */
public class StringLeaner {


    public  void sensitiveword(String param){
        String test =  param.replaceAll("(?<=[\\d]{3})\\d(?=[\\d]{5})", "*");
        System.out.println(test);
    }

    public static void main(String[] args) {


        Map<String,Object> map = new HashMap<>();
        System.out.println((String)map.get("haha"));

        String a1 = "12";
        String a2 = null;
        System.out.println(a2.equals(a1));
    }
}
