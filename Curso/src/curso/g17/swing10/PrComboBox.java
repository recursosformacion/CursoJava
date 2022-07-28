package curso.g17.swing10;

import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class PrComboBox {
	

	public static void main(String[] args) {

		JFrame ventana = new JFrame("Botones");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		Container panel = ventana.getContentPane();

		String paises[]={"España","Francia","Alemania","Italia","Portugal"};        
	    JComboBox cb=new JComboBox(paises);    
	    cb.setBounds(50, 50,90,20);    
        panel.add(cb);
		ventana.setSize(300,200);
	
		ventana.setVisible(true);

	}

}
