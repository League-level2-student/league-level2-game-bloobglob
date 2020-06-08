package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player {	
	int respawnX = 0;
	int respawnY = 400;
	int x = respawnX;
	int y = respawnY;
	double yvel = -0.5;
	int xvel = 0;
	Rectangle hitbox = new Rectangle();
	int falling = 0;
	boolean left = false;
	boolean right = false;
	boolean up = false;
	Player(){
	}
	void update(){
		y-=yvel;
		y=(int)y;
		yvel-=0.5;
		x+=xvel;
	}
	void draw(Graphics g) {
		hitbox.setBounds(x, y, 50, 50);
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 50, 50);
		g.setColor(Color.RED);
		g.fillRect(x, y+5, 50, 5);
		g.setColor(Color.getHSBColor(44, 91, 53));
		g.fillRect(x+5, y+15, 40, 15);
		g.setColor(Color.BLACK);
		g.fillRect(x+10, y+18, 10, 7);
		g.fillRect(x+30, y+18, 10, 7);
	}
}
