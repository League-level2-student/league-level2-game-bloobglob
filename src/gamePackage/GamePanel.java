package gamePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int FINISH = 2;
	public static int LEVEL = 1;
	int currentState = MENU;
	Timer frameDraw = new Timer(1000/60, this);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font smallFont = new Font("Arial", Font.PLAIN, 28);
	Player player = new Player();
	Level level = new Level();
	ObjectManager manager = new ObjectManager(player, level);
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
		g.setColor(Color.WHITE);
		player.draw(g);
		level.draw(g);
	}
	void drawFinishState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Platformer.WIDTH, Platformer.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Congratulations!", 190, 100);
		g.setFont(smallFont);
		g.drawString("You won the game with " + "" + " deaths.", 160, 200);
		g.drawString("Press ENTER to play again", 190, 250);
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		player.update();
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
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == FINISH) {
		        currentState = MENU;
		    }else if(true){
		        currentState++;
		    }
		} 
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
