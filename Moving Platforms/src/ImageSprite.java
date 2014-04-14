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
		
		if (url != null) {
			this.img = new ImageIcon(url).getImage();
		} else {
			this.img = null;
		}
	}
	
	public int getX() { return this.xPos; }
	
	public int getY() { return this.yPos; }
}
