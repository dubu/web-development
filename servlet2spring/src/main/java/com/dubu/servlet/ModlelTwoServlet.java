package com.dubu.servlet;

import com.dubu.model.Person;
import com.dubu.service.PersonServiceInMemory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 4:33
 */
public class ModlelTwoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.valueOf(req.getParameter("id"));



        // biz logic
        PersonServiceInMemory service = new PersonServiceInMemory();
        Person person = service.search(id);



        req.setAttribute("name", person.getName());
        req.setAttribute("age", person.getAge());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/person.jsp");
        requestDispatcher.forward(req,resp);

    }
}
