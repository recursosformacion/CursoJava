package curso.g80.singleton;

public class ClaseLogSingleton {

	private String contenido;

	/** objeto Singleton */
	private static ClaseLogSingleton miLogSingleton = new ClaseLogSingleton();

	// Constructor para bloquear la posibilidad de construir
	private ClaseLogSingleton() {
		setContenido("Eventos de Usuario\n\n");
	}

	/**
	 * @return the miArchivoSingleton
	 */
	public static ClaseLogSingleton getMiLogSingleton() {
		return miLogSingleton;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @param contenido
	 *            the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
