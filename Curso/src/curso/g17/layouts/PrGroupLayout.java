package curso.g17.layouts;

import java.awt.Container;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.GroupLayout.Alignment.*;

public class PrGroupLayout {

	public static void main(String args[]) {

		JFrame ventana = new JFrame("Ventana de prueba");
		ventana.setSize(300, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container panel = ventana.getContentPane();
		GroupLayout groupLayout = new GroupLayout(panel);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);

		// establece el layout
		panel.setLayout(groupLayout);

		// Define botones para llenar las regiones
		JButton jb1 = new JButton("UNO");
		JButton jb2 = new JButton("DOS");
		JButton jb3 = new JButton("TRES");
		JButton jb4 = new JButton("CUATRO");
		JButton jb5 = new JButton("CINCO");

		JLabel cM1 = new JLabel("Boton1");
		JLabel cM2 = new JLabel("Boton2");
		JLabel cM3 = new JLabel("Boton3");
		JLabel cM4 = new JLabel("Boton4");
		JLabel cM5 = new JLabel("Boton5");

		// Set for horizontal and vertical group
		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addComponent(jb1)
				.addComponent(jb2)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(jb3)
									.addComponent(jb4)
									.addComponent(jb5))));
		groupLayout.setVerticalGroup(
				groupLayout.createSequentialGroup()
					.addComponent(jb1)
					.addComponent(jb2)
					.addComponent(jb3)
					.addComponent(jb4)
					.addComponent(jb5));

		ventana.setVisible(true);

	}
}
