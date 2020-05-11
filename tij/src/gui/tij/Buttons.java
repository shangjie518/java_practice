package gui.tij;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;

public class Buttons extends JFrame{

	private JButton jb=new JButton("JButton");
	private BasicArrowButton
		up = new BasicArrowButton(BasicArrowButton.NORTH),
		down =new BasicArrowButton(BasicArrowButton.SOUTH),
		left = new BasicArrowButton(BasicArrowButton.WEST),
		right = new BasicArrowButton(BasicArrowButton.EAST);
	public Buttons() {
		setLayout(new FlowLayout());
		add(jb);
		add(new JToggleButton("JToggleButton"));
		add(new JCheckBox("JCheckBox"));
		add(new JRadioButton("JRadioButton"));
		JPanel jp= new JPanel();
		jp.setBorder(new TitledBorder("this is panel title"));
		jp.add(up);
		jp.add(down);
		jp.add(left);
		jp.add(right);
		add(jp);
	}
	
	public static void main(String[] args) {
		Utilities.run(new Buttons(), 400, 500);
	}
}
