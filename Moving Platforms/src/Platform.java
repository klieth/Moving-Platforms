

public class Platform extends Mob{
	
	public final static int SHEET_WIDTH = 72;
	public final static int SHEET_HEIGHT = 9;
	
	public final static String SHEET_PATH = "/Sprites/Platform.png";
	
	public Platform(int x, int y) {
		super(x, y, new SpriteSheet(SHEET_PATH, SHEET_WIDTH, SHEET_HEIGHT));
	}

}
