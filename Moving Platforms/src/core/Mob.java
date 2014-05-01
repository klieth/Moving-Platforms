package core;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


// base class for all moving objects

public class Mob implements ActionListener {
	
	// row #'s on the sprite sheet for different animations
	public final static int STANDING = -1;
	public final static int RUNNING = 0;
	public final static int ARM = 1;
	
	public final static int ANIMATION_TIME = 80;
	
	private boolean movingLeft;
	
	private double xPos, yPos;
	private double centerX, centerY;
	private double xVel, yVel;
	
	private double rotation;
	
	private Image img;
	
	private int width;
	private int height;
	private int frame;
	private int state;
	
	private SpriteSheet spriteSheet;
	
	private Timer animationTimer;
	
	public Mob(int x, int y, SpriteSheet sheet) {
		
		this.xPos = x;
		this.yPos = y;
		this.spriteSheet = sheet;
		
		updateImage();
		this.centerX = this.xPos + (getWidth() / 2);
		this.centerY = this.yPos + (getHeight() / 2);
		setSize(img.getWidth(null) * 2, img.getHeight(null) * 2);
		
		this.animationTimer = new Timer(ANIMATION_TIME, this);
		this.animationTimer.start();
		
		this.rotation = 0;
		this.xVel = 0;
		this.yVel = 0;
		this.state = STANDING;
		this.movingLeft = false;
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		
	}
	
	public void setVel(double xVel, double yVel) {
		this.xVel = xVel;
		this.yVel = yVel;
	}
	
	public void setXVel(double xVel) {
		
		this.xVel = xVel;
	}
	
	public double getXVel() { return this.xVel; }
	
	public void setYVel(double yVel) {
		
		this.yVel = yVel;
	}
	
	public double getYVel() { return this.yVel; }

	public void move() {
		
		setX(getX() + getXVel());
		setY(getY() + getYVel());
		
		updateCenter();
		updateState();
	}
	
	public void draw(Graphics2D g2d) {
		
		g2d.rotate(this.rotation, this.centerX, this.centerY);
		if (this.movingLeft) {
			g2d.drawImage(getImage(), (int) getX() + getWidth(), (int) getY(), (int) getX(), (int) getY() + getHeight(), 0, 0, this.img.getWidth(null), this.img.getHeight(null), null);
		} else {
			g2d.drawImage(getImage(), (int) getX(), (int) getY(), getWidth(), getHeight(), null);
		}
		g2d.rotate(-this.rotation, this.centerX, this.centerY);
	}
	
	public double getX() { return this.xPos; }
	public void setX(double x) { this.xPos = x; }
	
	public double getY() { return this.yPos; }
	public void setY(double y) { this.yPos = y; }
	
	public void setPosition(double x, double y) {
		
		this.xPos = x;
		this.yPos = y;
	}
	
	public int getWidth() { return this.width; }
	
	public int getHeight() { return this.height; }
	
	public double getRotation() { return this.rotation; }
	public void setRotation(double rotation) { this.rotation = rotation; }
	
	public Image getImage() { return this.img; }
	
	public int getState() { return this.state; }
	public void setState(int state) { this.state = state; }
	
	public int getCenterX() { return (int) this.centerX; }
	public void setCenterX(int x) { this.centerX = x; }
	
	public int getCenterY() { return (int) this.centerY; }
	public void setCenterY(int y) { this.centerY = y; }
	
	public void updateCenter() {
		
		if (this.img != null) {
			
			this.centerX = this.xPos + (getWidth() / 2);
			this.centerY = this.yPos + (getHeight() / 2);
		} else {
			
			this.centerX = this.xPos;
			this.centerY = this.yPos;
		}
	}
	
	public void updateState() {
		
		if (getXVel() < 0)
			this.movingLeft = true;
		
		if (getXVel() > 0)
			this.movingLeft = false;
		
		if (getXVel() == 0 && getYVel() == 0)
			state = STANDING;
	}
	
	public void updateImage() {
		
		if (this.state == STANDING) {
			
			this.img = this.spriteSheet.getImage(0, 0);
			
		} else {
			this.frame += 1;
			
			if (this.frame >= this.spriteSheet.numColumns(this.state))
				this.frame = 0;
			
			this.img = this.spriteSheet.getImage(state, this.frame);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateImage();
	}
}
