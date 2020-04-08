package container;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest5 extends JFrame {
		
		public JFrameTest5() {
			setTitle("다섯번째 프로그램");
			setBounds(200, 300, 100, 100);	// 화면 x=200, y=300 위치에 100x100사이즈로 창 띄워줘
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			// 컴포넌트 생성하기
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());  // FlowLayout() : 차례대로 붙기
			
			JButton btn1 = new JButton("open");
			JButton btn2 = new JButton("save");
			JCheckBox check = new JCheckBox("GUI 프로그래밍");
			JColorChooser chooser = new JColorChooser();
			
			// 컴포넌트 부착 - JPrame
			panel.add(btn1);
			panel.add(btn2);
			panel.add(check);
			panel.add(chooser);
			
			// JPanel을 JFrame에 부착
			add(panel);
		}
		
		public static void main(String[] args) {
		// 컨테이너 생성하기
		JFrameTest5 f = new JFrameTest5();
	}
}
