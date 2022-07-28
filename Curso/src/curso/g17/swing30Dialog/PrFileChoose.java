package curso.g17.swing30Dialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PrFileChoose {

	static final String TITULO = "Eleccion Color de fondo";

	public static void main(String[] args) {
		final JFrame ventana = new JFrame("Demo de JFileChooser");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setSize(300, 200);
		
		final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        fc.setCurrentDirectory(new File("C:"));
        

        JButton btn1 = new JButton("Show Dialog");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fc.showDialog(ventana, "Elija");
            }
        });
        
        JButton btn2 = new JButton("Show Open Dialog");
        btn2.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                int retVal = fc.showOpenDialog(ventana);
                if (retVal == JFileChooser.APPROVE_OPTION) {
                    File[] selectedfiles = fc.getSelectedFiles();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < selectedfiles.length; i++) {
                        sb.append(selectedfiles[i].getName() + "\n");
                    }
                    JOptionPane.showMessageDialog(ventana, sb.toString());
                }
            }
        });

		Container pane = ventana.getContentPane();
		pane.setLayout(new GridLayout(3, 1, 10, 10));
		pane.add(btn1);
		pane.add(btn2);

		ventana.setVisible(true);
	}
}
