import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class SpriteSheet {
	
	public final int ROWS;
	public final int COLUMNS;
	
	public final int WIDTH;
	public final int HEIGHT;
	
	private BufferedImage sheet;
	
	public SpriteSheet(String imgUrl, int rows, int columns, int width, int height) {
		
		this.ROWS = rows;
		this.COLUMNS = columns;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.sheet = (BufferedImage) new ImageIcon(imgUrl).getImage();
	}
	
	public Image getRunning(int frame) {
		
		if (frame >= COLUMNS)
			return null;
		
		return this.sheet.getSubimage(WIDTH * frame, 0, WIDTH, HEIGHT);
	}

}
