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

	Paddle p = new Paddle(143, 770, 200, 20);

	Ball b1 = new Ball(230, 740, 10, 10);

	Paddle p2 = new Paddle(143, 10, 200, 20);

	ObjectManager m = new ObjectManager(p, b1, p2);

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
			p.up = true;
			p2.up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p.down = true;
			p2.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			p.left = true;
			p2.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			p.right = true;
			p2.right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == e.VK_UP) {
			p.up = false;
			p2.up = false;
		}
		if (e.getKeyCode() == e.VK_DOWN) {
			p.down = false;
			p2.down = false;
		}
		if (e.getKeyCode() == e.VK_LEFT) {
			p.left = false;
			p2.left = false;
		}
		if (e.getKeyCode() == e.VK_RIGHT) {
			p.right = false;
			p2.right = false;
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		m.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, Pong2_0.width, Pong2_0.height);

		g.setFont(titleFont);

		g.drawString("text", 100, 100);

		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("PONG 2.0", 115, 260);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 116, 370);
		g.setFont(subtitleFont2);
		g.drawString("Press SPACE for instructions", 70, 500);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, Pong2_0.width, Pong2_0.height);

		m.draw(g);
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
		g.drawString("You killed 0 enemies", 133, 370);
		g.setFont(subtitleFont2);
		g.drawString("Press ENTER to restart", 120, 500);
	}
}
