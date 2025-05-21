package com.example;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {
    private static int requestCount = 0;

    public void requestInitialized(ServletRequestEvent sre) {
        requestCount++;
        System.out.println("Request #" + requestCount + " received.");
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        // optional: log khi request kết thúc
    }
}
