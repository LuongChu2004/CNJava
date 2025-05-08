package kiemtra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Kiemtra extends JFrame {
    private JTextField txtHoTen, txtQueQuan, txtNgaySinh;
    private JButton btnThem;
    private JTextArea textArea;

    public Kiemtra() {
        setTitle("Thông tin sinh viên");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelNhap = new JPanel(new GridLayout(4, 2, 5, 5));

        panelNhap.add(new JLabel("Họ và tên:"));
        txtHoTen = new JTextField();
        panelNhap.add(txtHoTen);

        panelNhap.add(new JLabel("Quê quán:"));
        txtQueQuan = new JTextField();
        panelNhap.add(txtQueQuan);

        panelNhap.add(new JLabel("Ngày sinh (dd/mm/yyyy):"));
        txtNgaySinh = new JTextField();
        panelNhap.add(txtNgaySinh);

        btnThem = new JButton("Thêm");
        panelNhap.add(btnThem);
        panelNhap.add(new JLabel()); // chỗ trống

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(panelNhap, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Dòng tiêu đề bảng
        textArea.append(String.format("%-20s | %-15s | %-12s\n", "Họ tên", "Quê quán", "Ngày sinh"));
        textArea.append("--------------------------------------------------------------\n");

        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String hoTen = txtHoTen.getText().trim();
                String queQuan = txtQueQuan.getText().trim();
                String ngaySinh = txtNgaySinh.getText().trim();

                if (hoTen.isEmpty() || queQuan.isEmpty() || ngaySinh.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không được để trống bất kỳ trường nào!");
                    return;
                }

                if (!hoTen.matches("[a-zA-ZÀ-Ỵà-ỵ\\s]+")) {
                    JOptionPane.showMessageDialog(null, "Họ tên chỉ được chứa chữ cái và khoảng trắng.");
                    return;
                }

                if (!queQuan.matches("[a-zA-ZÀ-Ỵà-ỵ\\s]+")) {
                    JOptionPane.showMessageDialog(null, "Quê quán chỉ được chứa chữ cái và khoảng trắng.");
                    return;
                }

                if (!ngaySinh.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    JOptionPane.showMessageDialog(null, "Ngày sinh phải đúng định dạng dd/mm/yyyy.");
                    return;
                }

                if (!isValidDate(ngaySinh)) {
                    JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ.");
                    return;
                }

                String dongMoi = String.format("%-20s | %-15s | %-12s\n", hoTen, queQuan, ngaySinh);
                textArea.append(dongMoi);

                txtHoTen.setText("");
                txtQueQuan.setText("");
                txtNgaySinh.setText("");
            }
        });
    }

    private boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Kiemtra().setVisible(true);
        });
    }
}
