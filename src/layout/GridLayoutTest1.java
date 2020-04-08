package layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayoutTest1 extends JFrame {
	
	public GridLayoutTest1() {
		setTitle("GridLayout");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// 레이아웃 설정
		JPanel panel = new JPanel();
//		panel.setLayout(new GridLayout(0, 3));
		// rows, cols, hgap, vgap
		panel.setLayout(new GridLayout(0, 3, 5, 5));
		
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");
		JButton btn6 = new JButton("버튼6");
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		
		add(panel);
	}

	public static void main(String[] args) {
		GridLayoutTest1 grid = new GridLayoutTest1();
	}
}
