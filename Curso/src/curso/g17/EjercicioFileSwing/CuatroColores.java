package curso.g17.EjercicioFileSwing;

import java.awt.Color;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CuatroColores {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Cuatro colores");

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);

		JButton jb1 = new JButton("Rojo");
		JButton jb2 = new JButton("Amarillo");
		JButton jb3 = new JButton("Verde");
		JButton jb4 = new JButton("Azul");
		jb1.setBackground(Color.red);
		jb2.setBackground(Color.yellow);
		jb3.setBackground(Color.green);
		jb4.setBackground(Color.blue);
		
		//Container panel = ventana.getContentPane();
		JPanel panel = new JPanel();
		panel.setSize(200,200);
		ventana.add(panel);
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		//establece el layout
		panel.setLayout(boxlayout);
		//Añade cada boton a su region
		panel.add(jb1);
		panel.add(jb2);
		panel.add(jb3);
		panel.add(jb4);
		jb1.addActionListener(e -> panel.setBackground(Color.red));
		jb2.addActionListener(e -> panel.setBackground(Color.yellow));
		jb3.addActionListener(e -> panel.setBackground(Color.green));
		jb4.addActionListener(e -> panel.setBackground(Color.blue));

		ventana.setSize(300, 200);
	
		ventana.setVisible(true);

	}

}
