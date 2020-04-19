package com.helloxin.temp;

/**
 * Created by yexin on 2019/11/20.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FooTest {

    private List<User> foo(List<Integer> ignore) {
        List<User> list = new ArrayList<>();
        list.add(new User("no one"));
        return list;
    }

    public void could_compile() {
        List in = new ArrayList();
        List<User> out = (List<User>) foo(in).stream().collect(Collectors.toList());
        System.out.println(out);
    }

}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
