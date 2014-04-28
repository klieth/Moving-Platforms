import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

// Where the drawing shall be done

public class Board extends JPanel implements ActionListener {
	
	private World world;
	
	private Timer timer;
	
	public Board(int GAME_WIDTH, int GAME_HEIGHT) {
		
		this.world = new World(GAME_WIDTH, GAME_HEIGHT);
		
		addKeyListener(new InputListener());
		addMouseListener(new MouseInput());
		
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
	
	private class InputListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
			getWorld().getPlayer().KeyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			getWorld().getPlayer().KeyReleased(e);
		}

		@Override
		public void keyTyped(KeyEvent e) { }
		
	}
	
	private class MouseInput implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mousePressed(MouseEvent e) { }

		@Override
		public void mouseReleased(MouseEvent e) {
			
			getWorld().MouseReleased(e);
		}

		@Override
		public void mouseEntered(MouseEvent e) { }

		@Override
		public void mouseExited(MouseEvent e) { }
		
	}
}
