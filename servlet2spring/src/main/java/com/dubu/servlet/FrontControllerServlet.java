package com.dubu.servlet;

import com.dubu.handler.Handler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 3:58
 */
public class FrontControllerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) {

        try {
            Handler handler = handlerMapping(req);
            String viewName = handlerAdapter(handler, req, resp);
            dispatch(viewName, req, resp);
        } catch (Exception e) {
            //exceptionResolve(e);
            throw new RuntimeException(e);
        }

    }
    private Handler handlerMapping(HttpServletRequest req) throws Exception {
        String uri = req.getRequestURI();
        String handlerName = "com.dubu.handler." + uri.substring(uri.lastIndexOf("/") + 1) + "Handler";
        Class handlerClass = Class.forName(handlerName);
        return (Handler) handlerClass.newInstance();
    }

    private String handlerAdapter(Handler handler , HttpServletRequest req, HttpServletResponse resp) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method handlerMethod = handler.getClass().getMethod("handle", HttpServletRequest.class , HttpServletResponse.class);
        return (String)handlerMethod.invoke(handler ,req ,resp );
    }

    private void dispatch(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resultViewName = "/WEB-INF/views/" + viewName + ".jsp";
        RequestDispatcher requestDispatcher =  req.getRequestDispatcher(resultViewName);
        requestDispatcher.forward(req, resp);
    }

}
