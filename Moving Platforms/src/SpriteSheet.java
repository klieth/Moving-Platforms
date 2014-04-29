import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class SpriteSheet {
	
	public final int ROWS;
	public final int COLUMNS;
	
	public final int WIDTH;
	public final int HEIGHT;
	
	private BufferedImage sheet;
	
	private Image[][] images;
	
	public SpriteSheet(String imgUrl, int width, int height) {
		
		this.WIDTH = width;
		this.HEIGHT = height;
		ImageIcon imgIcon = new ImageIcon(getClass().getResource(imgUrl));
		this.sheet = toBufferedImage(imgIcon.getImage());
		
		this.ROWS = this.sheet.getHeight() / this.HEIGHT;
		this.COLUMNS = this.sheet.getWidth() / this.WIDTH;
		
		this.images = new Image[this.ROWS][this.COLUMNS];
		
		for (int i = 0; i < this.ROWS; i++) {
			for (int j = 0; j < this.COLUMNS; j++) {
				
				this.images[i][j] = this.sheet.getSubimage(j * this.WIDTH, i * this.COLUMNS, this.WIDTH, this.HEIGHT);
			}
		}
	}
	
	public static BufferedImage toBufferedImage(Image img) {
	   
		if (img instanceof BufferedImage)
	        return (BufferedImage) img;
	    
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    return bimage;
	}
	
	public Image getImage(int row, int frame) {
		
		if (frame >= COLUMNS)
			return null;
		
		return this.images[row][frame];
	}

}
