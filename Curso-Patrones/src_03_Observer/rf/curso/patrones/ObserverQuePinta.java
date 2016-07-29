package rf.curso.patrones;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.util.Observable;

public class ObserverQuePinta extends Frame implements java.util.Observer {
	Label label1 = new Label();
	Panel panel1 = new Panel();
	Subject suSubject;

	public ObserverQuePinta(Observable s) {
		suSubject = (Subject) s;
		
		add(panel1);
		add(label1);
		add(((Subject) s).choice1);
		
		setVisible(true);
		setSize(420,220);
		setTitle("EVENTOS");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		s.addObserver(this);
	}
	
	@Override
	public void update(Observable t, Object o) {
		String c = suSubject.getColor();
		if (c.equals("ROJO"))
			panel1.setBackground(Color.red);
		else if (c.equals("VERDE"))
			panel1.setBackground(Color.green);
		else if (c.equals("AZUL"))
			panel1.setBackground(Color.blue);
	}


	
}
