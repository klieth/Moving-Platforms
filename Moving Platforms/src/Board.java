import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

// Where the drawing shall be done

public class Board extends JPanel implements ActionListener {
	
	private World world;
	
	private Timer timer;
	
	public Board(int GAME_WIDTH, int GAME_HEIGHT) {
		
		this.world = new World(GAME_WIDTH, GAME_HEIGHT);
		this.timer = new Timer(20, this);
		this.timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		this.world.draw((Graphics2D) g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.world.move();
		repaint();
	}
	
	public World getWorld() { return this.world; }
}
