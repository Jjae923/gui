package layout;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame {
	
	public JTabbedPaneTest() {
		setTitle("JTabbedPane");
		setSize(300, 300);
		setVisible(true);
		
		JTabbedPane jTabbed = new JTabbedPane();
		// tab 이 보여질 위치 지정  → 종류 : LEFT / RIGHT / TOP / BOTTOM
		jTabbed.setTabPlacement(JTabbedPane.LEFT);
		
		// 탭에 보여줄 패널 추가
		JPanel first = new JPanel();
		first.setBackground(Color.YELLOW);
		jTabbed.addTab("첫번째", first);

		// 탭에 보여줄 패널 추가
		JPanel second = new JPanel();
		second.setBackground(Color.BLUE);
		jTabbed.addTab("두번째", second);
		
		// 탭에 보여줄 패널 추가
		JPanel third = new JPanel();
		third.setBackground(Color.MAGENTA);
		jTabbed.addTab("세번째", third);
		
		add(jTabbed);
	}

	public static void main(String[] args) {
		JTabbedPaneTest pane = new JTabbedPaneTest();
	}
}
