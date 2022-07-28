package curso.g17.EjercicioFileSwing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PantallaLogin {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Login");
	
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);		
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		placeComponents(panel);
		// Setting the frame visibility to true
		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {
		
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel("Usuario");
		
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		
		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
	}
}
