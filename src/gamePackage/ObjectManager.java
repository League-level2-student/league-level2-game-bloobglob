package gamePackage;

import java.util.ArrayList;

public class ObjectManager {
	Player p;
	ArrayList<Ground> g = new ArrayList<Ground>();
	ArrayList<Wall> w = new ArrayList<Wall>();
	ObjectManager(Player p, ArrayList<Wall> w, ArrayList<Ground> g) {
		this.p = p;
		this.w = w;
		this.g = g;
	}
	void makeLevel(int level) {
		if(level == 1) {
			g.add(new Ground());
			g.get(0).setGround(0, 450, 720, 90);
		}
	}
	void update() {
		makeLevel(GamePanel.LEVEL);
		checkCollisions();
		p.update();
		if(p.left) {
			p.xvel = -4;
		}else if(!p.right){
			p.xvel = 0;
		}
		if(p.right) {
			p.xvel = 4;
		}else if(!p.left){
			p.xvel = 0;
		}
		if(p.up) {
			if(p.falling<6) {
				p.yvel = 12;
			}
		}
	}
	void checkCollisions() {
		p.falling++;
		for(int i = 0; i < g.size(); i++) {
			if(g.get(i).collision.intersects(p.hitbox)) {
				p.y = g.get(i).y-50;
				p.yvel = 0;
				p.falling = 0;
			}
		}
	}
}
