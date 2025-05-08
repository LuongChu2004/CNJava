package bai31;

import javax.swing.*;

public class Bai31 extends JFrame {
    public Bai31() {
        setTitle("JSplitPane Example");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo JList bên trái
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
        JList<String> list = new JList<>(items);
        JScrollPane listScrollPane = new JScrollPane(list);

        // Tạo JTextArea bên phải
        JTextArea textArea = new JTextArea();
        JScrollPane textScrollPane = new JScrollPane(textArea);

        // Tạo JSplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane, textScrollPane);
        splitPane.setDividerLocation(200); // Đặt vị trí chia mặc định 200 pixel

        add(splitPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bai31 frame = new Bai31();
            frame.setVisible(true);
        });
    }
}
