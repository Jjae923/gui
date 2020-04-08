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

public class JComboTest55 extends JFrame implements ActionListener, ItemListener {

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
					JComboTest55 frame = new JComboTest55();
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
	public JComboTest55() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("삭제");
		btnNewButton.addItemListener(this);
		panel.add(btnNewButton);
		
		model = new DefaultComboBoxModel<String>();
		model.addElement("사과");
		model.addElement("수박");
		
		JComboBox comboBox = new JComboBox(model);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.addActionListener(this);
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.addElement((String) e.getActionCommand());
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		model.removeElementAt(comboBox.getSelectedIndex());
		
	}
}
