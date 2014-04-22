import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;


public class Mob {
	
	//this will be the base class for all moving objects (possibly barring the player)
	private double xPos, yPos;
	private double centerX, centerY;
	private URL url;
	
	private double rotation;
	
	private Image img;
	
	int width, height;
	
	double vel;
	double xVel, yVel;

	public Mob(int x, int y, String imgUrl) {
		
		this.xPos = x;
		this.yPos = y;
		this.url = this.getClass().getResource(imgUrl);
		
		if (this.url != null) {
			
			this.img = new ImageIcon(this.url).getImage();
			this.centerX = this.xPos + (getWidth() / 2);
			this.centerY = this.yPos + (getHeight() / 2);
		} else {
			
			this.img = null;
			this.centerX = this.xPos;
			this.centerY = this.yPos;
		}
		
		this.rotation = 0;
		this.xVel = 0;
		this.yVel = 0;
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		
	}
	
	public void setVel(double xvel, double yvel) {
		this.xVel = xvel;
		this.yVel = yvel;
	}
	
	public void setXVel(double xVel) {
		
		this.xVel = xVel;
	}
	
	public double getXVel() { return this.xVel; }
	
	public void setYVel(double yVel) {
		this.yVel = yVel;
	}
	
	public double getYVel() { return this.xVel; }

	public void move() {
		setX(getX() + this.xVel);
		setY(getY() + this.yVel);
		
		updateCenter();
	}
	
	public void draw(Graphics2D g2d) {
		
		g2d.rotate(rotation, centerX, centerY);
		g2d.drawImage(getImage(), (int) getX(), (int) getY(), getWidth(), getHeight(), null);
		g2d.rotate(-rotation);
	}
	
	public double getX() { return this.xPos; }
	public void setX(double x) { this.xPos = x; }
	
	public double getY() { return this.yPos; }
	public void setY(double y) { this.yPos = y; }
	
	public void setPosition(double x, double y) {
		
		this.xPos = x;
		this.yPos = y;
	}
	
	public int getWidth() { return this.img.getWidth(null); }
	
	public int getHeight() { return this.img.getHeight(null); }
	
	public double getRotation() { return this.rotation; }
	public void setRotation(int rotation) { this.rotation = rotation; }
	
	public Image getImage() { return this.img; }
	
	public void updateCenter() {
		
		if (this.img != null) {
			
			this.centerX = this.xPos + (getWidth() / 2);
			this.centerY = this.yPos + (getHeight() / 2);
		} else {
			
			this.centerX = this.xPos;
			this.centerY = this.yPos;
		}
	}
	
}
