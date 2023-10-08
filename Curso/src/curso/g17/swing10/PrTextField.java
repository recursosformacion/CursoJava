package curso.g17.swing10;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PrTextField {

	static JLabel lblNombre, lblDireccion;
	static JTextField txtNombre, txtDireccion;

	public static void main(String[] args) {

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
		
		contentPane.add(lblNombre);
		contentPane.add(txtNombre);
		contentPane.add(lblDireccion);
		contentPane.add(txtDireccion);
		
		layout.putConstraint(SpringLayout.WEST, txtNombre,70,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, txtNombre,10,SpringLayout.NORTH, contentPane);		
		layout.putConstraint(SpringLayout.WEST, txtDireccion,70,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, txtDireccion,50,SpringLayout.NORTH, contentPane);	
		layout.putConstraint(SpringLayout.WEST, lblNombre,5,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, lblNombre,0,SpringLayout.NORTH, txtNombre);
		layout.putConstraint(SpringLayout.WEST, lblDireccion,5,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, lblDireccion,0,SpringLayout.NORTH, txtDireccion);

		ventana.setSize(500, 200);
		ventana.setVisible(true);

	}

}
