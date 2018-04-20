import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Paddle paddle1;
	Ball ball;
	Paddle paddle2;
	long enemyTimer = 0;
	int enemySpawnTime = 0;
	ArrayList<Alien> alien = new ArrayList<Alien>();

	ObjectManager(Paddle paddle, Ball ball, Paddle paddle2) {
		this.paddle1 = paddle;
		this.paddle2 = paddle2;
		this.ball = ball;
	}

	void update() {
		paddle1.update();
		ball.update();
		paddle2.update();

	}

	void draw(Graphics g) {
		paddle1.draw(g);
		ball.draw(g);
		paddle2.draw(g);
		for (int i = 0; i < alien.size(); i++) {
			Alien a = alien.get(i);
			a.draw(g);

		}
		System.out.println(alien.size());
	}

	void addAlien(Alien a) {
		alien.add(a);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(+500), new Random().nextInt(+500) + 100, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}

	}

	void purgeObjects() {

	}
}
