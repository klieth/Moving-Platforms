import java.awt.Image;


public class Bullet extends Mob{

	public Bullet(int x, int y, double angle, double vel, String imgUrl) {
		super(x, y, imgUrl);

		setRotation(angle);
		setXVel(vel * Math.cos(angle));
		setYVel(vel * Math.sin(angle));
	}

}
