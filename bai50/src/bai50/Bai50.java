package bai50;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai50 extends JFrame{
	private JButton multiEventButton;
	private JLabel clickCountLabel;
	private JLabel mousePositionLabel;
	private int clickCount = 0;
	
	public Bai50() {
		setTitle ("Multi-Event Example");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		multiEventButton = new JButton("Multi-Event");
		clickCountLabel = new JLabel("So lan nhan: 0");
		mousePositionLabel = new JLabel("Toa do: (0, 0)");
		
		multiEventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickCount ++;
				clickCountLabel.setText("So lan nhan:" + clickCount);
			}
		});
		
		multiEventButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mousePositionLabel.setText("Toa do: (" + e.getX()+ "," + e.getY() + ")");
			}
		});
		add(multiEventButton);
		add(clickCountLabel);
		add(mousePositionLabel);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() ->{
			Bai50 frame = new Bai50();
			frame.setVisible(true);
		});
	}
}