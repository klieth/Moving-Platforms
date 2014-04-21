import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;


public class Mob extends ImageSprite {
	
	//this will be the base class for all moving objects (possibly barring the player)
	int width, height;
	double rotation;
	double vel;
	double xVel, yVel;
	Image sprite;

	public Mob(int x, int y, String imgUrl) {
		super(x, y, imgUrl);
		
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
	
	public void move() {
		setX(getX() + this.xVel);
		setY(getY() + this.yVel);
		
		updateCenter();
	}
	
	
	
}
