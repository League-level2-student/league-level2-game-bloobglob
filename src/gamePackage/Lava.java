package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Lava {
	int x;
	int y;
	int width;
	int height;
	Rectangle collision = new Rectangle();
	void update() {
		
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		collision.setBounds(x, y, width, height);
	}
	void setLava(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
