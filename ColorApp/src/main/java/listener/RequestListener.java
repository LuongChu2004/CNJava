package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {
    private static int requestCount = 0;

    public void requestInitialized(ServletRequestEvent sre) {
        requestCount++;
        System.out.println("Yêu cầu mới. Tổng số yêu cầu: " + requestCount);
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        // Không xử lý
    }
}
