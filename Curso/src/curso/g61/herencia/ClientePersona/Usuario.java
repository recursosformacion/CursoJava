package rf.dominio;

public class Usuario extends Persona {
	public int codigoUsuario;
	
	Usuario(){
		super(10);
	}
	public void autorizar(){
		System.out.println("Autorizando usuario");
	}
	
	
	public void crear(){
		super.crear();
		System.out.println("creando usuario");
	}
	@Override
	public void esCorrecto() {
		// TODO Auto-generated method stub
		
	}
	
}
