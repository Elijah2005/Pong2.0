import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer clock;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	int currentState = MENU_STATE;

	Font titleFont;

	Font subtitleFont;

	Font subtitleFont2;

	Paddle paddle1 = new Paddle(143, 770, 200, 20);

	Ball b1 = new Ball(230, 740, 10, 10);

	Paddle paddle2 = new Paddle(143, 10, 200, 20);

	ObjectManager manager = new ObjectManager(paddle1, b1, paddle2);

	GamePanel() {
		clock = new Timer(1000 / 60, this);
		titleFont = new Font("Georgia", titleFont.BOLD, 48);
		subtitleFont = new Font("Arial", titleFont.BOLD, 24);
		subtitleFont2 = new Font("Arial", titleFont.BOLD, 24);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
	}

	void StartGame() {
		clock.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState += 1;

			if (currentState > END_STATE) {

				currentState = MENU_STATE;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			paddle1.up = true;
			paddle2.up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			paddle1.down = true;
			paddle2.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle1.left = true;
			paddle2.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle1.right = true;
			paddle2.right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == e.VK_UP) {
			paddle1.up = false;
			paddle2.up = false;
		}
		if (e.getKeyCode() == e.VK_DOWN) {
			paddle1.down = false;
			paddle2.down = false;
		}
		if (e.getKeyCode() == e.VK_LEFT) {
			paddle1.left = false;
			paddle2.left = false;
		}
		if (e.getKeyCode() == e.VK_RIGHT) {
			paddle1.right = false;
			paddle2.right = false;
		}
	}

	void updateMenuState() {
		// g1.x++;
		// g2.x--;
		// if (g1.collisionBox.intersects(g2.collisionBox)) {
		// System.out.println("Ouch");
		// }
		// g1.update();
		// g2.update();
	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();

	}

	// GameObject g1 = new GameObject(100, 300, 100, 100);
	// GameObject g2 = new GameObject(300, 300, 100, 100);

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

		// g.setColor(Color.BLUE);

		g.fillRect(0, 0, Pong2_0.width, Pong2_0.height);
		// g.fillRect(g2.x, g2.y, g2.width, g2.height);
		g.setFont(titleFont);
		// g.fillRect(g1.x, g1.y, g1.width, g1.height);
		g.drawString("text", 100, 100);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("Pong 2.0", 115, 260);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 116, 370);
		g.setFont(subtitleFont2);
		g.drawString("Press SPACE for instructions", 70, 500);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, Pong2_0.width, Pong2_0.height);

		manager.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, Pong2_0.width, Pong2_0.height);

		g.setFont(titleFont);

		g.drawString("text", 100, 100);

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 90, 260);
		g.setFont(subtitleFont);
		g.drawString("You killed " + manager.score, 133, 370);
		g.setFont(subtitleFont2);
		g.drawString("Press ENTER to restart", 120, 500);
	}
}
