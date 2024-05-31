package com.project.currency_exchange_service.config;/*
 * @created 31/05/2024 - 23:59
 * @project currency-conversion-service
 * @author prashantrajput01

 */

import jakarta.servlet.FilterConfig;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class GatewayFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String gatewayHeader = httpRequest.getHeader("X-Forwarded-For");

        if (gatewayHeader == null || gatewayHeader.isEmpty()) {
            throw new ServletException("Direct access to microservice is not allowed.");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}

