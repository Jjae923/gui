package radio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

public class MyPizzaOrder extends JFrame implements ItemListener,ActionListener {

	private JPanel contentPane;
	private JRadioButton btn1,btn2,btn3,btnT1,btnT2,btnT3,btnT4,btnS1,btnS2,btnS3;
	private JLabel lblNewLabel;
	private JButton btnOK,btnCancel;
	private ButtonGroup group1,group2,group3;
	int result = 0;
	String type,topping,size;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPizzaOrder frame = new MyPizzaOrder();
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
	public MyPizzaOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC885\uB958", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn1 = new JRadioButton("콤보");
		btn1.addItemListener(this);
		panel_2.add(btn1);
		
		btn2 = new JRadioButton("포테이토");
		btn2.addItemListener(this);
		panel_2.add(btn2);
		
		btn3 = new JRadioButton("불고기");
		btn3.addItemListener(this);
		panel_2.add(btn3);
		
		group1 = new ButtonGroup();
		group1.add(btn1);
		group1.add(btn2);
		group1.add(btn3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uCD94\uAC00 \uD1A0\uD551", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnT1 = new JRadioButton("피망");
		btnT1.addItemListener(this);
		panel_3.add(btnT1);
		
		btnT2 = new JRadioButton("치즈");
		btnT2.addItemListener(this);
		panel_3.add(btnT2);
		
		btnT3 = new JRadioButton("페퍼로니");
		btnT3.addItemListener(this);
		panel_3.add(btnT3);
		
		btnT4 = new JRadioButton("베이컨");
		btnT4.addItemListener(this);
		panel_3.add(btnT4);
		
		group2 = new ButtonGroup();
		group2.add(btnT1);
		group2.add(btnT2);
		group2.add(btnT3);		
		group2.add(btnT4);		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\uD06C\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnS1 = new JRadioButton("Small");
		btnS1.addItemListener(this);
		panel_4.add(btnS1);
		
		btnS2 = new JRadioButton("Medium");
		btnS2.addItemListener(this);
		panel_4.add(btnS2);
		
		btnS3 = new JRadioButton("Large");
		btnS3.addItemListener(this);
		panel_4.add(btnS3);
		
		group3 = new ButtonGroup();
		group3.add(btnS1);
		group3.add(btnS2);
		group3.add(btnS3);		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnOK = new JButton("주문");
		btnOK.addActionListener(this);
		panel_1.add(btnOK);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_1.add(btnCancel);
		
		lblNewLabel = new JLabel("금액 : "+result+"원 입니다");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("자바 피자에 오신 것을 환영합니다");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1, BorderLayout.NORTH);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		JRadioButton radio = (JRadioButton) e.getItem();
					
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(radio==btn1) {
				result+=13000;
				type="콤보";
			}else if(radio==btn2) {
				result+=14000;
				type="포테이토";
			}else if(radio==btn3) {
				result+=15000;
				type="불고기";
			}else if(radio==btnT1) {
				result+=1000;
				topping="피망";
			}else if(radio==btnT2) {
				result+=2000;
				topping="치즈";
			}else if(radio==btnT3) {
				result+=2500;
				topping="페퍼로니";
			}else if(radio==btnT4) {
				result+=3000;
				topping="베이컨";
			}else if(radio==btnS1) {
				result+=0;
				size="Small";
			}else if(radio==btnS2) {
				result+=3000;
				size="Medium";
			}else if(radio==btnS3) {
				result+=5000;
				size="Large";
			}
		}else {
			if(radio==btn1) {
				result-=13000;
			}else if(radio==btn2) {
				result-=14000;
			}else if(radio==btn3) {
				result-=15000;
			}else if(radio==btnT1) {
				result-=1000;
			}else if(radio==btnT2) {
				result-=2000;
			}else if(radio==btnT3) {
				result-=2500;
			}else if(radio==btnT4) {
				result-=3000;
			}else if(radio==btnS1) {
				result-=0;
			}else if(radio==btnS2) {
				result-=3000;
			}else if(radio==btnS3) {
				result-=5000;
			}
		}
		lblNewLabel.setText("금액 : "+result+"원 입니다");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(type==null || topping==null || size==null) {
			JOptionPane.showMessageDialog(this, "옵션 선택이 부족합니다.", "돌아가기", JOptionPane.WARNING_MESSAGE, null);
		}else {
			if(btn==btnOK) {
				String[] str = {"네", "아니오"};
				JOptionPane.showOptionDialog(this, "종류 : "+type+"\n"+"토핑 : "+topping+"\n"+"크기 : "+size+"\n"+"가격은 "+result+"원 입니다."+"\n"+"주문하시겠습니까?",
						"주문내역", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, str, str[0]);
			}else if(btn==btnCancel) {
				type=null;
				topping=null;
				size=null;
				group1.clearSelection();
				group2.clearSelection();
				group3.clearSelection();
			}
		}
	}
}
