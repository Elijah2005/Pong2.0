import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	Timer clock;
GamePanel(){
	clock = new Timer(1000 / 60, this);
	
}

public void actionPerformed(ActionEvent e) {
repaint();
	
}
void StartGame() {
	clock.start();
}
public void paintComponent(Graphics g){
	g.fillRect(160, 750, 170, 20);
}
}
