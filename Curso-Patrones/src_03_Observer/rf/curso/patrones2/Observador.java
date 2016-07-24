package rf.curso.patrones2;

import java.util.Observable;

public class Observador implements java.util.Observer {
	private Observado modelo;

	public Observador(Observado model) {
		modelo = model;
		model.addObserver(this); // Conecta la Vista con el Modelo
	}

	public void update(Observable t, Object o) // Invocada desde el modelo
	{
		System.out.println("La temperatura ha cambiado" + modelo.getF());
	}
}
