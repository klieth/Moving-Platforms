package world;
import core.Mob;
import core.SpriteSheet;



public class Platform extends Mob{
	
	public final static int SHEET_WIDTH = 100;
	public final static int SHEET_HEIGHT = 9;
	
	public final static String SHEET_PATH = "/Sprites/Platform.png";
	
	public final static SpriteSheet SPRITE_SHEET = new SpriteSheet(SHEET_PATH, SHEET_WIDTH, SHEET_HEIGHT);
	
	public Platform(int x, int y) {
		super(x, y, SPRITE_SHEET);
	}

}
