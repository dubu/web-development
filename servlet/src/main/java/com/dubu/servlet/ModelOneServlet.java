package com.dubu.servlet;

import com.dubu.model.Person;
import com.dubu.service.PersonServiceInMemory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 5:24
 */
public class ModelOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.valueOf(req.getParameter("id"));
        PersonServiceInMemory service  = new PersonServiceInMemory();
        Person person =  service.search(id);
        person.getName();

        resp.setContentType("text/html;charset=euc-kr");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("   <BODY>");
        out.println("   model one Servlet");
        out.println("<H1> name :  "+ person.getName()+"<H1>");
        out.println("<H1> age :  "+ person.getAge()+"<H1>");
        out.println("   </BODY>");
        out.println("</HTML>");
        out.close();

    }
}