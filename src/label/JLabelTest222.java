package label;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;

public class JLabelTest222 extends JFrame implements ItemListener{
	
	private JPanel contentPane;
	
	public JLabelTest222() {
		
		setTitle("토글버튼을 이용한 아이콘");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		getContentPane().add(tglbtnNewToggleButton, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==1) {
			
		}else {
			
		}
	}

}
