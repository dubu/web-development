package com.dubu.handler;

import com.dubu.model.Person;
import com.dubu.service.PersonServiceInMemory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 1:18
 */

@Controller
public class PersonController {

    @RequestMapping("/search")
    public String findPersonController(int id, Model model) {

        PersonServiceInMemory service  = new   PersonServiceInMemory();
        Person person =  service.search(id);

        model.addAttribute("name", person.getName());
        model.addAttribute("age", person.getAge());

        return "/WEB-INF/views/person.jsp";

    }
}
