package gui.tij;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Borders extends JFrame{

	public JPanel showBorder(Border b) {
		JPanel jp= new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(new JLabel("test"), BorderLayout.CENTER );
		jp.setBorder(b);
		return jp;
	}
	
	
	public Borders() {
		setLayout(new GridLayout(2,4));
		add(showBorder(new TitledBorder("TitleBorder")));
	}
	
	public static void main(String[] args) {
		Utilities.run(new Borders(), 500, 400);
	}
}
