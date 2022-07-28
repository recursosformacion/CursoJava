package curso.g17.layouts;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrBorderLayout {

	public static void main(String args[]){
		
		JFrame ventana = new JFrame("Ventana de prueba");
		ventana.setSize(300, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container panel = ventana.getContentPane();
		
		//Define botones para llenar las regiones
		JButton jb1 = new JButton("ARRIBA");		
		JButton jb2 = new JButton("ABAJO");
		JButton jb3 = new JButton("IZQUIERDA");		
		JButton jb4 = new JButton("DERECHA");
		JButton jb5 = new JButton("CENTRO");		

		
		//establece el layout
		panel.setLayout(new BorderLayout(5,7));
		//Añade cada boton a su region
		panel.add(jb1, BorderLayout.NORTH);
		panel.add(jb2, BorderLayout.SOUTH);
		panel.add(jb3, BorderLayout.WEST);
		panel.add(jb4, BorderLayout.EAST);
		panel.add(jb5, BorderLayout.CENTER);
		ventana.setVisible(true);
		
	}
}
