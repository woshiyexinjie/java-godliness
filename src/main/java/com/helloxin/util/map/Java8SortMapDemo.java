package com.helloxin.util.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nandiexin on 2018/2/28.
 */
public class Java8SortMapDemo {

    public static void main(String[] args) {

        // Creating a Map object of type <String, String> and adding key-value pairs
        Map<String, String> ceo = new HashMap<String, String>();
        ceo.put("Google", "Sundar Pichai");
        ceo.put("Facebook", "Mark Zuckerberg");
        ceo.put("Twitter", "Jack Dorsey");
        ceo.put("Apple", "Tim Cook");
        ceo.put("Microsoft", "Satya Nadella");
        ceo.put("Amazon", "Jeff Bezos");
        ceo.put("Oracle", "Mark Hurd");
        ceo.put("SpaceX", "Elon Musk");

        // Iterating Original Map
        System.out.println("Original Map: \n" + ceo);

        System.out.println();

        // Method #1 - Sort Map by Key
        sortMapByKey(ceo);

        System.out.println();

        // Method #2 - Sort Map by Value
        sortMapByValue(ceo);

        System.out.println();

        // Method #3 - Sort Map by Key in Reverse Order
        sortMapByKeyInReverseOrder(ceo);

        System.out.println();

        // Method #4 - Sort Map by Value in Reverse Order
        sortMapByValueInReverseOrder(ceo);
    }

    // Method #1
    private static void sortMapByKey(Map<String, String> ceo) {
        // Creating LinkedhashMap for storing entries after SORTING by Keys using Stream in Java8
        Map<String, String> keyMap = new LinkedHashMap<String, String>();

        // Sorting by Keys using the 'comparingByKey()' method
        ceo.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(c -> keyMap.put(c.getKey(), c.getValue()));

        System.out.println("Map Sorted by Key: \n" + keyMap);
    }

    // Method #2
    private static void sortMapByValue(Map<String, String> ceo) {
        // Creating LinkedhashMap for storing entries after SORTING by Values using Stream in Java8
        Map<String, String> valueMap = new LinkedHashMap<String, String>();

        // Sorting by Value using the 'comparingByValue()' method
        ceo.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(c -> valueMap.put(c.getKey(), c.getValue()));

        System.out.println("Map Sorted by Value: \n" + valueMap);
    }

    // Method #3
    private static void sortMapByKeyInReverseOrder(Map<String, String> ceo) {
        // Creating LinkedhashMap for storing entries after SORTING by Keys using Stream in Java8
        Map<String, String> keyRMap = new LinkedHashMap<String, String>();

        // Sorting by Keys using the 'comparingByKey()' method
        ceo.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).forEachOrdered(c -> keyRMap.put(c.getKey(), c.getValue()));

        System.out.println("Map Sorted by Key in Reverse order: \n" + keyRMap);
    }

    // Method #4
    private static void sortMapByValueInReverseOrder(Map<String, String> ceo) {
        // Creating LinkedhashMap for storing entries after SORTING by Values using Stream in Java8
        Map<String, String> valueMap = new LinkedHashMap<String, String>();

        // Sorting by Value using the 'comparingByValue()' method
        ceo.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEachOrdered(c -> valueMap.put(c.getKey(), c.getValue()));

        System.out.println("Map Sorted by Value in Reverse order: \n" + valueMap);
    }
}
