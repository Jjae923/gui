package layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrameTest2 extends JFrame {
	
	public JFrameTest2() {
		setSize(500, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyFrame");
		
		JPanel totalPane = new JPanel();
		totalPane.setLayout(new BorderLayout());
		
		// 상단에 보여줄 레이아웃 설정
		JPanel topPane = new JPanel();
		JLabel label = new JLabel("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오.");
		topPane.add(label);
		totalPane.add(topPane,BorderLayout.NORTH); 
		
		// 가운데 보여줄 레이아웃 설정
		JPanel centerPane = new JPanel();
		JButton btn1 = new JButton("콤보피자");
		JButton btn2 = new JButton("포테이토피자");
		JButton btn3 = new JButton("불고기피자");
		JLabel label2 = new JLabel("개수");
		JTextField field = new JTextField(10);
		centerPane.add(btn1);
		centerPane.add(btn2);
		centerPane.add(btn3);
		centerPane.add(label2); 
		centerPane.add(field);
		totalPane.add(centerPane,BorderLayout.CENTER);
		
		add(totalPane);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrameTest2 test = new JFrameTest2();
	}
}
