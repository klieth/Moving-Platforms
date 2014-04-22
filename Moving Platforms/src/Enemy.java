// Standard enemy class. Can base types of enemies off this class

public class Enemy extends Mob {
	
	private int health; // each enemy type sets health in own constructor
	
	public Enemy(int x, int y, String imgUrl) {
		super(x, y, imgUrl);
	}
	
	public void update() {
		
		/* if (collideWithBullet)
		 * 		health -= bulletDamage
		 */
		
		if (this.health <= 0) {
			// die/explode/awesome death animation
		}
		 
	}
	
	// Create pathing system?
}
