package com.dubu.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Administrator
 * Date: 13. 3. 28
 * Time: 오후 12:44
 */
public interface Handler {

    public String handle(HttpServletRequest req, HttpServletResponse reps) ;
}
