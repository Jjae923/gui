package layout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutTest1 extends JFrame {

	public BoxLayoutTest1() {
		setTitle("BoxLayout");
		setBounds(200, 200, 450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
//		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // x축 방향으로 쌓아줘
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Y축 방향으로 쌓아줘
		
		JButton btn1 = new JButton("box1");
		JButton btn2 = new JButton("box2");
		JButton btn3 = new JButton("box3");
		JButton btn4 = new JButton("box4");
		JButton btn5 = new JButton("box5");
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		
		add(panel);
	}
	
	public static void main(String[] args) {
		BoxLayoutTest1 bos = new BoxLayoutTest1();
	}
}
