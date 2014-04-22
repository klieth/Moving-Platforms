

public class Player extends Mob {
	
	private double gravity = .5;
	
	public Player(World world, int x, int y, String imgUrl) {
		super(x, y, imgUrl);
		// TODO Auto-generated constructor stub
	}
	
	public void move() {
		setYVel(getYVel() - gravity);
		
		super.move();
	}
	
	public double getGravity() { return this.gravity; }
	
	public void setGravity(double gravity) { this.gravity = gravity; }

}
