package rf.curso.patrones0;

import java.util.Observable;
import java.util.Observer;

public class ConsolaObserva implements Observer{

	@Override
	public void update(Observable o, Object arg) {
	
			int colorSeleccionado = ((ClaseObservador) o).getColorSeleccionado();
		System.out.println("Color:"+colorSeleccionado);
	}

}
