package com.dubu.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 1:18
 */

@Controller
public class SimpleHandler {

    @RequestMapping("/hello")
    public String HelloController(String name, Model model) {

        /*
        Model m = service(name);


         */


        model.addAttribute("name", name);
        model.addAttribute("age", "30");

        return "/index.jsp";

    }
}
