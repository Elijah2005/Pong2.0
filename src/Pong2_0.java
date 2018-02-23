import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Pong2_0 {
	JFrame display;
	public static final int width = 500;
	public static final int height = 800;
	GamePanel panel = new GamePanel();

	public static void main(String[] args) {
		Pong2_0 pong = new Pong2_0();
		pong.setup();
	}

	Pong2_0() {
		display = new JFrame();

	}

	void setup() {
		display.add(panel);
		display.setVisible(true);
		display.setDefaultCloseOperation(display.EXIT_ON_CLOSE);
		display.getContentPane().setPreferredSize(new Dimension(width, height));
		display.pack();
		panel.StartGame();
		display.addKeyListener(panel);

	}
}
