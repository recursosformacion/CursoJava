package curso.g17.swing10;

import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class PrList {

	public static void main(String[] args) {

		JFrame ventana = new JFrame("Botones");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		Container panel = ventana.getContentPane();

		DefaultListModel<String> l1 = new DefaultListModel<>();
		l1.addElement("España");
		l1.addElement("Francia");
		l1.addElement("Alemania");
		l1.addElement("Italia");
		JList<String> list = new JList<>(l1);
		list.setBounds(100, 30, 75, 75);

		panel.add(list);
		ventana.setSize(300, 200);

		ventana.setVisible(true);

	}

}
