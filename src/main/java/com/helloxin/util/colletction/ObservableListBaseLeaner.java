package com.helloxin.util.colletction;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2018/8/7.
 */
public class ObservableListBaseLeaner {

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<String>();

        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("有修改操作!");
            }
        });
        observableList.add("item one");
        list.add("item two");
        System.out.println("Size: " + observableList.size());

        System.out.println("hello world");

        Thread.sleep(500000L);

        System.out.println("hello world end");

    }
}
