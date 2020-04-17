package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements KeyListener {
	
	private Ball ball;
	private Racquet racquet1, racquet2;

	public GameBoard() {
		setBackground(Color.GREEN);
		ball = new Ball(this);
		racquet1 = new Racquet(Color.BLUE, this, 10, 150);
		racquet2 = new Racquet(Color.YELLOW, this, 560, 150);
		setFocusable(true);
		addKeyListener(this);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("pingpong");
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameBoard board = new GameBoard();
		f.add(board);
		f.setVisible(true);
		
		while(true) {
			board.move();
			board.repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		racquet1.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		racquet1.keyReleased(e);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.draw(g);
		racquet1.draw(g);
		racquet2.draw(g);
		
	}
	
	public void move() {
		ball.move();
		racquet1.move();
	}

	public Racquet getRacquet1() {
		return racquet1;
	}

	public Racquet getRacquet2() {
		return racquet2;
	}
	
}
