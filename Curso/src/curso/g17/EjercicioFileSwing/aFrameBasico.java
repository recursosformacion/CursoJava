package curso.g17.EjercicioFileSwing;



import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class aFrameBasico {

	public static void main(String[] args) {
		//1. Crea el Frame.
		JFrame frame = new JFrame("FrameDemo");

		//2. Optional: Establece la salida
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Le pone un boton
		JButton button1 = new JButton("Presionar");      
        frame.getContentPane().add(button1);      
		//4. Ajusta el tamaño
		//frame.pack();
		frame.setSize(300, 300);   
		
		//5. Presenta la pantalla.
		frame.setVisible(true);

	}

}
