package curso.g17.layouts;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoFlowLayout {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ventana de prueba");
		ventana.setSize(300,200);
		Container panel = ventana.getContentPane();
		
		
		panel.setLayout(new FlowLayout());     
		panel.add( new JLabel("UNO                    ."));
		panel.add(new JLabel("DOS                     ."));
		panel.add(new JLabel("TRES                    ."));
		panel.add(new JLabel("CUATRO                  ."));
		panel.add(new JLabel("CINCO                   ."));
		
		ventana.setVisible(true);

	}

}
