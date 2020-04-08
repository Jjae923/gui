package radio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JRadioTest2 extends JFrame implements /*ActionListener*/ItemListener {

	private JPanel contentPane;
	private JTextField textField;
	private JRadioButton rdodog,rdocat,rdoham,rdorab,rdohog;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioTest2 frame = new JRadioTest2();
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
	public JRadioTest2() {
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
		
		rdodog = new JRadioButton("강아지");
//		rdodog.addActionListener(this);
		rdodog.addItemListener(this);
		panel.add(rdodog);
		
		rdocat = new JRadioButton("고양이");
//		rdocat.addActionListener(this);
		rdodog.addItemListener(this);
		panel.add(rdocat);
		
		rdoham = new JRadioButton("햄스터");
//		rdoham.addActionListener(this);
		rdodog.addItemListener(this);
		panel.add(rdoham);
		
		rdorab = new JRadioButton("토끼");
//		rdorab.addActionListener(this);
		rdodog.addItemListener(this);
		panel.add(rdorab);
		
		rdohog = new JRadioButton("고슴도치");
//		rdohog.addActionListener(this);
		rdodog.addItemListener(this);
		panel.add(rdohog);
		
		// 버튼그룹 생성 → JRadioButton은 필수
		ButtonGroup group = new ButtonGroup();
		group.add(rdodog);
		group.add(rdocat);
		group.add(rdoham);
		group.add(rdorab);
		group.add(rdohog);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		JRadioButton radio = (JRadioButton) e.getSource();
//		
//		if(radio.isSelected()) {
//			System.out.println("선택됨");
//		}else {
//			System.out.println("선택 안됨");
//		}
//		
//		textField.setText(e.getActionCommand());
//	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		JRadioButton radio = (JRadioButton) e.getItem();
		
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(radio == rdocat) {
				System.out.println("rdocat 선택");
			}else if(radio == rdodog) {
				System.out.println("rdodog 선택");
			}
		}else {
			if(radio == rdocat) {
				System.out.println("rdocat 해제");
			}else if(radio == rdodog) {
				System.out.println("rdodog 해제");
			}
		}
	}
}
