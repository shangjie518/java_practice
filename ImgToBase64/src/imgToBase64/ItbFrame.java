package imgToBase64;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ItbFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void createAndShowGUI() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Base64 Encoding...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// imgFileChooser(frame);

		frame.setLayout(new FlowLayout());
		JLabel label = new JLabel("Image:");
		frame.add(label);

		JButton btnBrowser = new JButton("浏览...");
		frame.add(btnBrowser);
		btnBrowser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				imgFileChooser(frame);
			}
			
		});


		
		frame.setLocationByPlatform(isDefaultLookAndFeelDecorated());
		frame.setSize(100,100);
		frame.setVisible(true);

	}



	private static void imgFileChooser(JFrame mainFrame) {
		JFileChooser chooser = new JFileChooser();
		mainFrame.add(chooser);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(mainFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String path= chooser.getSelectedFile().getAbsolutePath();
			ToBase64 tb=new ToBase64();
			String output=tb.getEncode(path);
			System.out.println("You chose to open this file: " + path);
			System.out.println(output);
		}
	}

}
