package controller;


import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

import java.util.concurrent.atomic.AtomicInteger;

public class RequestListener implements ServletRequestListener {
    private static AtomicInteger requestCount = new AtomicInteger(0);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        int count = requestCount.incrementAndGet();
        System.out.println("Yêu cầu mới - Tổng số: " + count);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // Không cần xử lý gì thêm
    }
}
