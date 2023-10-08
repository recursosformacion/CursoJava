package curso.g08.clases.p01;

public class Cliente extends Persona
{
	private int numero;
	private String nif;
	
	public Cliente(String nombre, int numero, String nif) {
		super(nombre);
		this.numero = numero;
		this.nif = nif;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	@Override
	public void salvar() {		
		System.out.println("Cliente salvado");		
	}
	@Override
	public void leer() {		
		System.out.println("Cliente leido");		
	}
	@Override
	public String toString() {
		return "Cliente:" + getNif() + "-->" + getNombre();
	}
}
