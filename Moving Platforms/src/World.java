import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class World {
	
	//This class will manage all the things in the game, and make them do their stuff
	
	public final int NUM_PLATFORMS = 6;
	
	public final String PLATFORM_PATH = "/Sprites/Platform.png";
	
	Platform[] platforms = new Platform[NUM_PLATFORMS];
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	Player player = new Player(this, 0, 0, "Sprites/Joffrey.png");
	
	public World() {
		
		for (int i = 0; i < NUM_PLATFORMS; i++) {
			platforms[i] = new Platform(i * 80, 100, PLATFORM_PATH);
		}
	}
	
	public void draw(Graphics2D g2d) {
		
		for (int i = 0; i < platforms.length; i++) {
			platforms[i].draw(g2d);
		}
		
		for (int j = 0; j < enemies.size(); j++) {
			enemies.get(j).draw(g2d);
		}
		
		for (int k = 0; k < bullets.size(); k++) {
			bullets.get(k).draw(g2d);
		}
		
		player.draw(g2d);
	}
	
	public void move() {

		for (int i = 0; i < platforms.length; i++) {
			platforms[i].move();
		}
		
		for (int j = 0; j < enemies.size(); j++) {
			enemies.get(j).move();
		}
		
		for (int k = 0; k < bullets.size(); k++) {
			bullets.get(k).move();
		}
		
		player.move();
	}
}
