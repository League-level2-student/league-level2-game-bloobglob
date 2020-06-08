package gamePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	final static int MENU = 0;
	final static int GAME = 1;
	final static int FINISH = 2;
	public static int LEVEL = 1;
	Color color = Color.black;
	public static int currentState = MENU;
	Timer frameDraw = new Timer(1000/60, this);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font smallFont = new Font("Arial", Font.PLAIN, 28);
	Player player = new Player();
	ArrayList<Wall> walls = new ArrayList<Wall>();
	ArrayList<Ground> grounds = new ArrayList<Ground>();
	ArrayList<Lava> lavas = new ArrayList<Lava>();
	ObjectManager manager = new ObjectManager(player, walls, grounds, lavas);
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Platformer.WIDTH, Platformer.HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("League Platformer", 160, 100);
		g.setFont(smallFont);
		g.drawString("Press ENTER to play", 220, 200);
		g.drawString("Press SPACE for instructions", 170, 250);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(smallFont);
		g.drawString("Level: " + LEVEL, 10, 30);
		for(int i = 0;i<manager.g.size(); i++) {
			manager.g.get(i).draw(g);
		}
		for(int i = 0;i<manager.w.size(); i++) {
			manager.w.get(i).draw(g);
		}
		for(int i = 0;i<manager.l.size(); i++) {
			manager.l.get(i).draw(g);
		}
		player.draw(g);
	}
	void drawFinishState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Platformer.WIDTH, Platformer.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Congratulations!", 190, 100);
		g.setFont(smallFont);
		g.drawString("You won the game with " + manager.deaths + " deaths.", 160, 200);
		g.drawString("Press ENTER to play again", 190, 250);
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		manager.update();
		if(player.x+50>720) {
			LEVEL++;
			manager.respawn();
		}
	}
	void updateFinishState()  {
		
	}
	GamePanel() {
		frameDraw.start();
	}
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == FINISH){
		    drawFinishState(g);
		}
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == FINISH){
		    updateFinishState();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				JOptionPane.showMessageDialog(null, "Use left and right arrow keys to move and up to jump. \nTry to reach the right side of the screen, and avoid lava");
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == FINISH) {
		    	manager=new ObjectManager(player, walls, grounds, lavas);
		    	LEVEL=1;
		        currentState = MENU;
		    }
		    if(currentState == MENU) {
		    	currentState++;
		    }
		}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				player.left = true;
			}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(player.falling<6) {
				player.up = true;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX() + ", " + e.getY());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
