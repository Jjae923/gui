package container;

import javax.swing.JFrame;

public class JFrameTest3 extends JFrame {
		
		public JFrameTest3() {
			setTitle("세번째 프로그램");
			setSize(300, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		
		
		public static void main(String[] args) {
		// 컨테이너 생성하기
		JFrameTest3 f = new JFrameTest3();
	}
}
