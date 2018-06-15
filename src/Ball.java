import java.awt.Graphics;

public class Ball extends GameObject {
	int speed = 3;
	int xSpeed = 3;
	boolean dead = false;

	Ball(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
		super.update();
		y -= speed;
		if (y < 0) {
			dead = true;
		}
		if (y > 800) {
			dead = true;
		}
		if (x <= 0) {
			xSpeed = -xSpeed;
		} else if (x >= Pong2_0.width) {
			xSpeed = -xSpeed;
		}

		x += xSpeed;
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
