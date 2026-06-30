package com.mycompany.acthacelonene.controllers;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FrontController", urlPatterns = {"/*"})
public class FrontController implements Filter {

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {}
    
    @Override
    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) 
            throws ServletException, IOException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        
        String path = uri.substring(contextPath.length());
        
        if( path == null || path.equals("/") || path.isEmpty() ) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
        }
        
        boolean isPublicPath = path.startsWith("/auth") || path.startsWith("/assets");
        
        HttpSession session = request.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("userLogged") != null);
        
        if( !isPublicPath && !isLoggedIn ) {
            response.sendRedirect( request.getContextPath()+ "/auth/login");
            return;
        }
        
        chain.doFilter(req, res);
    }
    
    @Override
    public void destroy() {}
}