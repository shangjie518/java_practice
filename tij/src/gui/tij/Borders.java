package gui.tij;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.StrokeBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalBorders;

public class Borders extends JFrame {

	public JPanel showBorder(Border b) {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		String title = b.getClass().getName();
		JLabel jl = new JLabel(title.substring(title.lastIndexOf(".") + 1));
		jl.setHorizontalAlignment(JLabel.CENTER);
		jp.add(jl, BorderLayout.CENTER);
		jp.setBorder(b);
		return jp;
	}

	public Borders() {
		setLayout(new GridLayout(2, 4));
		add(showBorder(new TitledBorder("TitleBorder")));
		add(showBorder(new EtchedBorder()));
		add(showBorder(new StrokeBorder(new BasicStroke())));
		add(showBorder(new MatteBorder(5, 5, 30, 30, Color.GREEN)));
		add(showBorder(new BevelBorder(BevelBorder.RAISED)));
		add(showBorder(new SoftBevelBorder(BevelBorder.LOWERED)));
		add(showBorder(new CompoundBorder(new EtchedBorder(), new LineBorder(Color.RED))));
	}

	public static void main(String[] args) {
		Utilities.run(new Borders(), 500, 400);
		
	}
}
