package com.helloxin.lang.cloneable;

import java.io.Serializable;

/**
 * Created by nandiexin on 2019/3/19.
 */
public class People implements Cloneable,Serializable {

    Address address;

    String name;

    int age;

    @Override
    public People clone() throws CloneNotSupportedException {
        People p = (People) super.clone();
        p.setAddress(p.getAddress().clone());
        return p;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public People() {
    }

    public People(Address address, String name, int age) {
        this.address = address;
        this.name = name;
        this.age = age;
    }

    public People(People p) {
        this.address = p.getAddress();
        this.name = p.getName();
        this.age = p.getAge();
    }

    @Override
    public String toString() {
        return "People{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
