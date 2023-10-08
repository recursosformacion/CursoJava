package curso.g17.swing01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameDemo0 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("HolaMundoSwing");
		final JLabel label = new JLabel("Hola Mundo");
		frame.getContentPane().add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(300,100);
		frame.setLocationRelativeTo(null); 
		frame.getContentPane().setBackground(Color.RED);
		frame.setVisible(true);
	}
}
