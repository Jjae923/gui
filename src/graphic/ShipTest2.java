package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

class Ship2 extends JPanel {
	
	private BufferedImage img;
	private int posX, posY;
	
	public Ship2() {
		setBackground(Color.BLACK);
		try {
			URL url = getClass().getResource("ship.jpg");
			img = ImageIO.read(new File(url.getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		posX = 0;
		posY = 250;
		
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 네 개의 화살표에 따라 움직이기
				int keyCode = e.getKeyCode();
				switch(keyCode) {
				case KeyEvent.VK_UP:
					posY -= 3;
					repaint();
					break;
				case KeyEvent.VK_DOWN:
					posY += 3;
					repaint();
					break;
				case KeyEvent.VK_LEFT:
					posX -= 3;
					repaint();
					break;
				case KeyEvent.VK_RIGHT:
					posX += 3;
					repaint();
					break;
				}
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, posX, posY, null);
	}
}
public class ShipTest2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ShipTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		add(new Ship2());
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipTest2 frame = new ShipTest2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
