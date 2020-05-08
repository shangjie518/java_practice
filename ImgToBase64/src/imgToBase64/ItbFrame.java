package imgToBase64;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ItbFrame extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel label;
	JButton openButton;
	JTextArea outTextArea;
	JFileChooser fc;

	public ItbFrame() {
        super(new BorderLayout());
		outTextArea = new JTextArea(5, 50);
		outTextArea.setMargin(new Insets(5, 5, 5, 5));
		outTextArea.setEditable(false);
		outTextArea.setLineWrap(true);
		JScrollPane logScrollPane = new JScrollPane(outTextArea);

		// Create a file chooser
		fc = new JFileChooser();

		openButton = new JButton("Open a File...");
		openButton.addActionListener(this);
		
		label= new JLabel("Images:");


		// For layout purposes, put the buttons in a separate panel
		JPanel buttonPanel = new JPanel(); // use FlowLayout
		buttonPanel.add(label);
		buttonPanel.add(openButton);

		// Add the buttons and the log to this panel.
		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScrollPane, BorderLayout.CENTER);
	}

	public static void createAndShowGUI() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Base64 Encoding...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// imgFileChooser(frame);



		  //Add content to the window.
        frame.add(new ItbFrame());

        //Display the window.
        frame.pack();
        frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openButton) {

			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
			fc.setFileFilter(filter);

			int returnVal = fc.showOpenDialog(ItbFrame.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String path = fc.getSelectedFile().getAbsolutePath();
				ToBase64 tb = new ToBase64();
				outTextArea.append(tb.getEncode(path));
			} else {
				outTextArea.append("");
			}
		}
	}
}
