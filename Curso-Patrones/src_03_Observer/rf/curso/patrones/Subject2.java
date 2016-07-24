package rf.curso.patrones;

import java.awt.*;
import java.awt.event.ItemEvent;

public class Subject2 extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9075630035232944505L;
	Checkbox checkbox1 = new Checkbox();
	Checkbox checkbox2 = new Checkbox();
	Checkbox checkbox3 = new Checkbox(); 
	CheckboxGroup checkboxGroup1 = new CheckboxGroup();
	

	public void Subject() {
		checkbox1.setLabel("ROJO");
		checkbox1.setCheckboxGroup(checkboxGroup1);
		checkbox1.addItemListener(new java.awt.event.ItemListener() {
			

			@Override
			public void itemStateChanged(ItemEvent e) {
				notify();			
			}
			});
		checkbox2.setLabel("VERDE"); 
		checkbox3.setLabel("AZUL");
	}
	
	public void addObserver(Observer o) {
		susObservers.addElement(o);
		}
	public void notificar() {
		setChanged();
		notifyObservers(); 
		} 
	}

	public String getColor() {
		return checkboxGroup1.getSelectedCheckbox().getLabel();
	}
}
