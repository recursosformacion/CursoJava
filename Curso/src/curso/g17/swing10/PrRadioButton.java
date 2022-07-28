package curso.g17.swing10;

import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class PrRadioButton {
	

	public static void main(String[] args) {

		JFrame ventana = new JFrame("Botones");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		Container panel = ventana.getContentPane();

		JPanel prb = new JPanel();
		prb.setBounds(10, 30, 260, 50);
		prb.setBackground(Color.CYAN);
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Opciones");
		prb.setBorder(title);

		JRadioButton r1=new JRadioButton("A) Contado");    
		JRadioButton r2=new JRadioButton("B) Transferencia");    
		//r1.setBounds(10,50,100,60);    
		//r2.setBounds(10,100,130,60);    
		r1.setBackground(prb.getBackground());
		r2.setBackground(prb.getBackground());
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);    
		prb.add(r1);
		prb.add(r2);      
        
		panel.add(prb);
		ventana.setSize(300,200);
		ventana.setVisible(true);
	}
}
