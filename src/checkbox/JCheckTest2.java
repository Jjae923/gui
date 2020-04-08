package checkbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class JCheckTest2 extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JCheckBox chckbxApple, chckbxPeach, chckbxGrape;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckTest2 frame = new JCheckTest2();
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
	public JCheckTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		chckbxApple = new JCheckBox("사과");
		chckbxApple.addItemListener(this);
		panel_1.add(chckbxApple);
		
		chckbxPeach = new JCheckBox("복숭아");
		chckbxPeach.addItemListener(this);
		panel_1.add(chckbxPeach);
		
		chckbxGrape = new JCheckBox("포도");
		chckbxGrape.addItemListener(this);
		panel_1.add(chckbxGrape);
		
		textArea = new JTextArea();
		panel.add(textArea);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 각 체크박스가 체크되면 체크된 과일의 이름을
		// textArea에 보여주기
		// 체크가 해제되면 textArea에 있던 과일의 이름은
		// 삭제해주기
		
		// textArea => setText(), append();
//		switch (e.getItem())
//		case chckbxApple :
//			textArea.append("사과");
//		case chckbxPeach :
//			textArea.append("복숭아");
//		case chckbxGrape :
//			textArea.append("포도");
//			difault :
//				break;
		
		JCheckBox check = (JCheckBox) e.getItem();
		
		if(e.getStateChange()==ItemEvent.SELECTED) {
			// 쌤 코딩
			textArea.append(check.getText());
			// 내 코딩
//			if(check==chckbxApple) {
//				textArea.append("사과");
//			}else if(check==chckbxPeach) {
//				textArea.append("복숭아");
//			}else if(check==chckbxGrape) {
//				textArea.append("포도");
//			}
		}else {
			// 쌤 코딩
//			// textArea에 있는 전체 문자열
//			String contents = textArea.getText();
//			// 체크가 해제된 체크박스 문자열
//			String delTxt = check.getText();
//			
//			// 삭제하기 위한 코드
//			StringBuffer buf = new StringBuffer(contents);
//			int start = buf.indexOf(delTxt);
//			int end = start + delTxt.length();
//			buf.delete(start, end);
//			textArea.setText(buf.toString());
			
			// 정민언니 코딩
			String str = textArea.getText(); // 체크 해제 된 text 가져 옴
			str = str.replace(check.getText(), ""); // 그 텍스트를 "" 즉, 그냥 아무것도 없는 것과 치환
			textArea.setText(str); // 그거 textArea에 넣어 줌.
			
//			if(check==chckbxApple) {
//				textArea.setText(textArea-check.getActionCommand());
//			}else if(check==chckbxPeach) {
//				textArea.setText(check.getActionCommand());
//			}else if(check==chckbxGrape) {
//				textArea.setText("");
//			}
		}
	}
}
