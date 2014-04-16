import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;


public class ImageSprite {
	
	private int xPos, yPos;
	
	private Image img;
	
	public ImageSprite(int x, int y, URL url) {
		
		this.xPos = x;
		this.yPos = y;
		
		if (url != null) {
			this.img = new ImageIcon(url).getImage();
		} else {
			this.img = null;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(this.img, this.xPos, this.yPos, this.getWidth(), this.getHeight(), null);
	}
	
	public int getX() { return this.xPos; }
	public void setX(int x) { this.xPos = x; }
	
	public int getY() { return this.yPos; }
	public void setY(int y) { this.yPos = y; }
	
	public int getWidth() { return this.img.getWidth(null); }
	
	public int getHeight() { return this.img.getHeight(null); }
}
