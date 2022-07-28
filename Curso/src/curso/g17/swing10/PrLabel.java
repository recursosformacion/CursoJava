package curso.g17.swing10;

import java.awt.Label;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrLabel {

	public static void main(String[] args) {
		

		Icon  icNuevo = new ImageIcon("D:\\Mis imágenes\\iconos\\ok\\smile.jpg");

		JFrame ventana = new JFrame("Labeles");
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
		JLabel lblNombre  = new JLabel("Nombre:");
		JLabel lblConIcono  = new JLabel(icNuevo);
		
		
		lblNombre.setBounds(50,10,200,90); 	
		ventana.add(lblNombre);
		
		
		lblConIcono.setBounds(50,50,50,90); 		
		ventana.add(lblConIcono);
		
		ventana.setSize(300, 200);
		ventana.setLayout(null);  
		ventana.setVisible(true);

	}

}
