package pruebas;

public class Usuario extends Persona {
	int codigoUsuario;
	
	public void autorizar(){
		System.out.println("Autorizando Usuario");
	}
	
	public void crear(){
		super.crear();
		System.out.println("Creando usuario");
	}
}
