package com.dubu.handler;

import com.dubu.model.Person;
import com.dubu.service.PersonServiceInMemory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 4:03
 */
public class SearchHandler implements Handler {


    /*
    @Override
    public String handle(HttpServletRequest req, HttpServletResponse reps) {

        int id = Integer.valueOf(req.getParameter("id"));

        PersonServiceInMemory service = new PersonServiceInMemory();
        Person person = service.search(id);

        req.setAttribute("name", person.getName());
        req.setAttribute("age", person.getAge());

        return "person";
    }
    */

    @Override
    public String handle(Map<String, String[]> params, Map<String, Object> models) {
        PersonServiceInMemory service = new PersonServiceInMemory();

        int id =  Integer.valueOf(params.get("id")[0]);
        Person person = service.search(id);

        models.put("name", person.getName());
        models.put("age", person.getAge());

        return "person";
    }
}
