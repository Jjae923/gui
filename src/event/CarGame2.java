package event;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel2 extends JPanel { // 새로운 도화지를 하나 Get!
	BufferedImage img = null;
	int img_x=100, img_y=100;
	
	public MyPanel2 () {
		URL url = getClass().getResource("car.gif");
		try {
			img = ImageIO.read(new File(url.getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		// 포커스 요청하기
		this.requestFocus();
		setFocusable(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null); // 이미지 읽어다 도화지에 그린 것!
		
	}
	
	// 사용자가 4방향의 화살표를 클릭한 경우
}

public class CarGame2 extends JFrame {
	public CarGame2() {
		setTitle("자동차 움직이기");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel2());
	}
	
	public static void main(String[] args) {
		CarGame2 car = new CarGame2();
		car.setVisible(true);

	}
}
