package com.dubu.servlet;

import com.dubu.model.MessageStore;

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

        MessageStore model = new MessageStore();
        model.setMessage("HI Servlet User");

        resp.setContentType("text/html;charset=euc-kr");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("   <BODY>");
        out.println("   Welcome *^^*");
        out.println(model.getMessage());
        out.println("   </BODY>");
        out.println("</HTML>");
        out.close();


        // view 의 분리
        String name = req.getParameter("name");
        req.setAttribute("hello", "hello" + model.getMessage());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/hello.jsp");
        requestDispatcher.forward(req,resp);

        // 전후 처리
        // J2EE decorate patten ,, filter 로 구현데..
        // 요청 처리까리 얼마나 시간이 걸렸을까.


    }
}
