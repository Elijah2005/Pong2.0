import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Paddle paddle;
	Ball ball;
	ObjectManager(Paddle paddle, Ball ball) {
		this.paddle = paddle;
		this.ball = ball;
	}
	void update(){
		paddle.update();
		ball.update();
	}
	void draw(Graphics g) {
		paddle.draw(g);
		ball.draw(g);
	}

}
