package rf.dominio;

public abstract class Persona {
	public String nombre;
	public String direccion;
	public String correoElectronico;
	public int tipoPersona;
	
	public final String MENSAJE;
	
	Persona(int numero){
		if (numero==10)
			MENSAJE="Este mensaje es de Usuario";
		else
			MENSAJE="Este mensaje es de Cliente";
		
		
		tipoPersona=numero;
		System.out.println("Construyendo persona");
	}

	public void crear(){
		System.out.println("creando persona");
	}
	
	public void borrar(){
		System.out.println("borrando Persona");
	}
	
	public void enviarMensaje(){
		System.out.println("Enviando mensaje persona");
	}
	
	public abstract void esCorrecto();
}
