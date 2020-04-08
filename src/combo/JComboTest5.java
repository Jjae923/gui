package combo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JComboTest5 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultComboBoxModel<String> model;
	private JComboBox comboBox;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboTest5 frame = new JComboTest5();
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
	public JComboTest5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.addActionListener(this);
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("삭제");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		model = new DefaultComboBoxModel<String>();
		model.addElement("사과");
		model.addElement("수박");
		
		comboBox = new JComboBox(model);
		panel.add(comboBox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// textField, button
		if(e.getSource()==textField) {
			model.addElement(textField.getText());
		}else { // JButton => 삭제
			model.removeElementAt(comboBox.getSelectedIndex());
		}
	}
}
