package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class JTableTest1 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest1 frame = new JTableTest1();
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
	public JTableTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table = new JTable();
		table.setModel(new DefaultTableModel( // 테이블에 뭔가 입력하고 싶을 때 Model을 생성
				new Object[][] {
					{"hong", "27"},
					{"park", "28"},
					{"kim", null},
				},
				new String[] {
						"\uC774\uB984", "\uB098\uC774"
				}
				));
		
		JButton btnNewButton = new JButton("출력");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// table 내용을 가져와서 출력하기
				
				// ① 모델 가져오기
				TableModel model = table.getModel();
				System.out.println("이름\t나이");
				// ② 모델의 내용 출력하기
				for(int i=0;i<model.getRowCount();i++) {
					for(int j=0;j<model.getColumnCount();j++) {
						System.out.print(model.getValueAt(i, j)+"\t");
					}
					System.out.println();
				}
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(table);
	}
}





