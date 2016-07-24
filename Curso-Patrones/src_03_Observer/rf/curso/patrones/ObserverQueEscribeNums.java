package rf.curso.patrones;

import java.awt.*;

public class ObserverQueEscribeNums extends Frame implements Observer {
	Label label1 = new Label();
	TextArea textArea1 = new TextArea();
	Subject suSubject;

	public ObserverQueEscribeNums(Subject s) {
	suSubject = s;
//	s.addObserver(this); ... }

	public void update() {
		String c = suSubject.getColor();
		if (c.equals("ROJO"))
			textArea1.append("NUEVO COLOR: " + 1 + "\n");
		else if (c.equals("VERDE"))
			textArea1.append("NUEVO COLOR: " + 2 + "\n");
		else if (c.equals("AZUL"))
			textArea1.append("NUEVO COLOR: " + 3 + "\n");
	}
}
