package player;

import java.awt.event.KeyEvent;

import core.Mob;
import core.SpriteSheet;
import core.World;
import world.Platform;

public class Player extends Mob {
	
	public final static int SHEET_WIDTH = 32;
	public final static int SHEET_HEIGHT = 32;
	
	public final static int FRONT_ARM_X = 7;
	public final static int FRONT_ARM_Y = 9;
	
	public final static String SPRITE_PATH = "/Sprites/PlayerSpriteSheet.png";
	
	public final static SpriteSheet SPRITE_SHEET = new SpriteSheet(SPRITE_PATH, SHEET_WIDTH, SHEET_HEIGHT);
	
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
	
	private int moveLeft = KeyEvent.VK_A;
	private int moveRight = KeyEvent.VK_D;
	private int jump = KeyEvent.VK_SPACE;
	
	private int jumpCounter;
	private int maxJumps;
	
	private World world;
	
	public Player(World world, int x, int y) {
		super(x, y, SPRITE_SHEET);
		
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
		
		if (Math.abs(getXVel()) > MAX_X_VEL)
			setXVel(MAX_X_VEL * (getXVel() / Math.abs(getXVel())));
		
		if (Math.abs(getYVel()) > MAX_Y_VEL)
			setYVel(MAX_Y_VEL * (getYVel() / Math.abs(getYVel())));
		
		if (Math.abs(getXVel()) >= this.friction)
			setXVel(getXVel() - ((getXVel() / Math.abs(getXVel())) * this.friction));
		
		if (Math.abs(getXVel()) < this.friction)
			setXVel(0);
		
		for (int i = 0; i < Math.abs(getXVel()); i++) {
			
			testCollide();
			if (getXVel() == 0) {
				break;
			}
			setX(getX() + (Math.abs(getXVel())/getXVel()));
		}
		
		for (int i = 0; i < Math.abs(getYVel()); i++) {
			
			testCollide();
			if (getYVel() == 0) {
				break;
			}
			setY(getY() + (Math.abs(getYVel())/getYVel()));
			testCollide();
		}
		
		updateState();
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
			if (getY() + getHeight() != objTop)
				return false;
		} else {
			if (getY() < objTop - getHeight() || getY() > objBottom)
				return false;
		}
		
		return true;
	}
	
	private void testCollide() {
		
		for (int i = 0; i < this.world.getPlatforms().length; i++) {
			
			if (collideMob(this.world.getPlatforms()[i]) && getYVel() > 0) {
				
				setYVel(0);
				onPlatform = true;
				this.jumpCounter = this.maxJumps;
				
				while (getY() + getHeight() > this.world.getPlatforms()[i].getY()) {
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
		
		if (key == moveLeft)
			left = true;
		
		if (key == moveRight)
			right = true;
		
		if (key == jump) {
			
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
		if (key == KeyEvent.VK_R)
		{
			setXVel(0);
			setYVel(0);
			setX(this.world.getPlatforms()[1].getX());
			setY(this.world.getPlatforms()[1].getY()- getHeight());
		}
	}
	
	@Override
	public void updateState() {
		if (getXVel() != 0 && this.onPlatform)
			setState(Mob.RUNNING);
		
		super.updateState();
	}

}
