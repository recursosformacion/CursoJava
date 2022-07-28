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
import static javax.swing.GroupLayout.Alignment.*;

public class PrGroupLayout2 {

	public static void main(String args[]) {

		JFrame ventana = new JFrame("Ventana de prueba");
		ventana.setSize(300, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container panel = ventana.getContentPane();
		GroupLayout groupLayout = new GroupLayout(panel);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);

		// establece el layout
		panel.setLayout(groupLayout);

		// Define botones para llenar las regiones
		JButton jb1 = new JButton("UNO");
		JButton jb2 = new JButton("DOS");
		JButton jb3 = new JButton("TRES");
		JButton jb4 = new JButton("CUATRO");
		
		JLabel cM1 = new JLabel("Boton1");
		JLabel cM2 = new JLabel("Boton2");
		JLabel cM3 = new JLabel("Boton3");
		JLabel cM4 = new JLabel("Boton4");
	
		
		ParallelGroup hg1 = groupLayout.createParallelGroup(LEADING)
				.addComponent(cM1)
				.addComponent(cM2)
				.addComponent(cM3)
				.addComponent(cM4);
		
		ParallelGroup hg2 = groupLayout.createParallelGroup(TRAILING)
				.addComponent(jb1)
				.addComponent(jb2)
				.addComponent(jb3)
				.addComponent(jb4);
		
		ParallelGroup vg1 = groupLayout.createParallelGroup(BASELINE)
				.addComponent(cM1)
				.addComponent(jb1);
		
		ParallelGroup vg2 = groupLayout.createParallelGroup(BASELINE)
				.addComponent(cM2)
				.addComponent(jb2);
		
		ParallelGroup vg3 = groupLayout.createParallelGroup(BASELINE)
				.addComponent(cM3)
				.addComponent(jb3);
		
		ParallelGroup vg4 = groupLayout.createParallelGroup(BASELINE)
				.addComponent(cM4)
				.addComponent(jb4);
		
		 groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()  
	                .addGroup(hg1)  
	                .addGroup(hg2));  
	  
	     groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()  
	                .addGroup(vg1)  
	                .addGroup(vg2)
	                .addGroup(vg3)
	                .addGroup(vg4));  

		ventana.setVisible(true);

	}
}
