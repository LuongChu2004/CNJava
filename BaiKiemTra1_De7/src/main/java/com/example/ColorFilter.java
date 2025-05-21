package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ColorFilter implements Filter {
    private final List<String> validColors = Arrays.asList("red", "blue", "green", "white");

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String color = request.getParameter("color");

        if (color == null || validColors.contains(color)) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute("error", "Màu không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("color.jsp");
            dispatcher.forward(request, response);
        }
    }
}
