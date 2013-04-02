package com.dubu.model;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 3:39
 */
public class Person {

    String name;
    String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
