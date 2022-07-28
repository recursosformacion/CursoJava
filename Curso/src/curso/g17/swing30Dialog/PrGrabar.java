package curso.g17.swing30Dialog;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PrGrabar {

	static final String TITULO = "Prueba de FileChooser";

	public static void main(String[] args) {
		final JFrame ventana = new JFrame(TITULO);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setSize(300, 200);        

        JButton btn1 = new JButton("Graba");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GrabarDatos gd=new GrabarDatos();
                if (gd.prepara()){
                	gd.graba("Hola, esto aparece en el fichero");
                	gd.graba("y esto tambien en la siguiente linea");
                	gd.close();
                	System.exit(0);
                }
            }
        });
        
        
		Container pane = ventana.getContentPane();
		pane.setLayout(new GridLayout(3, 1, 10, 10));
		pane.add(btn1);
		

		ventana.setVisible(true);
	}
}
