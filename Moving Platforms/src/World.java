import java.util.ArrayList;

public class World {
	
	//This class will manage all the things in the game, and make them do their stuff
	public final int NUM_PLATFORMS = 6;
	Platform[] platforms = new Platform[NUM_PLATFORMS];
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	Player player = new Player();
	
	public World() {
		
	}
	
}
