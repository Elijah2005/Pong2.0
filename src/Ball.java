import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	int speed = 15;

	Ball(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
		super.update();
		y -= speed;
		if (y < 0) {
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
	}
}
