package com.helloxin.reflection.json;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by nandiexin on 2019/4/18.
 */
public class GsonReflection {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor<?> c = Person.class.getDeclaredConstructor();
        Person person = (Person) c.newInstance();
        //获取Person中的变量
        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            //获取变量名
            String name = field.getName();
            if ("name".equals(name)) {
                field.set(person, "凌云");
            } else if ("sex".equals(name)) {
                field.set(person, "屌丝男");
            } else if ("job".equals(name)) {
                field.set(person, "IT monkey");
            }
        }
        System.out.println(person.toString());
        Gson gson = new Gson();
        System.out.println(gson.toJson(person).toString());

        //模拟
//        Gson gson = new Gson();
        String jsonMan = "{\"name\":\"猪八戒\",\"sex\":\"妇男\",\"job\":\"IT dog\"}";
        Person man = gson.fromJson(jsonMan, Person.class);
        System.out.println(man.toString());


    }
}
