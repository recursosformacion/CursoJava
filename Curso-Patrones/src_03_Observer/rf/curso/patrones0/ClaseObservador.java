/*
 * http://codejavu.blogspot.com.es/2013/06/ejemplo-patron-observer.html
 * Esta clase sera el medio por el cual las clases 
 * VentanaSelección, VentanaColor, y VentanaOpciones 
 * podrán convertirse en SujetosConcretos (Usando métodos set y get...)
 */
package rf.curso.patrones0;

import java.util.Observable;

public class ClaseObservador extends Observable {

	private int colorSeleccionado;
	private String color;

	public ClaseObservador() {

	}

	public void setColorSeleccionado(int i) {
		this.colorSeleccionado = i;
		setChanged();
		notifyObservers();
	}

	public int getColorSeleccionado() {
		return colorSeleccionado;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}
