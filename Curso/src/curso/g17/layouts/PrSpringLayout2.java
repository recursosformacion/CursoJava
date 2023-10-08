package curso.g17.layouts;

import java.awt.Container;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import static javax.swing.GroupLayout.Alignment.*;

public class PrSpringLayout2 {

	public static void main(String args[]) {

		JFrame ventana = new JFrame("Ventana de prueba");
		ventana.setSize(300, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container panel = ventana.getContentPane();
		SpringLayout layout = new SpringLayout();

		// establece el layout
		panel.setLayout(layout);

		// Define botones para llenar las regiones
		JButton jb1 = new JButton("UNO");
		JButton jb2 = new JButton("DOS");
		JButton jb3 = new JButton("TRES");
		JButton jb4 = new JButton("CUATRO");
		
		JLabel cM1 = new JLabel("Boton1");
		JLabel cM2 = new JLabel("Boton2");
		JLabel cM3 = new JLabel("Boton3");
		JLabel cM4 = new JLabel("Boton4");
	
		
		panel.add(jb1);
		panel.add(jb2); 
		panel.add(jb3); 
		panel.add(jb4); 
		panel.add(cM1); 
		panel.add(cM2); 
		panel.add(cM3); 
		panel.add(cM4); 
		
		layout.putConstraint(SpringLayout.WEST, cM1,5,SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, cM2,5,SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, cM3,5,SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, cM4,5,SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, jb1,60,SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, jb2,60,SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, jb3,60,SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, jb4,60,SpringLayout.WEST, panel);
		
		layout.putConstraint(SpringLayout.NORTH, jb1,10,SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, jb2,50,SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, jb3,90,SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, jb4,130,SpringLayout.NORTH, panel);
		
		layout.putConstraint(SpringLayout.SOUTH, cM1,0,SpringLayout.SOUTH, jb1);
		layout.putConstraint(SpringLayout.SOUTH, cM2,0,SpringLayout.SOUTH, jb2);
		layout.putConstraint(SpringLayout.SOUTH, cM3,0,SpringLayout.SOUTH, jb3);
		layout.putConstraint(SpringLayout.SOUTH, cM4,0,SpringLayout.SOUTH, jb4);
		
		
		
		
		ventana.setVisible(true);

	}
}
