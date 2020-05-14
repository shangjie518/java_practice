package gui.tij;

import java.awt.FlowLayout;
import java.lang.reflect.Constructor;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class ButtonGroups extends JFrame{
	private static String[] ids= {"Jan","Feb","Mar","Apr","May","Jun"};
	public static JPanel makePanel(Class<? extends AbstractButton>kind, String[] ids) {
		JPanel jp=new JPanel();
		String title= kind.getName();
		jp.setBorder(new TitledBorder(title));
		ButtonGroup bg=new ButtonGroup();
		for(String id: ids) {
			AbstractButton ab=new JButton("failed");
			try {
				Constructor ctor=kind.getConstructor(String.class);
				ab=(AbstractButton) ctor.newInstance(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Button creation failed");
				e.printStackTrace();
			}
			bg.add(ab);
			jp.add(ab);
		}
		return jp;
	}
	
	public ButtonGroups() {
		setLayout(new FlowLayout());
		add(makePanel(JButton.class,ids));
		add(makePanel(JRadioButton.class,ids));
		add(makePanel(JCheckBox.class,ids));
		add(makePanel(JToggleButton.class,ids));
	}
	
	public static void main(String[] args) {
		Utilities.run(new ButtonGroups(), 500, 350);
	}

}
