package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MouseEventTest1 extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouseEventTest1 frame = new MouseEventTest1();
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
	public MouseEventTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addMouseListener(this);
		contentPane.add(btnNewButton, BorderLayout.NORTH);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.addMouseListener(this);
		contentPane.add(textArea, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
		// 현재 클릭된 위치 좌표 가져오기
		System.out.println(e.getX()+","+e.getY());
		// 클릭된 마우스 버튼 가져오기 (왼쪽:1, 가운데:2, 오른쪽:3)
		System.out.println("어느 버튼이 눌렸는가? "+e.getButton());
		System.out.println(e.getClickCount()); // 더블클릭 
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		System.out.println("mouseReleased");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		textField.setText("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		textField.setText("mouseExited");
	}
}
