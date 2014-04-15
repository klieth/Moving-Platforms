import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


public class Mob {
	
	//this will be the base class for all moving objects (possibly barring the player)
	int x, y;
	int width, height;
	double rotation;
	double vel;
	double xvel, yvel;
	Image sprite;

	public Mob(int x, int y, Image sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.width = sprite.getWidth(null);
		this.height = sprite.getHeight(null);
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		
	}
	
	public void setVel(double xvel, double yvel) {
		this.xvel = xvel;
		this.yvel = yvel;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		x += xvel;
		y += yvel;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.translate(x, y);
		g2d.rotate(rotation);
		g2d.drawImage(sprite, 0, 0, width, height, null, null);
		g2d.rotate(-rotation);
		g2d.translate(0, 0);
	}
	
}
