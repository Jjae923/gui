package list;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest4 extends JFrame implements ListSelectionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JList<String> list;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListTest4 frame = new JListTest4();
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
	public JListTest4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 10, 0));
		
		list = new JList<>();
		list.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"수성", "금성", "지구", "화성", "목성", "토성", "천왕성", "해왕성"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list);
		list.addListSelectionListener(this);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		panel.add(textArea);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// ListSelectionEvent => 아이템을 선택하는 시점과
		// 마우스에서 손을 떼는 시점에도 이벤트가 발생됨
		if(e.getValueIsAdjusting()) {
			List<String> items=list.getSelectedValuesList();
			textArea.setText("");
			for(String item:items) {
				textArea.append(item);
			}
		}
	}
}


















