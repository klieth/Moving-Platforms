import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Game extends JFrame {
	
	private Board board;
	
	public Game() {
		
		board = new Board();
		add(board);
		
		addKeyListener(new InputListener());
		addMouseListener(new MouseInput());
		
		setTitle("Moving Platforms");
		setSize(620, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Game game = new Game();
				game.setVisible(true);
			}
		});

	}
	
	private class InputListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
			board.getWorld().getPlayer().KeyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			board.getWorld().getPlayer().KeyReleased(e);
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
			
			board.getWorld().MouseReleased(e);
		}

		@Override
		public void mouseEntered(MouseEvent e) { }

		@Override
		public void mouseExited(MouseEvent e) { }
		
	}

}
