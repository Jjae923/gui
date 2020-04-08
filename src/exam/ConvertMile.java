package exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConvertMile extends JFrame implements ActionListener{

	private JTextField field1, Result;
	private JButton btn1;
	
	public ConvertMile() {

		setTitle("마일을 킬로미터로 변환");
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));

		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("거리를 마일 단위로 입력하세요");
		field1 = new JTextField(10);
		
		panel1.add(label1);
		panel1.add(field1);
		mainpanel.add(panel1);
		
		JPanel panel2 = new JPanel();
		btn1 = new JButton("변환");
		btn1.addActionListener(this);
		panel2.add(btn1);
		mainpanel.add(panel2);
		
		JPanel panel3 = new JPanel();
		Result = new JTextField(20);
		panel3.add(Result);
		mainpanel.add(panel3);
		
		add(mainpanel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ConvertMile test = new ConvertMile();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		double op1 = Double.parseDouble(field1.getText());
		double op2 = 0.0;
		
		if (e.getSource()==btn1) {
			op2 = op1 * 1.6;
			Result.setText(op2+"km");
		}
	}
}
