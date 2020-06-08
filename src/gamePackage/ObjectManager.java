package gamePackage;

import java.util.ArrayList;

public class ObjectManager {
	Player p;
	int deaths = 0;
	ArrayList<Ground> g = new ArrayList<Ground>();
	ArrayList<Wall> w = new ArrayList<Wall>();
	ArrayList<Lava> l = new ArrayList<Lava>();
	ObjectManager(Player p, ArrayList<Wall> w, ArrayList<Ground> g, ArrayList<Lava> l) {
		this.p = p;
		this.w = w;
		this.g = g;
		this.l = l;
	}
	void makeLevel(int level) {
			g.add(new Ground());
			g.get(0).setGround(0, 450, 720, 90);
		if(level == 1) {
			
		}else if(level == 2) {
			g.add(new Ground());
			g.get(1).setGround(240, 420, 240, 30);
			w.add(new Wall());
			w.get(0).setWall(234, 435, 10, 15);
			w.add(new Wall());
			w.get(1).setWall(476, 435, 10, 15);
			l.add(new Lava());
			l.get(0).setLava(270, 340, 30, 80);	
			l.add(new Lava());
			l.get(1).setLava(420, 340, 30, 80);
		}else if(level == 3) {
			l.add(new Lava());
			l.get(0).setLava(125, 370, 30, 80);
			l.add(new Lava());
			l.get(1).setLava(585, 370, 30, 80);
			l.add(new Lava());
			l.get(2).setLava(330, 395, 60, 80);
		}else if(level == 4) {
			l.add(new Lava());
			l.get(0).setLava(100, 370, 30, 80);
			l.add(new Lava());
			l.get(1).setLava(610, 370, 30, 80);
			l.add(new Lava());
			l.get(2).setLava(205, 370, 30, 80);
			l.add(new Lava());
			l.get(3).setLava(505, 370, 30, 80);
			l.add(new Lava());
			l.get(4).setLava(315, 449, 90, 80);
		}else if(level == 5) {
			l.add(new Lava());
			l.get(0).setLava(100, 370, 30, 80);
			l.add(new Lava());
			l.get(1).setLava(200, 370, 30, 80);
			l.add(new Lava());
			l.get(2).setLava(315, 449, 90, 80);
			l.add(new Lava());
			l.get(3).setLava(480, 370, 30, 80);
			l.add(new Lava());
			l.get(4).setLava(640, 295, 30, 80);
			g.add(new Ground());
			g.get(1).setGround(620, 375, 100, 100);
			w.add(new Wall());
			w.get(0).setWall(614, 385, 10, 75);
		}else if(level == 6) {
			l.add(new Lava());
			l.get(0).setLava(50, 400, 450, 50);
			g.add(new Ground());
			g.get(1).setGround(50, 300, 100, 50);
			g.add(new Ground());
			g.get(2).setGround(225, 250, 100, 50);
			g.add(new Ground());
			g.get(3).setGround(400, 300, 100, 50);
			l.add(new Lava());
			l.get(1).setLava(560, 449, 90, 80);
			w.add(new Wall());
			w.get(0).setWall(44, 305, 6, 45);
			w.add(new Wall());
			w.get(1).setWall(150, 315, 6, 35);
			w.add(new Wall());
			w.get(2).setWall(219, 265, 6, 35);
			w.add(new Wall());
			w.get(3).setWall(325, 265, 6, 35);
			w.add(new Wall());
			w.get(4).setWall(394, 315, 6, 35);
			w.add(new Wall());
			w.get(5).setWall(500, 315, 6, 35);
		}else if (level == 7) {
			GamePanel.currentState++;
		}
	}
	void update() {
		makeLevel(GamePanel.LEVEL);
		checkCollisions();
		p.update();
		if(p.left) {
			p.xvel = -3;
		}else if(!p.right){
			p.xvel = 0;
		}
		if(p.right) {
			p.xvel = 3;
		}else if(!p.left){
			p.xvel = 0;
		}
		if(p.up) {
			if(p.falling<6) {
				p.yvel = 10;
			}
		}
	}
	void checkCollisions() {
		p.falling++;
		for(int i = 0; i < g.size(); i++) {
			if(g.get(i).collision.intersects(p.hitbox)) {
				if(p.y<=g.get(i).y) {
					p.y = g.get(i).y-50;
					p.yvel = 0;
					p.falling = 0;
				}else {
					p.y = g.get(i).y+g.get(i).height;
					p.yvel = 0;
				}
			}
		}
		for(int i = 0; i < w.size(); i++) {
			if(w.get(i).collision.intersects(p.hitbox)) {
				if(p.x<=w.get(i).x) {
					p.x = w.get(i).x-50;
				}else {
					p.x = w.get(i).x+w.get(i).width;
				}
			}
		}
		for(int i = 0; i < l.size(); i++) {
			if(l.get(i).collision.intersects(p.hitbox)) {
				deaths++;
				respawn();
			}
		}
	}
	void respawn() {
		g = new ArrayList<Ground>();
		w = new ArrayList<Wall>();
		l = new ArrayList<Lava>();
		p.x = p.respawnX;
		p.y = p.respawnY;
	}
}
