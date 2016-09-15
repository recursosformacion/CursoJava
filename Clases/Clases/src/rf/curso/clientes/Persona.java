package rf.curso.clientes;

public abstract class Persona {
	private String id;
    private String nombre;
    private String direccion;
    private String correoElectronico;
    
    private static int contador;
    
    public Persona(){}
    
    public Persona(String tipo){
    	setId(tipo + "-" + contador++);
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public void crear(){
    	System.out.println("Creando Persona");
    }
    
    public void borrar(){
    	System.out.println("Borrando persona");
    }
    public void enviarMensaje(){
    	System.out.println("Enviando mensaje persona");
    }
}
