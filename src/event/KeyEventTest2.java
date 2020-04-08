package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class KeyEventTest2 extends JFrame implements KeyListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea area;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyEventTest2 frame = new KeyEventTest2();
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
	public KeyEventTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("문자 입력");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(this);
		panel.add(textField);
		textField.setColumns(10);
		
		area = new JTextArea();
		contentPane.add(area, BorderLayout.CENTER);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 키를 이용하여 입력을 하는 경우
		display(e, "keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 사용자가 키를 누르면 입력
		display(e, "keyPressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 키에서 손을 뗄 때 발생
		display(e, "KeyReleased");
	}
	
	private void display(KeyEvent e, String str) { // 오버라이딩 시 같은 작업을 해야할 때 메소드를 만들어서 넘김
		char c = e.getKeyChar();
		int keyCode = e.getKeyCode();
		String modifiers = "Alt : "+e.isAltDown()+" Ctrl : "+e.isControlDown()+" Shift : "+e.isShiftDown();
		area.append(" "+str+" 문자 "+c+" (코드 : "+keyCode+") "+modifiers+"\n");
	}
}
