package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

// 이벤트 처리를 위한 클래스를 외부 클래스로 작성하기
class MyListener1 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		System.out.println(e.getSource()); // 이벤트가 일어난 대상의 정보를 가져옴
		// 버튼 위에 있는 글자를 변경
		JButton btn = (JButton)e.getSource();
		btn.setText("버튼이 눌러졌습니다.");
	}
} // 버튼이 눌리는지 안눌리는지 감지하는 감시자 역할

public class MyFrame extends JFrame {	 // 메인 메소드를 가진 클래스에 public 붙이기
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("버튼을 누르세요");
		panel.add(btnNewButton);
		// 버튼과 리스너를 연동하는 부분
		btnNewButton.addActionListener(new MyListener1());
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
	}
}
