package com.dubu;

import javax.servlet.*;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Administrator
 * Date: 13. 3. 28
 * Time: 오후 12:11
 */
public class TimeFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(TimeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse );
        log.info("process time : " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Override
    public void destroy() {

    }
}
