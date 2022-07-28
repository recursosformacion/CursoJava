package curso.g17.swing01;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PruJFrame {

	public static void main(String args[]){
		
		JFrame ventana = new JFrame("Ventana de prueba");
		Container panel = ventana.getContentPane();
		
		panel.setLayout(new BorderLayout());
		panel.add("Center", new JLabel("centro"));
		panel.add("North",new JLabel("Arriba"));
		panel.add("South",new JLabel("Abajo"));
		panel.add("East",new JLabel("derecha"));
		panel.add("West",new JLabel("izquierda"));
		ventana.pack();
		ventana.setVisible(true);
	}
}
