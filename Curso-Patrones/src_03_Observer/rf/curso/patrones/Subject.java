package rf.curso.patrones;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.Observable;

public class Subject extends Observable {
	Choice choice1 = new Choice();

	public Subject() {
		choice1.addItem("ROJO"); 
		choice1.addItem("VERDE");
		choice1.addItem("AZUL");
		choice1.addItemListener(new java.awt.event.ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setChanged();
				notifyObservers(); 
			}
		});
		
	}

	public String getColor() {
		return choice1.getSelectedItem();
	}
}
