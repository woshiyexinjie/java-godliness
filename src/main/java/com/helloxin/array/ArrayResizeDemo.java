package com.helloxin.array;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ArrayResizeDemo {
    public static void main(String[] args) {
        Map<String, String> map2 = new HashMap<>();

        map2.put("postgresql", "jdbc:postgresql://127.0.0.1/customers_db");
        map2.put("mysql", "jdbc:mysql://192.168.0.50/customers_db");

        System.out.println("The initial map: " + map2);

        Function<String, String> jdbcUrl2
                = k -> k + "://" + "12.45.67.188" + "/customers_db";

        String mongodbJdbcUrl = map2.computeIfAbsent("mongodb", jdbcUrl2);
    }
}
