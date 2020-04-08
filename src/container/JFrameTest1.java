package container;

import javax.swing.JFrame;

public class JFrameTest1 {
	public static void main(String[] args) {
		// 컨테이너 생성하기
		JFrame f = new JFrame("첫번째 프로그램");
		// 컨테이너의 크기 지정하기
		f.setSize(300, 300);
		// 컨테이너 보여주기
		f.setVisible(true);
	}
}
