package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private Color color;
	private GameBoard board;
	
	// 라켓의 위치 지정
	private int posX, posY;
	
	// 라켓 길이 지정
	private static final int WIDTH = 10;
	private static final int HEIGHT = 80;
	
	// 라켓 속도 조절
	private int ySpeed;
	
	
	
	public Racquet(Color color, GameBoard board, int posX, int posY) {
		super();
		this.color = color;
		this.board = board;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void draw(Graphics g) { // Graphics : 붓과 같은 역할
		g.setColor(color);
		g.fillRect(posX, posY, WIDTH, HEIGHT);
	}
	
	public void move() {
		if(posY + ySpeed > 0 && posY + ySpeed < board.getHeight() - HEIGHT) {
			posY += ySpeed;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_UP) {
			ySpeed = -3;
		}
		if(keyCode == KeyEvent.VK_DOWN) {
			ySpeed = +3;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		ySpeed = 0;
	}
	
	// 라켓의 위치를 사각형으로 반환하기
	public Rectangle getBounds() {
		return new Rectangle(posX, posY, WIDTH, HEIGHT);
	}
}
