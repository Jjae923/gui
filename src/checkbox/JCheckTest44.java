package checkbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JCheckTest44 extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JCheckBox chckbxApple, chckbxGrape, chckbxOrange;
	private JLabel lblApple;
	private JLabel lblGrape;
	private JLabel lblOrange;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckTest44 frame = new JCheckTest44();
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
	public JCheckTest44() {
		setTitle("체크박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		chckbxApple = new JCheckBox("Apple");
		chckbxApple.addItemListener(this);
		panel.add(chckbxApple);
		
		chckbxGrape = new JCheckBox("Grape");
		chckbxGrape.addItemListener(this);
		panel.add(chckbxGrape);
		
		chckbxOrange = new JCheckBox("Orange");
		chckbxOrange.addItemListener(this);
		panel.add(chckbxOrange);
		
		lblApple = new JLabel("");
		contentPane.add(lblApple);
		
		lblGrape = new JLabel("");
		contentPane.add(lblGrape);
		
		lblOrange = new JLabel("");
		contentPane.add(lblOrange);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		JCheckBox check = (JCheckBox) e.getSource();
		ImageIcon icon = null;
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(check==chckbxApple) {
				lblApple.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/apple.gif")));
			}else if(check==chckbxGrape) {
				lblGrape.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/grape.gif")));
			}else if(check==chckbxOrange) {
				lblOrange.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/orange.gif")));
			}
		}else {
			if(check==chckbxApple) {
				lblApple.setIcon(null);
			}else if(check==chckbxGrape) {
				lblGrape.setIcon(null);
			}else if(check==chckbxOrange) {
				lblOrange.setIcon(null);
			}
		}
	}
}	
