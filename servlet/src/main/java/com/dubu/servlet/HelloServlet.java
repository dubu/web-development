package com.dubu.servlet;

import com.dubu.model.MessageStore;
import com.dubu.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Override;

/**
 * User: Administrator
 * Date: 13. 3. 28
 * Time: 오전 3:55
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person model = new Person("dubu", "30");

        resp.setContentType("text/html;charset=euc-kr");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("   <BODY>");
        out.println("   Welcome *^^*");
        out.println("<h1 id=\"name\">"+model.getName() +"</h1>");
        out.println("   </BODY>");
        out.println("</HTML>");
        out.close();

        // 전후 처리
        // J2EE decorate patten ,, filter 로 구현데..
        // 요청 처리까리 얼마나 시간이 걸렸을까.


    }
}
