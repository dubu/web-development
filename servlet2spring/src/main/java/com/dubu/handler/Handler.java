package com.dubu.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 3:52
 */
public interface Handler {

    //public String handle(HttpServletRequest req, HttpServletResponse reps);

    public String handle(Map<String,String[]> params, Map<String, Object> models);
}
