package curso.g17.layouts;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PrGridLayout {

	public static void main(String args[]){
		
		JFrame ventana = new JFrame("Ventana de prueba");
		ventana.setSize(300, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container panel = ventana.getContentPane();
		
		//Define botones para llenar las regiones
		JButton jb1 = new JButton("UNO");		
		JButton jb2 = new JButton("DOS");
		JButton jb3 = new JButton("TRES");		
		JButton jb4 = new JButton("CUATRO");
		JButton jb5 = new JButton("CINCO");		

		
		//establece el layout
		panel.setLayout(new GridLayout(3,2));
		//Añade cada boton a su region
		panel.add(jb1);
		panel.add(jb2);
		panel.add(jb3);
		panel.add(jb4);
		panel.add(jb5);
		ventana.setVisible(true);
		
	}
}
