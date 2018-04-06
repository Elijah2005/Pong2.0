import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Paddle paddle;
	Ball ball;
	Paddle paddle2;
	ArrayList<Alien> alien = new ArrayList<Alien>();

	ObjectManager(Paddle paddle, Ball ball, Paddle paddle2) {
		this.paddle = paddle;
		this.paddle2 = paddle2;
		this.ball = ball;
	}

	void update() {
		paddle.update();
		ball.update();
		paddle2.update();

	}

	void draw(Graphics g) {
		paddle.draw(g);
		ball.draw(g);
		paddle2.draw(g);
		for (int i = 0; i < alien.size(); i++) {
			Alien a = alien.get(i);
			a.draw(g);
		}
	}

	void addAlien() {

	}
}
