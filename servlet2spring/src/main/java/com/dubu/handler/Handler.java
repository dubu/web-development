package com.dubu.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 3:52
 */
public interface Handler {

    public String handle(HttpServletRequest req, HttpServletResponse reps);
}
