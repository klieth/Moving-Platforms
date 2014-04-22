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
	
	public Board() {
		
		this.world = new World();
		this.timer = new Timer(20, this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		this.world.draw((Graphics2D) g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.world.move();
		repaint();
	}
}
