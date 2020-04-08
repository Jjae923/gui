package checkbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class JCheckTest4 extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JLabel lblApple,lblGrape,lblOrange;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckTest4 frame = new JCheckTest4();
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
	public JCheckTest4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JCheckBox chkApple = new JCheckBox("Apple");
		panel.add(chkApple);
		
		JCheckBox chkGrape = new JCheckBox("Grape");
		panel.add(chkGrape);
		
		JCheckBox chkOrange = new JCheckBox("Orange");
		panel.add(chkOrange);
		
		lblApple = new JLabel("");
		contentPane.add(lblApple);
		
		lblGrape = new JLabel("");
		contentPane.add(lblGrape);
		
		lblOrange = new JLabel("");
		contentPane.add(lblOrange);
		
		chkApple.addItemListener(this);
		chkGrape.addItemListener(this);
		chkOrange.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox check = (JCheckBox)e.getItem();		
		ImageIcon icon = null;		
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(check.getText().equals("Apple")) {
				icon = new ImageIcon(getClass().getResource("apple.gif"));
				lblApple.setIcon(icon);
			}else if(check.getText().equals("Grape")) {
				icon = new ImageIcon(getClass().getResource("grape.gif"));
				lblGrape.setIcon(icon);
			}else if(check.getText().equals("Orange")) {
				icon = new ImageIcon(getClass().getResource("orange.gif"));
				lblOrange.setIcon(icon);
			}
		}else {
			if(check.getText().equals("Apple")) {				
				lblApple.setIcon(null);
			}else if(check.getText().equals("Grape")) {				
				lblGrape.setIcon(null);
			}else if(check.getText().equals("Orange")) {
				lblOrange.setIcon(null);
			}
		}
	}
}
