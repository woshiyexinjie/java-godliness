package com.helloxin.io;

import java.io.Serializable;

/**
 * Created by nandiexin on 2018/1/25.
 */
public class Person implements Serializable{

    private String name ;

    private int age ;
    //序列化 隐身模式
    private transient String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Person(String name, int age)
    {
        this.name = name ; this.age = age ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
