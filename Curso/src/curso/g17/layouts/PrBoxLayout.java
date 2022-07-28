package curso.g17.layouts;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PrBoxLayout {

	public static void main(String args[]){
		
		JFrame ventana = new JFrame("Y_AXIS");
		ventana.setSize(300, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null); 
		Container panel = ventana.getContentPane();
		
		//Define botones para llenar las regiones
		JButton jb1 = new JButton("UNO");		
		JButton jb2 = new JButton("DOS");
		JButton jb3 = new JButton("TRES");		
		JButton jb4 = new JButton("CUATRO");
		JButton jb5 = new JButton("CINCO");		

		//Define el layout
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		//establece el layout
		panel.setLayout(boxlayout);
		//Añade cada boton a su region
		panel.add(jb1);
		panel.add(jb2);
		panel.add(jb3);
		panel.add(jb4);
		panel.add(jb5);
		ventana.setVisible(true);
		
	}
}
