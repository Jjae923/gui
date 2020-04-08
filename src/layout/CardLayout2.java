package layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CardLayout2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel[];
	private JPanel panel_2;
	private JButton mainBtn1, mainBtn2, mainBtn3;  
	
	public CardLayout2() {
		setTitle("카드 레이아웃");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		// 상단에 보여줄 레이아웃 담당
		JPanel top = new JPanel();
		add(top, BorderLayout.NORTH);
		
		mainBtn1 = new JButton("첫번째");
		mainBtn2 = new JButton("두번째");
		mainBtn3 = new JButton("세번째");
		
		top.add(mainBtn1);
		top.add(mainBtn2);
		top.add(mainBtn3);
		
		// center에 보여줄 레이아웃 담당 - 카드 레이아웃 설정
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,191,255));
		panel_2.setLayout(new CardLayout());
		add(panel_2, BorderLayout.CENTER);
		
		// 카드 레이아웃에 보여줄 패널 생성하기
		getJPanel(3);
		
		// CardLayout contentPane에 생성된 JPanel 추가
		int i=1;
		for(JPanel p:panel) {
			panel_2.add(String.valueOf(i),p);
			i++;
		}
		
		// 첫번째 카드에 보여줄 컴포넌트
		JButton btn1=new JButton("첫번째 카드-첫번째 버튼");
		JRadioButton radio = new JRadioButton("대한민국");
		mainBtn1.addActionListener(this);
		panel[0].setBackground(Color.CYAN);
		panel[0].add(btn1);
		panel[0].add(radio);

		// 두번째 카드에 보여줄 컴포넌트
		JButton btn2=new JButton("두번째 카드-두번째 버튼");
		mainBtn2.addActionListener(this);
		panel[1].setBackground(Color.GREEN);
		panel[1].add(btn2);
		
		// 세번째 카드에 보여줄 컴포넌트
		JButton btn3=new JButton("세번째 카드-세번째 버튼");
		mainBtn3.addActionListener(this);
		panel[2].setBackground(Color.ORANGE);
		panel[2].add(btn3);
	}
	
	public static void main(String[] args) {
		CardLayout2 card = new CardLayout2();
		card.setVisible(true);
	}
	
	private JPanel[] getJPanel(int cnt) {
		panel = new JPanel[cnt];
		for(int i=0;i<panel.length;i++) {
			if(panel[i]==null) {
				panel[i]=new JPanel();
			}
		}
		return panel;
	}
 
	// 다음에 어떻게 부를지 담겨있음
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		JPanel p = (JPanel) getContentPane().getComponent(1);
		CardLayout card = (CardLayout) p.getLayout();
		
		if(btn==mainBtn1) {       // 버튼을 눌렀을 때 원하는 패널이 뜨도록 
			card.show(p,  "1");
		}else if(btn==mainBtn2) {
			card.show(p,  "2");
		}else if(btn==mainBtn3) {
			card.show(p,  "3");
		}
	}
}
