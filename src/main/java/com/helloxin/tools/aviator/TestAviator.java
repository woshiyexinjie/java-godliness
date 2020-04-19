package com.helloxin.tools.aviator;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yexin on 2019/10/7.
 */
public class TestAviator {

    public static void main(String[] args) {
        //表达式计算
        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        System.out.println(result);

        String yourName = "Michael";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("yourName", yourName);
        String result2 = (String) AviatorEvaluator.execute(" 'hello ' + yourName ", env);
        System.out.println(result2);

        String name = "dennis";
        System.out.println(AviatorEvaluator.exec(" 'hello ' + yourName ", name));
        //大数计算
        System.out.println(AviatorEvaluator.exec("99999999999999999999999999999999 + 99999999999999999999999999999999"));

        System.out.println("serialize_image".toString().getBytes());
    }
}
