

public class Player extends Mob {
	
	public final double DEFAULT_GRAV = .5;
	
	private double gravity;
	
	private World world;
	
	public Player(World world, int x, int y, String imgUrl) {
		super(x, y, imgUrl);
		
		this.world = world;
		this.gravity = DEFAULT_GRAV;
	}
	
	public void move() {
		
		setYVel(getYVel() + this.gravity);
		testCollide();
		
		super.move();
	}
	
	public double getGravity() { return this.gravity; }
	
	public void setGravity(double gravity) { this.gravity = gravity; }
	
	private boolean collideMob(Mob obj) {
		
		int objLeft, objRight, objTop, objBottom;
		
		objLeft = (int) obj.getX();
		objRight = (int) obj.getX() + obj.getWidth();
		objTop = (int) obj.getY();
		objBottom = (int) obj.getY() + obj.getHeight();
		
		if (getX() < objLeft - getWidth() || getX() > objRight)
			return false;
		
		if (getY() < objTop - getHeight() || getY() > objBottom)
			return false;
		
		return true;
	}
	
	private void testCollide() {
		
		for (int i = 0; i < this.world.platforms.length; i++) {
			
			if (collideMob(this.world.platforms[i]) && getYVel() > 0)
				setYVel(0);
		}
	}

}
