package bai32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Bai32 extends JFrame {
	private JTextArea textArea;
	private JButton clearButton;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Bai32() {
		setTitle ("TextArea with Clear Button");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				textArea.setText("");
			}
		});
		
		add(scrollPane, BorderLayout.CENTER);
		add(clearButton, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Bai32 frame = new Bai32();
			frame.setVisible(true);
		});
	}
}
