package bai51;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai51 extends JFrame {
    private JProgressBar progressBar;
    private JButton btnStart;

    public Bai51() {
        setTitle("JProgressBar Demo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Tạo thanh tiến trình
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        // Tạo nút Start
        btnStart = new JButton("Start");

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnStart.setEnabled(false); // Không cho bấm lại khi đang chạy
                new Task().execute();
            }
        });

        add(progressBar, BorderLayout.CENTER);
        add(btnStart, BorderLayout.SOUTH);
    }

    // SwingWorker để chạy tiến trình nền
    private class Task extends SwingWorker<Void, Integer> {
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(100); // 100ms mỗi lần → tổng cộng 10 giây
                publish(i);
            }
            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            int latest = chunks.get(chunks.size() - 1);
            progressBar.setValue(latest);
        }

        @Override
        protected void done() {
            btnStart.setEnabled(true); // Cho phép bấm lại khi xong
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai51().setVisible(true);
        });
    }
}
