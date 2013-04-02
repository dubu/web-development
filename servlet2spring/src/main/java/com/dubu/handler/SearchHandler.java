package com.dubu.handler;

import com.dubu.model.Person;
import com.dubu.service.PersonServiceInMemory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 4:03
 */
public class SearchHandler implements Handler {

    @Override
    public String handle(HttpServletRequest req, HttpServletResponse reps) {

        int id = Integer.valueOf(req.getParameter("id"));

        PersonServiceInMemory service = new PersonServiceInMemory();
        Person person = service.search(id);

        req.setAttribute("name", person.getName());
        req.setAttribute("age", person.getAge());

        return "person";
    }
}
