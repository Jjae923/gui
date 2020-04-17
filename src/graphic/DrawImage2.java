package graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawImage2 extends JFrame implements ActionListener {

	private BufferedImage img;
	private int pieces = 4;
	private int totalPiecs = pieces * pieces;
	private int[] pieceNumber;
	
	class DividedImage extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int pieceWidth = img.getWidth() / pieces; 	 //  640 / 4 = 160
			int pieceHeight = img.getHeight() / pieces;  //  640 / 4 = 160
			
			for(int i=0;i<pieces;i++) {
				int sx = i * pieceWidth;
				for(int j=0;j<pieces;j++) {
					int sy = j * pieceHeight;
					int number = pieceNumber[i*pieces+j];
					int dx = (number/pieces) * pieceWidth;
					int dy = (number%pieces) * pieceHeight;
					g.drawImage(img, dx, dy, dx+pieceWidth, dy+pieceHeight, sx, sy, sx+pieceWidth, sy+pieceHeight, null);
				}
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawImage2 frame = new DrawImage2();
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
	public DrawImage2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("이미지 분할");
		try {
			URL url = getClass().getResource("hubble.jpg");
			img = ImageIO.read(new File(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		add(new DividedImage(), BorderLayout.CENTER);
		
		pieceNumber = new int[totalPiecs];
		for(int i=0;i<totalPiecs;i++) {
			pieceNumber[i]=i;
		}
		
		JButton btn = new JButton("DIVIDED");
		add(btn, BorderLayout.SOUTH);
		btn.addActionListener(this);
		
		setSize(img.getWidth(), img.getHeight());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		divide();
		repaint();
	}
	
	private void divide() {
		Random random = new Random();
		
		for(int i=0;i<totalPiecs;i++) {
			int ri = random.nextInt(totalPiecs);
			int temp = pieceNumber[i];
			pieceNumber[i]=pieceNumber[ri];
			pieceNumber[ri]=temp;
		}
	}
}
