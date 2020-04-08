package layout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutTest1 extends JFrame  {
	
	public FlowLayoutTest1() {
		setTitle("FlowLayout");
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// 컴포넌트를 배치하는 용도로 주로 사용함
		// JPanel 기본 레이아웃 => FlowLayout
		JPanel contentPane = new JPanel();
		// 컴포넌트 생성
		JButton btn1 = new JButton("사과1");
		JButton btn2 = new JButton("사과2");
		JButton btn3 = new JButton("사과3");
		JButton btn4 = new JButton("사과4");
		// 컴포넌트 부착
		contentPane.add(btn1);
		contentPane.add(btn2);
		contentPane.add(btn3);
		contentPane.add(btn4);
		// panel 프레임에 부착
		add(contentPane);
	}
	
	public static void main(String[] args) {
		FlowLayoutTest1 flow = new FlowLayoutTest1();
	}
}
