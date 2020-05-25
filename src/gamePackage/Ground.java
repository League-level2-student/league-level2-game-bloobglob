package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Ground {
	int x;
	int y;
	int width;
	int height;
	Rectangle collision = new Rectangle();
	void update() {
		
	}
	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		collision.setBounds(x, y, width, height);
	}
	void setGround(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
