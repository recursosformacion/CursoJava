package curso.g17.swing10;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrJTable {

	JFrame ventana;
	Container contentPane;
	String data[][] = { { "101", "Miguel Garcia", "España" },
			{ "102", "Jhon Smith", "EE.UU" },
			{ "105", "Zoe Blanchet", "Francia" },
			{ "201", "Jose Gutierrez", "Mexico" } };
	
	String column[] = { "ID", "Nombre", "Pais" };

	PrJTable() {
		ventana = new JFrame("Tabla");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		contentPane=ventana.getContentPane();
			
		JTable jt = new JTable(data, column);
		jt.setBounds(60, 40, 200, 400);
		JScrollPane sp = new JScrollPane(jt);
		contentPane.add(sp);
		ventana.setSize(300, 500);
		ventana.setVisible(true);
	}

	public static void main(String[] args) {
		new PrJTable();
	}

}
