package gui.tij;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Utilities {

	public static void run(JFrame jf, int width, int height) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setSize(width, height);
				
				Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
				jf.setLocation(screen.width/2-width/2,screen.height/2-height/2);
				
				jf.setVisible(true);
			}
			
		});
		
	}
}
