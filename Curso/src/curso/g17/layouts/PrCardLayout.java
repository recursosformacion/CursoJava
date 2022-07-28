package curso.g17.layouts;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrCardLayout extends JFrame implements ActionListener  {
	
	public static CardLayout fichas = new CardLayout(40, 30);
	public static Container panel;
	JButton jb1, jb2, jb3, jb4, jb5;
	
	public static void main(String args[]){
		PrCardLayout ventana = new PrCardLayout();
		ventana.setVisible(true);
	}
	
	public PrCardLayout(){
		setTitle("Ventana de prueba");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = getContentPane();
		
		//Define botones para llenar paneless
		jb1 = new JButton("UNO");		
		jb2 = new JButton("Siguiente");
		jb3 = new JButton("TRES");		
		jb4 = new JButton("CUATRO");
		jb5 = new JButton("Siguiente");		
		
		//Estamos atentos a estos eventos
		jb2.addActionListener(this);
		jb5.addActionListener(this);
		
		//Definimosdos paneles
		JPanel p1 = new JPanel(); 
		//Añadimoscomponentes en FlowLayout
		p1.add(jb1);
		p1.add(jb2);
		
		JPanel p2 = new JPanel();
		p2.add(jb3);
		p2.add(jb4);
		p2.add(jb5);

		
		//establece el layout de frame
		panel.setLayout(fichas);
		//Añade paneles
		panel.add("Primero",p1);
		panel.add("Segundo", p2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fichas.next(panel); 	
	}
}
