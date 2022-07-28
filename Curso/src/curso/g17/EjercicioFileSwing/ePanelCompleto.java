package curso.g17.EjercicioFileSwing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ePanelCompleto {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Ventana principal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setVisible(true);
		frame.setSize(400, 300);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		// Add Components
		frame.add(drawMenuBar(), BorderLayout.NORTH);
		JPanel twinPane = new JPanel();
		frame.add(twinPane, BorderLayout.CENTER);
		twinPane.setLayout(new GridLayout(1, 2));
		twinPane.add(drawForm());
		twinPane.add(drawInfo());
		frame.setVisible(true);
	} // Ends method drawFrame

	public static JMenuBar drawMenuBar() {
		// Create menu structure
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem clear = new JMenuItem("Clear");
		JMenuItem calculate = new JMenuItem("calculate");
		JMenuItem exit = new JMenuItem("Exit");
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		JMenuItem instructions = new JMenuItem("Instructions");
		// Add menu items to repective area of menu tree
		menu.add(file);
		file.add(clear);
		file.add(calculate);
		file.add(exit);
		menu.add(help);
		help.add(about);
		help.add(instructions);
		// Add ActionListener
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				MainApp app = new MainApp();
//				app.exit();
			}

		});
		// Set Return
		return menu;
	} // Ends method drawMenuBar

	public static JPanel drawForm() {
		// Set panel with layout and border
		JPanel form = new JPanel();
		form.setBorder(BorderFactory.createTitledBorder("Form"));
		form.setLayout(new BoxLayout(form, BoxLayout.PAGE_AXIS));
		// Create field and labels for form panel and add to form panel
		JLabel label1 = new JLabel("text1");
		form.add(label1);
		JTextField textfield1 = new JTextField(5);
		form.add(textfield1);
		JLabel label2 = new JLabel("text2");
		form.add(label2);
		JTextField textfield2 = new JTextField(5);
		form.add(textfield2);
		JButton calc = new JButton("calculate");
		form.add(calc);
		JTextField result = new JTextField(5);
		form.add(result);
		// Set return
		return form;
	} // Ends method drawForm

	public static JPanel drawInfo() {
		// Set Panel with layout and border
		JPanel info = new JPanel();
		info.setBorder(BorderFactory.createTitledBorder("Information"));
		// Set Return
		return info;
	} // Ends method drawInfo

	// Ends class Frame

}
