package curso.g17.swing10;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PrForm01  implements ActionListener {

	JLabel lblNombre, lblDireccion;
	JTextField txtNombre, txtDireccion;
	JButton btEnviar;
	
	public static void main(String[] args) {  
	    new PrForm01();  
	}  

	PrForm01() {
		JFrame ventana = new JFrame("Textos");
		Container contentPane = ventana.getContentPane();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout); // establece el layout

		lblNombre = new JLabel("Nombre: ");
		txtNombre = new JTextField(30);
		txtNombre.setHorizontalAlignment(JTextField.LEFT);
		lblNombre.setLabelFor(txtNombre);

		lblDireccion = new JLabel("Direccion");
		txtDireccion = new JTextField(30);
		txtDireccion.setHorizontalAlignment(JTextField.LEFT);
		lblDireccion.setLabelFor(txtDireccion);
		
		btEnviar = new JButton("Enviar");
		btEnviar.addActionListener(this);
		
		
		contentPane.add(lblNombre);
		contentPane.add(txtNombre);
		contentPane.add(lblDireccion);
		contentPane.add(txtDireccion);
		contentPane.add(btEnviar);
		
		layout.putConstraint(SpringLayout.WEST, txtNombre,70,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, txtNombre,10,SpringLayout.NORTH, contentPane);		
		layout.putConstraint(SpringLayout.WEST, txtDireccion,70,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, txtDireccion,50,SpringLayout.NORTH, contentPane);	
		layout.putConstraint(SpringLayout.WEST, lblNombre,5,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, lblNombre,0,SpringLayout.NORTH, txtNombre);
		layout.putConstraint(SpringLayout.WEST, lblDireccion,5,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, lblDireccion,0,SpringLayout.NORTH, txtDireccion);
		layout.putConstraint(SpringLayout.SOUTH, btEnviar,-20,SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, btEnviar,-20,SpringLayout.EAST, contentPane);

		ventana.setSize(500, 200);
		ventana.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = txtNombre.getText();
		String direccion = txtDireccion.getText();
		System.out.println(nombre + "\n" + direccion);
		
	}

}
