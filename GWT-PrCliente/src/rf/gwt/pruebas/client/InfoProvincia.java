package rf.gwt.pruebas.client;

public class InfoProvincia {
	private String nombre;
	private String[] ciudades;
	
	public InfoProvincia(String nombre, String[] ciudades){
		this.nombre=nombre;
		this.ciudades= ciudades;
	}

	public String getNombre() {
		return nombre;
	}

	public String[] getCiudades() {
		return ciudades;
	}

	private static String[] lisBCN = {"Barcelona","Mataro","Granollers","Santa Coloma","Valldoreix"};
	private static String[] lisTRR = {"Tarragona","Reus","Tortosa","Vendrell","Cambrils","Vall","Calafell","Amposta","Viñaseca"};
	private static String[] lisLER = {"Lerida","Tarrega","Balaguer","Mollerusa","La Seu d'Urgell","Cervera"};
	private static String[] lisGIR = {"Girona","Figueres","Blanes","Lorret de Mar","Olot","Salt","Palafrugell"};
	private static InfoProvincia[] lasProvincias = {
			new InfoProvincia("Barcelona",lisBCN),
			new InfoProvincia("Tarragona",lisTRR),
			new InfoProvincia("Lerida",lisLER),
			new InfoProvincia("Girona",lisGIR)
	};
	
	public static InfoProvincia[] getLasProvincias(){
		return lasProvincias;
	}
	
	public static String[] buscaPoblaciones(InfoProvincia[] provincias,String nombreProvincia){
		for (InfoProvincia provincia : provincias){
			if(provincia.getNombre().equals(nombreProvincia)){
				return provincia.getCiudades();
			}
		}
		String[] desconocido = {"Provincia desconocida"}; 
		return desconocido;
	}
			
}
