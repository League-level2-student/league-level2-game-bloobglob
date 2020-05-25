package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
	Rectangle hitbox = new Rectangle();
	int respawnX = 10;
	int respawnY = 240;
	int x = respawnX;
	int y = respawnY;
	int yvel = -1;
	int xvel = 0;
	int falling;
	boolean left = false;
	boolean right = false;
	boolean up = false;
	void update(){
		y-=yvel;
		yvel--;
		x+=xvel;
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 50, 50);
		hitbox.setBounds(x, y, 50, 50);
	}
}
