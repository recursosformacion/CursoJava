package curso.g17.swing10;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PrTextArea {

	static JLabel lblComentario;
	static JTextArea txtComentario;

	public static void main(String[] args) {

		JFrame ventana = new JFrame("TextArea");
		Container contentPane = ventana.getContentPane();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout); // establece el layout

		lblComentario = new JLabel("Comentario: ");
		txtComentario = new JTextArea(5,30);
		lblComentario.setLabelFor(txtComentario);

		contentPane.add(lblComentario);
		contentPane.add(txtComentario);
		
		
		layout.putConstraint(SpringLayout.WEST, txtComentario,80,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, txtComentario,10,SpringLayout.NORTH, contentPane);		
		layout.putConstraint(SpringLayout.WEST, lblComentario,5,SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, lblComentario,0,SpringLayout.NORTH, txtComentario);

		ventana.setSize(500, 200);
		ventana.setVisible(true);

	}

}
