package rf.curso.clientes;

public class Usuario extends Persona {

	private int codigoUsuario;
	
	public Usuario(){
		super("U");
	}
	public void autorizar(){
		System.out.println("Usuario autoriza");
		
	}
	public void crear(){
		System.out.println("Usuario crea");
	}
}
