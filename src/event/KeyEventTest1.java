package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventTest1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyEventTest1 frame = new KeyEventTest1();
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
	public KeyEventTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("문자를 입력하시오");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		JTextArea textArea = new JTextArea();
		textField.addKeyListener(new KeyAdapter() {  // KeyAdapter는 클래스
			@Override
			public void keyPressed(KeyEvent e) {
				// 키보드에서 키를 누를 때 발생하는 이벤트
//				System.out.println(e.getKeyCode());
				int keyCode = e.getKeyCode();
				
				System.out.println(KeyEvent.getKeyText(keyCode));
				
				if(keyCode>=65 && keyCode<91 || keyCode>=97 && keyCode<123) {
					textArea.setText("영어입니다.");
				}else {
					textArea.setText("영어가 아닙니다.");
				}
			}
		});
		panel.add(textField);
		textField.setColumns(10);
		
		contentPane.add(textArea, BorderLayout.CENTER);
	}
}
