package com.helloxin.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.List;

public class JSONPathTest {
    public static void main(String[] args) {

//        String jsonStr = "{\n" +
//                "  \"store\": {\n" +
//                "    \"bicycle\": {\n" +
//                "      \"color\": \"red\",\n" +
//                "      \"price\": 19.95\n" +
//                "    },\n" +
//                "    \"book\": [\n" +
//                "      {\n" +
//                "        \"author\": \"Nigel Rees\",\n" +
//                "        \"price\": 8.95,\n" +
//                "        \"category\": \"reference\",\n" +
//                "        \"title\": \"Sayings of the Century\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"author\": \"Evelyn Waugh\",\n" +
//                "        \"price\": 12.99,\n" +
//                "        \"isbn\": \"0-553-21311-3\",\n" +
//                "        \"category\": \"fiction\",\n" +
//                "        \"title\": \"Sword of Honour\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  }\n" +
//                "}";
        String jsonStr = "{\n" +
                "  \"store\": {\n" +
                "    \"bicycle\": {\n" +
                "      \"color\": \"red\",\n" +
                "      \"price\": 19.95\n" +
                "    }\n" +
                "  }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        List<Object> allDisplayLesions = (List) JSONPath.eval(jsonObject, "$..book");

        System.out.println(allDisplayLesions);


        System.out.println("\n Book数目：" + JSONPath.eval(jsonObject, "$.store.book.size()"));
        System.out.println("第一本书title：" + JSONPath.eval(jsonObject, "$.store.book[0].title"));
    }
}
