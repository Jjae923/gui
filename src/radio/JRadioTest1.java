package radio;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class JRadioTest1 extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioTest1 frame = new JRadioTest1();
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
	public JRadioTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("선호하는 애완동물은?");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 17));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton rdodog = new JRadioButton("강아지");
		panel.add(rdodog);
		
		JRadioButton rdocat = new JRadioButton("고양이");
		panel.add(rdocat);
		
		JRadioButton rdoham = new JRadioButton("햄스터");
		panel.add(rdoham);
		
		JRadioButton rdorab = new JRadioButton("토끼");
		panel.add(rdorab);
		
		JRadioButton rdohog = new JRadioButton("고슴도치");
		panel.add(rdohog);
		
		// 버튼그룹 생성 → JRadioButton은 필수
		ButtonGroup group = new ButtonGroup();
		group.add(rdodog);
		group.add(rdocat);
		group.add(rdoham);
		group.add(rdorab);
		group.add(rdohog);
	}
}
