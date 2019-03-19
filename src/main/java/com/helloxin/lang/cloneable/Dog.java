package com.helloxin.lang.cloneable;

/**
 * Created by nandiexin on 2019/3/1.
 */
public class Dog implements Cloneable {
    private String id;
    private String name;

    public Dog(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // 省略 getter 、 setter 以及 toString 方法

    @Override
    public Dog clone() throws CloneNotSupportedException {
        Dog dog = (Dog) super.clone();

        return dog;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Dog dog1 = new Dog("1", "Dog1");
        Dog dog2 = dog1.clone();

        dog2.setName("Dog1 changed");

        System.out.println(dog1); // Dog{id='1', name='Dog1'}
        System.out.println(dog2); // Dog{id='1', name='Dog1 changed'}


//        Dog[] aa= new Dog[2] ;
//        aa[0] = new Dog("2", "Dog1");

    }
    //如果一个类里面，又引用其他的类，其他的类又有引用别的类，那么想要深度拷贝必须所有的类及其引用的类都得实现Cloneable接口，
    // 重写clone方法，这样以来非常麻烦，简单的方法是让所有的对象实现序列化接口（Serializable），然后通过序列化反序列化的方法来深度拷贝对象。
}

