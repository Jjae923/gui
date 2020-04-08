package exam;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyPad extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtInput;
	private JButton[] buttons=new JButton[9];
	
	public KeyPad() {
		setTitle("키패드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		add(contentPane);
		
		txtInput = new JTextField();
		txtInput.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(txtInput, BorderLayout.NORTH);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(0, 3));
		contentPane.add(btnPanel, BorderLayout.CENTER);
		
		for(int i=0;i<buttons.length;i++) {
			buttons[i] = new JButton((i+1)+"");
			buttons[i].addActionListener(this);
			btnPanel.add(buttons[i]);
		}
	}
	
	public static void main(String[] args) {
		KeyPad keypad = new KeyPad();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼이 눌러지면 해당 버튼의 text값을
		String str = e.getActionCommand();
		// txtInput에 보여주기
		txtInput.setText(txtInput.getText()+str);

		// 다른 방법
		for(int i=0;i<buttons.length;i++) {
			if(e.getSource()==buttons[i]) {
				
			}
		}
	}
}
