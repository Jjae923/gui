package exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterRest extends JFrame implements ActionListener {
	
	private JTextField field1, field2, Result;
	private JButton btn1;
	
	public InterRest() {
		
		setTitle("이자계산기");
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("원금을 입력하시오");
		field1 = new JTextField(10);
		
		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("이율을 입력하시오");
		field2 = new JTextField(10);
		
		panel1.add(label1);
		panel1.add(field1);
		mainpanel.add(panel1);
		panel2.add(label2);
		panel2.add(field2);
		mainpanel.add(panel2);
		
		JPanel panel3 = new JPanel();
		btn1 = new JButton("변환");
		btn1.addActionListener(this);
		
		panel3.add(btn1);
		mainpanel.add(panel3);

		JPanel panel4 = new JPanel();
		Result = new JTextField(20);
		panel4.add(Result);
		mainpanel.add(panel4);
			
		add(mainpanel);
		setVisible(true);
	}

	public static void main(String[] args) {
		InterRest test = new InterRest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int op1 = Integer.parseInt(field1.getText());
		double op2 = Double.parseDouble(field2.getText());
		double result = 0;
		
		if(e.getSource()==btn1) {
			result = op1 * op2;
			Result.setText(result+"");
		}
	}
}
