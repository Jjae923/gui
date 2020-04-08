package radio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class JRadioTest3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioTest3 frame = new JRadioTest3();
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
	public JRadioTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("어떤 크기의 피자를 주문하시겠습니까?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JRadioButton rdbtnS = new JRadioButton("Small Size");
		rdbtnS.addActionListener(this);
		panel_1.add(rdbtnS);
		
		JRadioButton rdbtnM = new JRadioButton("Medium Size");
		rdbtnM.addActionListener(this);
		panel_1.add(rdbtnM);
		
		JRadioButton rdbtnL = new JRadioButton("Large Size");
		rdbtnL.addActionListener(this);
		panel_1.add(rdbtnL);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnS);
		group.add(rdbtnM);
		group.add(rdbtnL);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField.setForeground(Color.RED);
		panel_2.add(textField);
		textField.setColumns(25);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textField.setText(e.getActionCommand()+"가 선택되었습니다");
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
	}
}
