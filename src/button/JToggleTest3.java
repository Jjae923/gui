package button;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JToggleTest3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JToggleButton tglbtnNewToggleButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JToggleTest3 frame = new JToggleTest3();
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
	public JToggleTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tglbtnNewToggleButton = new JToggleButton("토글버튼");
		tglbtnNewToggleButton.addActionListener(this);
		tglbtnNewToggleButton.setFont(new Font("굴림", Font.PLAIN, 18));
		contentPane.add(tglbtnNewToggleButton, BorderLayout.NORTH);
		
		btnNewButton = new JButton("버튼");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 18));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 방법1.
//		if(e.getSource()==btnNewButton) { // 일반버튼
//			lblNewLabel.setText("일반버튼 클릭");
//		}else { // toggle 버튼
//			JToggleButton tgl = (JToggleButton) e.getSource();
//			if(tgl.isSelected()) {
//				lblNewLabel.setText("Button on");
//			}else {
//				lblNewLabel.setText("Button off");
//			}
//		}

		// 방법2.
		AbstractButton btn = (AbstractButton) e.getSource();	// 부모로 받기
		if(btn==btnNewButton) { // 일반버튼
			lblNewLabel.setText("일반버튼 클릭");
		}else { // toggle 버튼
			if(btn.isSelected()) {
				lblNewLabel.setText("Button on");
			}else {
				lblNewLabel.setText("Button off");
			}
		}
	}
}
