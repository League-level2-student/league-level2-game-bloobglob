package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Level {
	ArrayList<Rectangle> collisions = new ArrayList<Rectangle>();
	void update() {
		
	}
	void draw(Graphics g) {
		drawLevel(GamePanel.LEVEL, g);
	}
	void drawLevel(int lvl, Graphics g) {
		collisions = new ArrayList<Rectangle>();
		if(lvl == 1) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 450, 720, 90);
			collisions.add(new Rectangle());
			collisions.get(1).setBounds(0, 450, 720,90);
		}
	}
}
