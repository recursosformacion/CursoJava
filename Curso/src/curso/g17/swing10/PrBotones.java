package curso.g17.swing10;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PrBotones {

	public static void main(String[] args) {
		

		Icon  icNuevo = new ImageIcon("D:\\Mis imágenes\\Nuevo.gif");

		JFrame ventana = new JFrame("Botones");
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
							
		JButton jb1 = new JButton("UNO");
		jb1.setBounds(50,10,95,30); 		
		ventana.add(jb1);
		
		JButton jb2 = new JButton("Nuevo", icNuevo);
		jb2.setBounds(50,50,200,90); 		
		ventana.add(jb2);
		
		ventana.setSize(300, 200);
		ventana.setLayout(null);  
		ventana.setVisible(true);

	}

}
