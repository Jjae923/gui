package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SimpleCalc3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtOp1, txtOp2, txtResult;
	private JButton btn1, btn2, btn3, btn4, btnCancel;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc3 frame = new SimpleCalc3();
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
	public SimpleCalc3() {
		setTitle("사칙연산 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtOp1 = new JTextField();
		panel.add(txtOp1);
		txtOp1.setColumns(10);
		
		lblNewLabel = new JLabel("?");
		panel.add(lblNewLabel);
		
		txtOp2 = new JTextField();
		panel.add(txtOp2);
		txtOp2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("=");
		panel.add(lblNewLabel_1);
		
		txtResult = new JTextField();
		panel.add(txtResult);
		txtResult.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btn1 = new JButton("+");
		btn1.addActionListener(this);
		panel_1.add(btn1);

		btn2 = new JButton("-");
		btn2.addActionListener(this);
		panel_1.add(btn2);
		
		btn3 = new JButton("*");
		btn3.addActionListener(this);
		panel_1.add(btn3);
		
		btn4 = new JButton("/");
		btn4.addActionListener(this);
		panel_1.add(btn4);
		
		btnCancel = new JButton("reset");
		btnCancel.addActionListener(this);
		panel_1.add(btnCancel);
		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		int op1 = Integer.parseInt(txtOp1.getText());
		int op2 = Integer.parseInt(txtOp2.getText());
		int result = 0;
		
		if(btn==btn1) {
			lblNewLabel.setText("+");
			result = op1+op2;
		}else if(btn==btn2) {
			lblNewLabel.setText("-");
			result = op1-op2;
		}else if(e.getSource()==btn3) {
			lblNewLabel.setText("*");
			result = op1*op2;
		}else if(e.getSource()==btn4) {
			lblNewLabel.setText("/");
			result = op1/op2;
		}else {
			txtOp1.setText("");
			txtOp2.setText("");
			txtResult.setText("");
			lblNewLabel.setText("?");
		}
		txtResult.setText(result+"");
	}
}
