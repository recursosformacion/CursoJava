package curso.g17.swing30Dialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class PrOptionPane {

	static final String TITULO = "Demo de JOptionPane";
	static JFrame ventana;

	public static void main(String[] args) {
		ventana = new JFrame(TITULO);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setSize(300, 200);

		JRadioButton r1 = new JRadioButton("Mensaje de informacion");
		r1.setActionCommand("INFORMATION");

		JRadioButton r2 = new JRadioButton("Mensaje de aviso");
		r2.setActionCommand("WARNING");

		JRadioButton r3 = new JRadioButton("Mensaje de error");
		r3.setActionCommand("ERROR");

		JRadioButton r4 = new JRadioButton("Mensaje de interrogacion");
		r4.setActionCommand("QUESTION");

		// add event handler
		MyItemListener myItemListener = new MyItemListener(ventana);
		r1.addItemListener(myItemListener);
		r2.addItemListener(myItemListener);
		r3.addItemListener(myItemListener);
		r4.addItemListener(myItemListener);

		// add radio buttons to a ButtonGroup
		final ButtonGroup group = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		group.add(r3);
		group.add(r4);

		// Frame setting

		Container pane = ventana.getContentPane();
		pane.setLayout(new GridLayout(0, 1));
		pane.add(new JLabel("Indique tipo de mensaje:"));
		pane.add(r1);
		pane.add(r2);
		pane.add(r3);
		pane.add(r4);
		ventana.setVisible(true);

		JOptionPane.showConfirmDialog(null, "Seleccione algo", "Seleccione", JOptionPane.YES_NO_OPTION);

		

		// Presentar mensaje de aviso con opciones OK y CANCEL
		// Titulo Atencion, y el mensaje "Pulse OK para continuar"
		Object[] options = { "OK", "CANCEL" };
		JOptionPane.showOptionDialog(null, "Pulse OK para continuar", "Atencion", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, options, options[0]);

		int seleccion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Problema normal",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Continuar", "Reiniciar", "Cancelar" }, // cambiar
																		// nombres
				"Continuar"); // seleccion por defecto

		if (seleccion != -1)
			System.out.println("Se ha seleccionado " + (seleccion + 1));
		
		//Abrir entrada para una String
		String inputValue = JOptionPane.showInputDialog("Indique su nombre");
		
		
		//seleccion con entrada desplegable
		Object[] possibleValues = { "Uno", "Dos", "Tres" };
		Object selectedValue = JOptionPane.showInputDialog(null,
				"Elegir", 
				"Entrada", 
				JOptionPane.INFORMATION_MESSAGE,
				null,
				possibleValues,
				possibleValues[1]);
	}
}

// implement ItemListener interface
class MyItemListener implements ItemListener {

	JFrame parent;

	MyItemListener(JFrame parent) {
		this.parent = parent;
	}

	public void itemStateChanged(ItemEvent ev) {
		boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
		AbstractButton button = (AbstractButton) ev.getItemSelectable();
		String command = button.getActionCommand();
		if (selected) {
			int messageType = -1;
			String message = "";
			if (command.equals("INFORMATION")) {
				messageType = JOptionPane.INFORMATION_MESSAGE;
				message = "Mensaje de informacion";
			} else if (command.equals("WARNING")) {
				messageType = JOptionPane.WARNING_MESSAGE;
				message = "Mensaje de aviso";
			} else if (command.equals("ERROR")) {
				messageType = JOptionPane.ERROR_MESSAGE;
				message = "Mensaje de error";
			} else if (command.equals("QUESTION")) {
				messageType = JOptionPane.QUESTION_MESSAGE;
				message = "Mensaje de interrogacion";
			}
			// show message
			JOptionPane.showMessageDialog(parent, message, "Mensaje de dialogo", messageType);
		}
	}
}