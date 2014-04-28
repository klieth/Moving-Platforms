import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Game extends JFrame {
	
	public final int GAME_WIDTH = 1080;
	public final int GAME_HEIGHT = 720;
	
	private Board board;
	
	public Game() {
		
		board = new Board(GAME_WIDTH, GAME_HEIGHT);
		add(board);
		
		setTitle("Moving Platforms");
		setSize(GAME_WIDTH, GAME_HEIGHT);
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

}
