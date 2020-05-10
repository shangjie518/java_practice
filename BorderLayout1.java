package gui.tij;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BorderLayout1 extends JFrame {

	public BorderLayout1() {
		
		add(BorderLayout.NORTH, new JButton("NORTH"));
		add(BorderLayout.SOUTH, new JButton("SOUTH"));
		add(BorderLayout.WEST, new JButton("WEST"));
		add(BorderLayout.EAST, new JButton("EAST"));
		add(BorderLayout.CENTER, new JButton("CENTER"));
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.setOpaque(true);
		jp.setVisible(true);
		//add(jp);
	
		
	}
	
	
	public static void main(String[] args) {
		Utilities.run(new BorderLayout1(), 400, 300);
	}
}
