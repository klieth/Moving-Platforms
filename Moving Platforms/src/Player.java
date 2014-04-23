import java.awt.event.KeyEvent;



public class Player extends Mob {
	
	public final double DEFAULT_FRICTION = .5;
	public final double DEFAULT_GRAV = .5;
	public final int DEFAULT_NUM_JUMPS = 5;
	
	public final int MAX_X_VEL = 7;
	public final int MAX_Y_VEL = 30;
	
	private boolean left = false;
	private boolean right = false;
	private boolean onPlatform = false;
	
	private double friction;
	private double gravity;
	
	private int jumpCounter;
	private int maxJumps;
	
	private World world;
	
	public Player(World world, int x, int y, String imgUrl) {
		super(x, y, imgUrl);
		
		this.world = world;
		this.gravity = DEFAULT_GRAV;
		this.friction = DEFAULT_FRICTION;
		this.jumpCounter = 0;
		this.maxJumps = DEFAULT_NUM_JUMPS;
	}
	
	public void move() {
		
		if (left && !right)
			setXVel(getXVel() - 1);
		
		if (!left && right)
			setXVel(getXVel() + 1);
		
		setYVel(getYVel() + this.gravity);
		testCollide();
		
		if (Math.abs(getXVel()) > MAX_X_VEL)
			setXVel(MAX_X_VEL * (getXVel() / Math.abs(getXVel())));
		
		if (Math.abs(getYVel()) > MAX_Y_VEL)
			setYVel(MAX_Y_VEL * (getYVel() / Math.abs(getYVel())));
		
		if (onPlatform && Math.abs(getXVel()) >= this.friction)
			setXVel(getXVel() - ((getXVel() / Math.abs(getXVel())) * this.friction));
		
		if (onPlatform && Math.abs(getXVel()) < this.friction)
			setXVel(0);
		
		super.move();
	}
	
	public double getGravity() { return this.gravity; }
	
	public void setGravity(double gravity) { this.gravity = gravity; }
	
	public double getFriction() { return this.friction; }
	
	public void setFriction(double friction) { this.friction = friction; }
	
	private boolean collideMob(Mob obj) {
		
		int objLeft, objRight, objTop, objBottom;
		
		objLeft = (int) obj.getX();
		objRight = (int) obj.getX() + obj.getWidth();
		objTop = (int) obj.getY();
		objBottom = (int) obj.getY() + obj.getHeight();
		
		if (getX() < objLeft - getWidth() || getX() > objRight)
			return false;
		
		// CHANGE HARDCODED STUFF HERE //
		if (obj instanceof Platform) {
			if (getY() < objTop - getHeight() || getY() + 59 > objBottom)
				return false;
		} else {
			if (getY() < objTop - getHeight() || getY() > objBottom)
				return false;
		}
		
		return true;
	}
	
	private void testCollide() {
		
		for (int i = 0; i < this.world.platforms.length; i++) {
			
			if (collideMob(this.world.platforms[i]) && getYVel() > 0) {
				
				setYVel(0);
				onPlatform = true;
				this.jumpCounter = this.maxJumps;
				
				while (getY() + getHeight() > this.world.platforms[i].getY()) {
					setY(getY() - 1);
				}
				
				break;
			} else {
				
				onPlatform = false;
			}
		}
	}
	
	public void KeyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_A)
			left = true;
		
		if (key == KeyEvent.VK_D)
			right = true;
		
		if (key == KeyEvent.VK_SPACE) {
			
			if (this.jumpCounter > 0) {
				setYVel(-10);
				this.jumpCounter -= 1;
			}
		}
	}
	
	public void KeyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_A)
			left = false;
		
		if (key == KeyEvent.VK_D)
			right = false;
	}

}
