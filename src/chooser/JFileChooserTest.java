package chooser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooserTest extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOpen, btnSave;
	private JFileChooser chooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");  // 기본
//					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  		// Windows 창 모양으로 열기①
//					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");  // Windows 창 모양으로 열기②
					JFileChooserTest frame = new JFileChooserTest();
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
	public JFileChooserTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("파일 선택기");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		btnOpen = new JButton("파일오픈");
		btnOpen.addActionListener(this);
		panel.add(btnOpen);
		
		btnSave = new JButton("파일저장");
		btnSave.addActionListener(this);
		panel.add(btnSave);
		
		chooser = new JFileChooser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		if(btn==btnOpen) {
			int retVal = chooser.showOpenDialog(this);
			if(retVal == JFileChooser.APPROVE_OPTION) {
				System.out.println(chooser.getSelectedFile());
			}else {
				System.out.println("취소 버튼 클릭");
			}
		}else {
			chooser.setDialogTitle("파일 저장");
			File f = new File("c:\\");
			chooser.setCurrentDirectory(f);
			
			// 파일 유형 추가하기
			FileNameExtensionFilter filter1 = new FileNameExtensionFilter("텍스트 파일", "txt");
			FileNameExtensionFilter filter2 = new FileNameExtensionFilter("이미지 파일", "jpg","gif","png");
			
			chooser.setFileFilter(filter1);
			chooser.setFileFilter(filter2);
			
			int retVal=chooser.showSaveDialog(this); // 띄우는 코드는 세팅 끝내고 마지막에 ☆
			if(retVal == JFileChooser.OPEN_DIALOG) {
				
			}else {
				
			}
		}
	}
}
