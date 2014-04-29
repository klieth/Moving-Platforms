import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


public class World {
	
	//This class will manage all the things in the game, and make them do their stuff
	
	public final int NUM_PLATFORMS = 6;
	public final int GAME_WIDTH, GAME_HEIGHT;
	
	public final String PLATFORM_PATH = "/Sprites/Platform.png";
	
	Platform[] platforms = new Platform[NUM_PLATFORMS];
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	Player player;
	
	public World(int GAME_WIDTH, int GAME_HEIGHT) {
		
		this.GAME_WIDTH = GAME_WIDTH;
		this.GAME_HEIGHT = GAME_HEIGHT;
		
		Random random = new Random();
		
		for (int i = 0; i < NUM_PLATFORMS; i++) {
			platforms[i] = new Platform(random.nextInt(GAME_WIDTH), random.nextInt(GAME_HEIGHT));
			
		}
		
		player = new Player(this, (int) platforms[0].getX() + 20, (int) platforms[0].getY() - 64);
	}
	
	public void draw(Graphics2D g2d) {
		
		player.draw(g2d);
		
		for (int i = 0; i < platforms.length; i++) {
			platforms[i].draw(g2d);
		}
		
		for (int j = 0; j < enemies.size(); j++) {
			enemies.get(j).draw(g2d);
		}
		
		for (int k = 0; k < bullets.size(); k++) {
			bullets.get(k).draw(g2d);
		}
		
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
		
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if ((bullet.getX() < -bullet.getWidth()) ||
					(bullet.getX() > this.GAME_WIDTH) ||
					(bullet.getY() < -bullet.getHeight()) ||
					(bullet.getY() > this.GAME_HEIGHT)) {
				bullets.remove(i);
			}
		}
	}
	
	public Player getPlayer() { return player; }
	
	public void MouseReleased(MouseEvent e) {
		
		int button = e.getButton();
		
		if (button == MouseEvent.BUTTON1) {
			
			double xDif = e.getX() - player.getX();
			double yDif = e.getY() - player.getY();
			
			double angle = Math.atan(yDif / xDif);
			
			if (xDif < 0)
				angle += Math.PI;
			
			bullets.add(new Bullet((int) getPlayer().getX(), (int) getPlayer().getY(), angle, 10));
		}

	}
}
