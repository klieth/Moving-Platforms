import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Game extends JFrame {
	
	public Game() {
		
		add(new Board());
		
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

}
