package com.helloxin.util.concurrent.volatiletest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2019/2/21.
 */
public class MyList {

    //这是使用 volatile 的方式
    // private volatile List list = new ArrayList();

    private List list = new ArrayList();

    //这是使用同步锁的方式
    boolean flag = false;

    public void add() {
        list.add("qf");
    }

    public int size() {
        //System.out.println("MyList.size:"+list.size());
        return list.size();
    }


}

