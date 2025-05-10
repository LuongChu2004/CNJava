package com.example;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet Filter implementation class VisitFilter
 */
@WebFilter("/VisitFilter")
public class VisitFilter extends HttpFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        if (session.getAttribute("visited") == null) {
            session.setAttribute("visited", true);
            synchronized (context) {
                Integer count = (Integer) context.getAttribute("visitCount");
                if (count == null) count = 0;
                context.setAttribute("visitCount", count + 1);
            }
        }

        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void destroy() {}

}