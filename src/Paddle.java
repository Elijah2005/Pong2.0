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

	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(x, y, width, height);
	}
}
