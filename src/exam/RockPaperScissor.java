package exam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;

public class RockPaperScissor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static final int ROCK=0;
	private static final int PAPER=1;
	private static final int SCISSOR=2;
	private JTextField result;
	
	public RockPaperScissor () {
		setTitle("가위바위보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(962, 373);
	
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		getContentPane().add(contentPane);
	
		JPanel topPanel = new JPanel();
		JLabel label = new JLabel("아래의 버튼 중에서 하나를 클릭하시오!");
		topPanel.add(label);
		contentPane.add(topPanel, BorderLayout.NORTH);
	
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(0,3));
		contentPane.add(btnPanel, BorderLayout.CENTER);
	
		JButton btn1 = new JButton("ROCK");
		btn1.setIcon(new ImageIcon(RockPaperScissor.class.getResource("/exam/rock.png")));
		btnPanel.add(btn1);
		btn1.addActionListener(this);
	
		JButton btn2 = new JButton("PAPER");
		btn2.setIcon(new ImageIcon(RockPaperScissor.class.getResource("/exam/paper.png")));
		btnPanel.add(btn2);
		btn2.addActionListener(this);

		JButton btn3 = new JButton("SCISSOR");
		btn3.setIcon(new ImageIcon(RockPaperScissor.class.getResource("/exam/scissor.png")));
		btnPanel.add(btn3);
		btn3.addActionListener(this);
	
		result = new JTextField();
		result.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		contentPane.add(result, BorderLayout.SOUTH);
	
		setVisible(true);
	}
	
	public static void main(String[] args) {
		RockPaperScissor game = new RockPaperScissor();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 컴퓨터의 가위,바위,보 생성하기
		Random random = new Random();
		// random.nextInt(3) : 괄호 안의 숫자는 미포함해서 0,1,2 중에서 나오게 함
		int computer = random.nextInt(3); 
		// 사용자가 누른 버튼의 값을 가져온 후
		String op =  e.getActionCommand();
		// 가위바위보를 해서 누가 이겼는지
		// txtField에 보여주기
		switch (op) {
		case "ROCK" :
			if(computer==ROCK) {
				result.setText("비겼습니다");
			}else if(computer==PAPER) {
				result.setText("알파고님 충성충성^^7");
			}else {
				result.setText("컴퓨터를 이겼습니다");
			}
		case "PAPER" :
			if(computer==ROCK) {
				result.setText("컴퓨터를 이겼습니다");
			}else if(computer==PAPER) {
				result.setText("비겼습니다");
			}else {
				result.setText("알파고님 충성충성^^7");
			}
		case "SCISSOR" :
			if(computer==ROCK) {
				result.setText("알파고님 충성충성^^7");
			}else if(computer==PAPER) {
				result.setText("컴퓨터를 이겼습니다");
			}else {
				result.setText("비겼습니다");
			}
		}
	}
}
