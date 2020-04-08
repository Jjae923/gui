package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Button;
import java.awt.Font;

public class Celsius extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Celsius frame = new Celsius();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Celsius() {
		setTitle("온도변환기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		TextField textField = new TextField();
		contentPane.add(textField);
		
		Label label = new Label("Celsius");
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		contentPane.add(label);
		
		Button button = new Button("convert");
		button.setFont(new Font("Dialog", Font.PLAIN, 20));
		contentPane.add(button);
		
		Label label_1 = new Label("Fahrenheit");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		contentPane.add(label_1);
		
		pack();
	}
}
