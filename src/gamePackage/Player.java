package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
	Rectangle hitbox = new Rectangle();
	int respawnX = 10;
	int respawnY = 360;
	int x = respawnX;
	int y = respawnY;
	double xvel = 0;
	double yvel = -1;
	void update(){
		x+=xvel;
		y-=yvel;
	}
	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 50, 50);
		hitbox.setBounds(x, y, 50, 50);
	}
}
