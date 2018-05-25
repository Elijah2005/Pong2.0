import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObject {
	int speed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	Paddle(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	void update() {
		super.update();
		if (right == true) {
			x += speed;
		}
		if (left == true) {
			x -= speed;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

		g.drawImage(GamePanel.paddleImg, x, y, width, height, null);

	}
}
