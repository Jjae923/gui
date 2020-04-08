package exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BorderTest1 extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorderTest1 frame = new BorderTest1();
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
	public BorderTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();

//		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.BLUE));
		
		TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		border.setTitle("contentPane");
		border.setTitleFont(new Font("맑은 고딕",Font.BOLD,20));
		border.setTitleColor(Color.DARK_GRAY);
		border.setTitleJustification(TitledBorder.RIGHT); // 정렬(왼쪽,가운데,오른쪽)
		border.setTitlePosition(TitledBorder.BOTTOM); // 타이틀 위치()
		contentPane.setBorder(border);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}
