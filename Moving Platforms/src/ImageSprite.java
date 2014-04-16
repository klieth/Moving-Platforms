import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;


public class ImageSprite {
	
	private double xPos, yPos;
	private double centerX, centerY;
	
	private int rotation;
	
	private Image img;
	
	public ImageSprite(int x, int y, URL url) {
		
		this.xPos = x;
		this.yPos = y;
		
		if (url != null) {
			
			this.img = new ImageIcon(url).getImage();
			this.centerX = this.xPos + (getWidth() / 2);
			this.centerY = this.yPos + (getHeight() / 2);
		} else {
			
			this.img = null;
			this.centerX = this.xPos;
			this.centerY = this.yPos;
		}
		
		this.rotation = 0;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.translate(centerX, centerY);
		g2d.rotate(rotation);
		g2d.drawImage(this.img, (int)-this.centerX, (int)-this.centerY, getWidth(), getHeight(), null, null);
		g2d.rotate(-rotation);
		g2d.translate(0, 0);
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
	
	public int getRotation() { return this.rotation; }
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
