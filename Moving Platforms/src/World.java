import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class World {
	
	//This class will manage all the things in the game, and make them do their stuff
	public final int NUM_PLATFORMS = 6;
	Platform[] platforms = new Platform[NUM_PLATFORMS];
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	Player player = new Player();
	
	Mob testMob = new Mob(300, 300, "/Sprites/Joffrey.png");
	
	public World() {
		
	}
	
	public void draw(Graphics g) {
		
		testMob.draw((Graphics2D) g);
	}
}
