import java.awt.Graphics;

public class Ball extends GameObject {
	int speed = 12;
	int xSpeed;

	Ball(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
		super.update();
		y -= speed;
		if (y < 0) {
		}
		x += xSpeed;
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
