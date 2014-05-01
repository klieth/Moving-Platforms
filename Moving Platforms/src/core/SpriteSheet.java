package core;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class SpriteSheet {
	
	public final int ROWS;
	public final int COLUMNS;
	
	public final int WIDTH;
	public final int HEIGHT;
	
	private BufferedImage sheet;
	
	private ArrayList<ArrayList<BufferedImage>> images;
	
	public SpriteSheet(String imgUrl, int width, int height) {
		
		this.WIDTH = width;
		this.HEIGHT = height;
		ImageIcon imgIcon = new ImageIcon(getClass().getResource(imgUrl));
		this.sheet = toBufferedImage(imgIcon.getImage());
		
		this.ROWS = this.sheet.getHeight() / this.HEIGHT;
		this.COLUMNS = this.sheet.getWidth() / this.WIDTH;
		
		this.images = new ArrayList<ArrayList<BufferedImage>>();
		
		for (int i = 0; i < this.ROWS; i++) {
			
			this.images.add(new ArrayList<BufferedImage>());
			
			for (int j = 0; j < this.COLUMNS; j++) {
				
				BufferedImage image = toBufferedImage(this.sheet.getSubimage(j * this.WIDTH, i * this.COLUMNS, this.WIDTH, this.HEIGHT));
				
				boolean transparent = true;
				for (int x = 0; x < image.getWidth(); x++) {
					for (int y = 0; y < image.getHeight(); y++) {
						
						if (!isTransparent(image, x, y)) {
							transparent = false;
							break;
						}
					}
					
					if (!transparent) {
						break;
					}
				}
				
				if (!transparent) {
					this.images.get(i).add(image);
				}
			}
		}
	}
	
	public boolean isTransparent(BufferedImage img, int x, int y ) {
		  int pixel = img.getRGB(x,y);
		  if ((pixel>>24) == 0x00) {
		      return true;
		  }
		  
		  return false;
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
		
		if (frame >= this.images.get(row).size())
			return null;
		
		return this.images.get(row).get(frame);
	}
	
	public int numColumns(int row) {
		
		if (row >= this.images.size())
			return -1;
		
		return this.images.get(row).size();
	}

}
