package label;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JToggleButton;

public class JLabelTest2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblImage;
	private JToggleButton tglbtnNewToggleButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLabelTest2 frame = new JLabelTest2();
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
	public JLabelTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblImage = new JLabel("");
		contentPane.add(lblImage, BorderLayout.CENTER);
		
		tglbtnNewToggleButton = new JToggleButton("이미지 보려면 클릭하세요");
		tglbtnNewToggleButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					ImageIcon icon = new ImageIcon(getClass().getResource("dog.gif"));
					lblImage.setIcon(icon);
					lblImage.setText("그림이 나타났어요");
				}else {
					lblImage.setIcon(null);
					lblImage.setText("그림이 사라졌어요");
				}
			}
		});
		contentPane.add(tglbtnNewToggleButton, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 클릭시 라벨에 이미지 보여주기
		ImageIcon dog = new ImageIcon(getClass().getResource("pu.jpg"));		
		lblImage.setIcon(dog);
	}
}
