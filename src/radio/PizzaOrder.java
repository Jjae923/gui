package radio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PizzaOrder extends JFrame implements ItemListener,ActionListener{

	private JPanel contentPane;
	private JRadioButton radioCombo,radioPotato,radioBul,radioPepper;
	private JRadioButton radioCheese,radioPepp,radioBacon,rdbtnSmall;
	private JRadioButton rdbtnMedium,rdbtnLarge;
	private JLabel lbl,lblPay;	
	private JButton btnConfirm,btnCancel;	
	private ButtonGroup group1,group2,group3;
	private String orderKind, orderTopp,orderSize;
	private int kindMoney,topMoney,sizeMoney;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaOrder frame = new PizzaOrder();
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
	public PizzaOrder() {
		setTitle("피자주문");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		//피자 아이콘
//		URL imgURL = getClass().getResource("pizza.png");
//		setIconImage(new ImageIcon(imgURL).getImage());		
		
		
		//상단 제목 부분
		JLabel lblNewLabel = new JLabel("자바 피자에 오신 것을 환영합니다.",SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		// 하단 버튼 2개 / 라벨 붙이기 위한 패널 설정
		JPanel panel = new JPanel();
		//panel.setBackground(Color.WHITE);
	
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnConfirm = new JButton("주문");		
		btnConfirm.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(btnConfirm);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(btnCancel);
		
		lbl = new JLabel("금액 : ");
		panel.add(lbl);
		
		lblPay = new JLabel("");
		panel.add(lblPay);
		
		//가운데 선택사항 보여주기 위한 라벨 설정(GridLayout)
		JPanel panel_1 = new JPanel();		
		//panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		//피자 종류 보여주기 위한 패널 설정
		JPanel panel_2 = new JPanel();
		//panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		radioCombo = new JRadioButton("콤보");	
		//radioCombo.setBackground(Color.WHITE);
		radioCombo.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_2.add(radioCombo);
		
		radioPotato = new JRadioButton("포테이토");
		//radioPotato.setBackground(Color.WHITE);
		radioPotato.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_2.add(radioPotato);
		
		radioBul = new JRadioButton("불고기");
		//radioBul.setBackground(Color.WHITE);
		radioBul.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_2.add(radioBul);	
		
		//토핑 보여주기 위한 패널 설정
		JPanel panel_3 = new JPanel();
		//panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 10, 0));
		
		radioPepper = new JRadioButton("피망");
		//radioPepper.setBackground(Color.WHITE);
		radioPepper.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_3.add(radioPepper);
		
		radioCheese = new JRadioButton("치즈");
		//radioCheese.setBackground(Color.WHITE);
		radioCheese.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_3.add(radioCheese);
		
		radioPepp = new JRadioButton("페페로니");
		//radioPepp.setBackground(Color.WHITE);
		radioPepp.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_3.add(radioPepp);
		
		radioBacon = new JRadioButton("베이컨");
		//radioBacon.setBackground(Color.WHITE);
		radioBacon.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_3.add(radioBacon);
		
		
		//피자 사이즈 보여주기 위한 패널 설정
		JPanel panel_4 = new JPanel();
		//panel_4.setBackground(Color.WHITE);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbtnSmall = new JRadioButton("Small");
		//rdbtnSmall.setBackground(Color.WHITE);
		rdbtnSmall.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_4.add(rdbtnSmall);
		
		rdbtnMedium = new JRadioButton("Medium");
		//rdbtnMedium.setBackground(Color.WHITE);
		rdbtnMedium.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_4.add(rdbtnMedium);
		
		rdbtnLarge = new JRadioButton("Large");
		//rdbtnLarge.setBackground(Color.WHITE);
		rdbtnLarge.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_4.add(rdbtnLarge);
		
		//라디오 하나만 선택하기 위한 그룹 설정
		group1=new ButtonGroup();
		group1.add(radioCombo);
		group1.add(radioPotato);
		group1.add(radioBul);
		
		group2=new ButtonGroup();
		group2.add(radioPepper);
		group2.add(radioCheese);
		group2.add(radioPepp);
		group2.add(radioBacon);
		
		group3=new ButtonGroup();
		group3.add(rdbtnSmall);
		group3.add(rdbtnMedium);
		group3.add(rdbtnLarge);
		
		//테두리 설정
		Border border1=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "종류", TitledBorder.LEFT, TitledBorder.TOP, new Font("나눔 고딕",Font.BOLD,13));
		panel_2.setBorder(border1);
		
		border1=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "추가 토핑", TitledBorder.LEFT, TitledBorder.TOP, new Font("나눔 고딕",Font.BOLD,13));
		panel_3.setBorder(border1);
		
		border1=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "크기", TitledBorder.LEFT, TitledBorder.TOP, new Font("나눔 고딕",Font.BOLD,13));
		panel_4.setBorder(border1);	
		
		//리스너 설정
		radioCombo.addItemListener(this);
		radioPotato.addItemListener(this);
		radioBul.addItemListener(this);
		radioCheese.addItemListener(this);
		radioPepper.addItemListener(this);
		radioPepp.addItemListener(this);
		radioBacon.addItemListener(this);
		rdbtnSmall.addItemListener(this);
		rdbtnMedium.addItemListener(this);
		rdbtnLarge.addItemListener(this);
		btnCancel.addActionListener(this);
		btnConfirm.addActionListener(this);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton btn = (AbstractButton) e.getSource();	
		//종류 : 콤보(10000),포테이토(12000),불고기(13000)
		//추가토핑 : 피망(2000),치즈(2000),페페로니(1000),베이컨(3000)
		//크기 : small(1000), Medium(2000), Large(3000)
		if(btn==btnCancel) {		
			kindMoney=0;
			topMoney=0;
			sizeMoney=0;
			group1.clearSelection();
			group2.clearSelection();
			group3.clearSelection();
			lblPay.setText("");
		}else { //btnConfirm			
			String orderList="주문내역\n"+"피자종류 : "+ orderKind+"\n"+"피자토핑 : "
					+ orderTopp+"\n"+"피자크기 : "+orderSize+"\n"; 
			int result=0;
			if(orderKind.equals("")) {
				result=JOptionPane.showConfirmDialog(getParent(), "주문이 완료되지 않았습니다.","주문완료",
						JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
			}else{
				result=JOptionPane.showConfirmDialog(getParent(), orderList+ "주문하시겠습니까?","주문완료",
						JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
			}
			if(result!=0) {
				//기존 주문내역 취소
			}
		}		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton btn = (JRadioButton) e.getSource();
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(btn==radioCombo) {
				kindMoney=10000;
				orderKind=btn.getText();
			}else if(btn==radioPotato) {
				kindMoney=12000;
				orderKind=btn.getText();
			}else if(btn==radioBul) {
				kindMoney=13000;
				orderKind=btn.getText();
			}else if(btn==radioCheese) {
				topMoney=2000;
				orderTopp=btn.getText();
			}else if(btn==radioPepper) {
				topMoney=2000;
				orderTopp=btn.getText();
			}else if(btn==radioPepp) {
				topMoney=1000;
				orderTopp=btn.getText();
			}else if(btn==radioBacon) {
				topMoney=3000;
				orderTopp=btn.getText();
			}else if(btn==rdbtnSmall) {
				sizeMoney=1000;
				orderSize=btn.getText();
			}else if(btn==rdbtnMedium) {
				sizeMoney=2000;
				orderSize=btn.getText();
			}else if(btn==rdbtnLarge) {
				sizeMoney=3000;
				orderSize=btn.getText();
			}
		}
		int money=kindMoney+topMoney+sizeMoney;
		lblPay.setText(money+"");
	}	
}
