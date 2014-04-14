import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;


public class ImageSprite {
	
	private int xPos, yPos;
	private int dx, dy;
	
	private Image img;
	
	public ImageSprite(int x, int y, URL url) {
		
		this.xPos = x;
		this.yPos = y;
		this.dx = 0;
		this.dy = 0;
		
		if (url != null) {
			this.img = new ImageIcon(url).getImage();
		} else {
			this.img = null;
		}
	}
	
	public int getX() { return this.xPos; }
	public void setX(int x) { this.xPos = x; }
	
	public int getY() { return this.yPos; }
	public void setY(int y) { this.yPos = y; }
	
	public int getDX() { return this.dx; }
	public void setDX(int dx) { this.dx = dx; }
	
	public int getDY() { return this.dy; }
	public void setDY(int dy) { this.dy = dy; }
}
