package filter;


import java.io.IOException;

import javax.servlet.*;

public class ColorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Khởi tạo filter nếu cần
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String color = request.getParameter("color");

        // Kiểm tra màu có hợp lệ không
        if (color != null && (color.equals("red") || color.equals("blue") || color.equals("green"))) {
            chain.doFilter(request, response); // Tiếp tục chuỗi filter nếu hợp lệ
        } else {
            request.getRequestDispatcher("color.jsp").forward(request, response); // Quay lại form nếu không hợp lệ
        }
    }

    @Override
    public void destroy() {
        // Dọn dẹp filter nếu cần
    }
}
