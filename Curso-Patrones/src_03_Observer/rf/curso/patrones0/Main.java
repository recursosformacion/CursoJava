/*
 * Esta sera la clase encargada de dar inicio al sistema, 
 * además en ella también estableceremos las relaciones entre 
 * la ClaseObservador y las Clases "Ventanas", 
 * crearemos instancias de cada Clase y luego mediante el 
 * método addObserver() (Heredado de Observable) agregaremos todos 
 * los ObservadoresConcretos a nuestro SujetoConcreto.
 */
package rf.curso.patrones0;

public class Main {
	public static void main(String[] args) {
		ClaseObservador observador = new ClaseObservador();
		VentanaOpciones miVentanaOpciones = new VentanaOpciones(observador);
		VentanaColor miVentanaColor = new VentanaColor(observador);
		VentanaSeleccion miVentanaSeleccion = new VentanaSeleccion(observador);
		
		/** Aqui se Agregan los observadores */
		observador.addObserver(miVentanaColor);
		observador.addObserver(miVentanaSeleccion);
		observador.addObserver(miVentanaOpciones);
		
		
		
		// en consola
		ConsolaObserva consolaO = new ConsolaObserva();
		observador.addObserver(consolaO);
		
		observador.setColorSeleccionado(3);
		
	}
}
