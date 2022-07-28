package curso.g17.layouts;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PrGridBagLayout {

	public static void main(String args[]) {

		JFrame ventana = new JFrame("Ventana de prueba");
		ventana.setSize(300, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container panel = ventana.getContentPane();
		// establece el layout
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Define botones para llenar las regiones
		JButton jb1 = new JButton("UNO");
		JButton jb2 = new JButton("DOS");
		JButton jb3 = new JButton("TRES");
		JButton jb4 = new JButton("CUATRO");
		JButton jb5 = new JButton("CINCO");

		// Añade cada boton a su region
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(jb1, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(jb2, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		panel.add(jb3, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		panel.add(jb4, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(jb5, gbc);

		ventana.setVisible(true);

	}
}
