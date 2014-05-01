package menu;
import java.awt.Graphics2D;
import java.awt.Image;

import core.Mob;
import core.SpriteSheet;


public class Button extends Mob {
	
	private boolean selected = false;
	
	private Image buttonImg;
	private Image selectedBtnImage;
	
	public Button(int x, int y, String path, int spriteWidth, int spriteHeight) {
		super(x, y, new SpriteSheet(path, spriteWidth, spriteHeight));
	}
	
	@Override
	public int getWidth() {
		
		if (this.selected) {
			return this.selectedBtnImage.getWidth(null);
		} else {
			return this.buttonImg.getWidth(null);
		}
	}
	
	@Override
	public int getHeight() {
		
		if (this.selected) {
			return this.selectedBtnImage.getHeight(null);
		} else {
			return this.buttonImg.getHeight(null);
		}
	}
	
	public void setSelected(boolean state) { this.selected = state; }
	
	@Override
	public void draw(Graphics2D g2d) {
		
		if (this.selected) {
			g2d.drawImage(this.selectedBtnImage, (int) getX(), (int) getY(), null);
		} else {
			g2d.drawImage(this.buttonImg, (int) getX(), (int) getY(), null);
		}
	}
}
