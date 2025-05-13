package controller;

import java.util.Arrays;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ColorFilter implements Filter {
    private static final List<String> VALID_COLORS = Arrays.asList("red", "blue", "white", "yellow", "green");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String color = request.getParameter("color");
        if (color != null && !VALID_COLORS.contains(color.toLowerCase())) {
            request.setAttribute("error", "Màu không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("color.jsp");
            dispatcher.forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
   }
