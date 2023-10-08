package curso.g08.clases.p01;

public class Usuario extends Persona {

	private String codigo;
	private String contraseña;

	Usuario(String codigo, String nombre, String contraseña) {
		super(nombre);
		setCodigo(codigo);
		setcontraseña(contraseña);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getcontraseña() {
		return contraseña;
	}

	public void setcontraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario:" + getCodigo() + "-->" + getNombre();
	}

	@Override
	public void salvar() {
		System.out.println("Usuario salvado");
	}

	@Override
	public void leer() {
		System.out.println("Usuario leido");
	}
}
