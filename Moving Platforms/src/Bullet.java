

public class Bullet extends Mob{
	
	public final static int SHEET_WIDTH = 5;
	public final static int SHEET_HEIGHT = 5;
	
	public final static String BULLET_PATH = "/Sprites/Bullet.png";

	public Bullet(int x, int y, double angle, double vel) {
		super(x, y, new SpriteSheet(BULLET_PATH, SHEET_WIDTH, SHEET_HEIGHT));

		setRotation(angle);
		setXVel(vel * Math.cos(angle));
		setYVel(vel * Math.sin(angle));

	}

}
