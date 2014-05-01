package player;

import core.Mob;
import core.SpriteSheet;


public class Arm extends Mob {
	
	public final static int ROW = 1;
	public final static int COLUMN = 2;
	public final static int ORIGINAL_X_CENTER = 3;
	public final static int ORIGINAL_Y_CENTER = 3;;
	
	private Mob owner;
	
	public Arm(Mob owner, int x, int y) {
		super(x, y, new SpriteSheet(Player.SPRITE_PATH, Player.SHEET_WIDTH, Player.SHEET_HEIGHT));
		
		this.owner = owner;
		
		setState(Mob.ARM);
	}
	
	@Override
	public void updateCenter() {
		
		
	}
}
