package org.yyf.gradleDemo.web.aop;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by tobi on 16-7-20.
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("testFilter before");
        BufferedReader reader = request.getReader();
//        ((HttpServletRequest) request).
//                System.out.println("testFilter after");
//        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
