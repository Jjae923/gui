package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	
	private GameBoard board;
	private Color color = Color.RED;
	
	// 공 시작 위치
	private int posX = 0;
	private int posY = 0;
	
	// 공 크기
	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;
	
	// 공 움직임 속도
	private int xSpeed = 2;
	private int ySpeed = 2;
	
	
	public Ball(GameBoard board) {
		this.board = board;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(posX, posY, WIDTH, HEIGHT);
	}
	
	public void move() {
		
		int x = posX + xSpeed;
		int y = posY + ySpeed;
		
		// 공이 사각형 밖으로 벗어나지 못하도록 제한
		if( x < 0 ) {
			xSpeed = 2;
		}
		if( x > board.getWidth() - WIDTH ) {
			xSpeed = -2;
		}
		if( y < 0 ) {
			ySpeed = 2;
		}
		if( y > board.getHeight() - HEIGHT ) {
			ySpeed = -2;
		}
		
		if(collision()) {
			xSpeed = -xSpeed;
		}
		
		
		posX += xSpeed;
		posY += ySpeed;
	}
	
	// 공의 위치를 사각형으로 반환하기
	public Rectangle getBounds() {
		return new Rectangle(posX, posY, WIDTH, HEIGHT);
	}
	
	// 공과 라켓의 교차여부를 알아내기
	public boolean collision() {
		return board.getRacquet1().getBounds().intersects(getBounds());
	}

}
