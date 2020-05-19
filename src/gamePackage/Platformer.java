package gamePackage;

import javax.swing.JFrame;

public class Platformer {
	GamePanel gamePanel = new GamePanel();
	JFrame frame;
	public static final int WIDTH = 720;
	public static final int HEIGHT = 540;
	Platformer(){
		frame = new JFrame();
		frame.addKeyListener(gamePanel);
	}
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Platformer platformer = new Platformer();
		platformer.setup();
	}
}
