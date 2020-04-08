package combo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JComboTest3 extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JLabel label;
	private JComboBox<String> combo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboTest3 frame = new JComboTest3();
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
	public JComboTest3() {
		setTitle("좋아하는 동물을 골라주세요");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String items[] = {"Bird","Cat","Dog","Pig","Rabbit"};
		combo = new JComboBox<String>(items);
		combo.addItemListener(this);
//		combo.setSelectedIndex(-1);
		contentPane.add(combo, BorderLayout.NORTH);
		
		label = new JLabel("",SwingConstants.CENTER);
		label.setIcon(new ImageIcon(getClass().getResource("Bird.gif")));
		contentPane.add(label, BorderLayout.CENTER);
	}
	
//	// 내 코딩
//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		JComboBox<String> selected = (JComboBox<String>) e.getSource();
//		
//		if(combo.getSelectedItem()=="Bird") {
//			label.setIcon(new ImageIcon(getClass().getResource("bird.gif")));
//		}else if(combo.getSelectedItem()=="Cat") {
//			label.setIcon(new ImageIcon(getClass().getResource("cat.gif")));
//		}else if(combo.getSelectedItem()=="Dog") {
//			label.setIcon(new ImageIcon(getClass().getResource("dog.gif")));
//		}else if(combo.getSelectedItem()=="Pig") {
//			label.setIcon(new ImageIcon(getClass().getResource("pig.gif")));
//		}else if(combo.getSelectedItem()=="Rabbit") {
//			label.setIcon(new ImageIcon(getClass().getResource("rabbit.gif")));
//		}
//	}

	// 쌤 코딩
	@Override
	public void itemStateChanged(ItemEvent e) {
		String animal = (String)e.getItem();
		updateIcon(animal);
	}
	public void updateIcon(String animal) {
		ImageIcon icon = new ImageIcon(getClass().getResource(animal+".gif"));
		label.setIcon(icon);
	}
}
