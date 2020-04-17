package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

class Traffic extends JPanel implements ActionListener {
	
	private int lightNumber = 0;
	
	public Traffic() {
		setLayout(new BorderLayout());
		JButton btnTurn = new JButton("traffic light turn on");
		btnTurn.addActionListener(this);
		add(btnTurn, BorderLayout.SOUTH);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(50, 50, 100, 100);
		g.drawOval(50, 150, 100, 100);
		g.drawOval(50, 250, 100, 100);
		
		if(lightNumber==0) {
			g.setColor(Color.RED);
			g.fillOval(50, 50, 100, 100);
		}else if(lightNumber==1) {
			g.setColor(Color.GREEN);
			g.fillOval(50, 150, 100, 100);
		}else {
			g.setColor(Color.BLUE);
			g.fillOval(50, 250, 100, 100);
		} 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(++lightNumber>2) {
			lightNumber = 0;
		}
		repaint();
	}
}

public class TrafficLight extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrafficLight frame = new TrafficLight();
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
	public TrafficLight() {
		setTitle("신호등");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		add(new Traffic());
	}
}
 