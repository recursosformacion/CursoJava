package curso.g17.swing10;

import java.awt.Container;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class PrCheckBox {
	

	public static void main(String[] args) {

		JFrame ventana = new JFrame("Botones");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		Container panel = ventana.getContentPane();

		JCheckBox checkBox1 = new JCheckBox("PHP");  
        checkBox1.setBounds(10,10, 150,50);  
        JCheckBox checkBox2 = new JCheckBox("Java", true);  
        checkBox2.setBounds(10,50, 150,50);  
        panel.add(checkBox1);  
        panel.add(checkBox2);  
        
		ventana.setSize(300,200);
	
		ventana.setVisible(true);

	}

}
