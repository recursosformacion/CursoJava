package curso.g17.swing10;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class PrBotonesToggle {
	private static JToggleButton jb1;

	public static void main(String[] args) {

		JFrame ventana = new JFrame("Botones");

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);

		jb1 = new JToggleButton("ON");
		jb1.setBounds(10, 20, 95, 30);
		ventana.add(jb1);

		ventana.setSize(100, 100);
		ventana.setLayout(null);
		ventana.setVisible(true);

	}

}
