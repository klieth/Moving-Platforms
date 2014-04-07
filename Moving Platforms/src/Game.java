import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class Game extends JFrame {
	
	public Game() {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(156, 28, 107));
		panel.addKeyListener(new TAdapter());
		
		add(panel);
		
		setSize(920, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		setResizable(false);
	}
	
	private class TAdapter extends KeyAdapter {
		
		public void keyReleased(KeyEvent e) {
			System.out.println("Hi");
		}
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
