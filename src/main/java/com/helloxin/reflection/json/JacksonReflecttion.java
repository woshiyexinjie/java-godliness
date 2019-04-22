package com.helloxin.reflection.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by nandiexin on 2019/4/21.
 */
public class JacksonReflecttion {


    public static void main(String[] args) throws IOException {

        String jsonMan = "{\"name\":\"猪八戒\",\"sex\":\"妇男\",\"job\":\"IT dog\"}";
        ObjectMapper jsontoperosn = new ObjectMapper();
        Person person = jsontoperosn.readValue(jsonMan, Person.class);
        System.out.println(person);


    }


}
