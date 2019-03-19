package com.helloxin.lang.cloneable;

import java.io.Serializable;

/**
 * Created by nandiexin on 2019/3/19.
 */
public class Address implements Cloneable,Serializable{

    String steet;

    String room;

    @Override
    public Address clone() throws CloneNotSupportedException {
        Address address = (Address) super.clone();

        return address;
    }


    public String getSteet() {
        return steet;
    }

    public void setSteet(String steet) {
        this.steet = steet;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Address{" +
                "steet='" + steet + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
