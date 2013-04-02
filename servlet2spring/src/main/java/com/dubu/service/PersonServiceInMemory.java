package com.dubu.service;

import com.dubu.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 3:40
 */
public class PersonServiceInMemory {
    private static List<Person> employee;

    static
    {
        employee = new ArrayList<Person>();
        employee.add(0,new Person("kim aaa" ,"30"));
        employee.add(1,new Person("park bbb" ,"27"));
        employee.add(2,new Person("choi ccc" ,"21"));
    }

    public Person search(int id ){
        return (Person)employee.get(id);
    }
}
