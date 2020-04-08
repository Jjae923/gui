package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

public class JTableTest2 extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest2 frame = new JTableTest2();
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
	public JTableTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTable table = new JTable(new MyTableModel());
		JScrollPane pane = new JScrollPane(table);
		add(pane);
	}
	// 사용자 정의 테이블 모델
	class MyTableModel extends AbstractTableModel {
		// 칼럼명
		private String[] columnName= {"First Name","Last Name",
				"Sprot","# of Years", "Vegetarian"};
		// 보여줄 데이터
		private Object[][] data= { // Vector가 들어와도 됨
				{"Kathy","Smith","Snowboarding",new Integer(5),new Boolean(false)},
				{"John","Doe","Rowing",new Integer(3),new Boolean(true)},
				{"Sue","Black","Knitting",new Integer(2),new Boolean(false)},
				{"Jane","White","Speed reading",new Integer(20),new Boolean(true)},
				{"Joe","Brown","Pool",new Integer(10),new Boolean(false)},
		};
		
		@Override
		public int getRowCount() {
			return data.length;
		}

		@Override
		public int getColumnCount() {
			return columnName.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}
		@Override
		public String getColumnName(int column) {
			return columnName[column];
		}
		
		// 컬럼 수정 여부
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if(columnIndex < 2) {
				return false;
			}else {
				return true;
			}
		}
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
	}
}
 









 