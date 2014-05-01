package menu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;


public class TitleScreen extends JPanel {
	
	private ArrayList<Button> buttons;
	
	public TitleScreen() {
		
		buttons = new ArrayList<Button>();
	}
	
	private class MouseInput implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) { }

		@Override
		public void mouseMoved(MouseEvent e) {
			
			int x = e.getX();
			int y = e.getY();
			
			for (int i = 0; i < buttons.size(); i++) {
				
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
