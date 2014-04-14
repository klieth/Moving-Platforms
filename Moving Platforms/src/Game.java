import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class Game extends JFrame implements KeyListener {
	
	private Timer timer;
	
	private JPanel panel;
	
	private Random random;
	
	public Game() {
		
		panel = new JPanel();
		panel.setBackground(new Color(156, 28, 107));
		
		addKeyListener(this);
		
		add(panel);
		
		
		setTitle("Moving Platforms");
		setSize(920, 480);
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
