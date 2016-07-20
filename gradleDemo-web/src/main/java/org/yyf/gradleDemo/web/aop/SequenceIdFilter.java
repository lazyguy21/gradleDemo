package org.yyf.gradleDemo.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.MDC;
import org.yyf.gradleDemo.common.util.LocalIpAddressUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

@Slf4j
public class SequenceIdFilter implements Filter {
    public static final String SEQUENCE_ID_KEY = "SEQID";
    private static final String SEQUENCE_HEADER_NAME = "DOCMANAGEMENT-SEQUENCE";

    private static String hostName;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            hostName = InetAddress.getLocalHost().getHostName();

            // only get the first part of the hostname
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[0];
            }
        } catch (UnknownHostException e) {
            log.warn("Failed to get the host name", e);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String sequenceId = String.format("%s-%d", hostName, System.currentTimeMillis());
        ThreadContext.put("requestId", UUID.randomUUID().toString());
        ThreadContext.put("ip", LocalIpAddressUtil.getIp());

        MDC.clear();
        MDC.put(SEQUENCE_ID_KEY, sequenceId);

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.addHeader(SEQUENCE_HEADER_NAME, sequenceId);

        chain.doFilter(request, response);

        ThreadContext.clearMap();
    }

    @Override
    public void destroy() {

    }
}