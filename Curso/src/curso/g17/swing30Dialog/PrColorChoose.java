package curso.g17.swing30Dialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class PrColorChoose {

	static final String TITULO = "Eleccion Color de fondo";

	public static void main(String[] args) {
		final JFrame ventana = new JFrame("Demo de JColorChooser");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setSize(300, 200);

		JButton btn1 = new JButton("Elegir Color");

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(ventana,
						TITULO,
						ventana.getBackground());
				if (newColor != null) {
					ventana.getContentPane().setBackground(newColor);
				}
			}
		});

		Container pane = ventana.getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(btn1);

		ventana.setVisible(true);
	}
}
