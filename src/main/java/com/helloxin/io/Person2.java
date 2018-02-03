package com.helloxin.io;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by nandiexin on 2018/1/25.
 */
public class Person2 implements Externalizable {


    private static final long serialVersionUID = 719357188369943951L;


    //使用该接口时，序列化的细节需要由程序员去完成。

    private String name ;

    private int age ;
    //序列化 隐身模式
    private transient String job;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person2() {
    }



    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);//执行默认的序列化机
        out.writeInt(age);
        out.writeObject(job);
        System.out.println("序列持久化");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        job = (String) in.readObject();
        System.out.println("反序列");
    }
}
