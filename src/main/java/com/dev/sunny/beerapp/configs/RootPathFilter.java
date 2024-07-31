package com.dev.sunny.beerapp.configs;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/*")
public class RootPathFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length());
        if (path.equals("/")) {
            req.getRequestDispatcher("/login.html").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
