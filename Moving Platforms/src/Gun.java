
public class Gun {
	
	private int bulletDmg;
	private Mob owner;
	
	public Gun(Mob owner) {
		
		this.owner = owner;
	}
	
	public Mob getOwner() { return this.owner; }
}
