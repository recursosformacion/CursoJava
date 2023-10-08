package curso.g10.junit1.almacenes;

public class Pedido {
	private String articulo;
	private int numero;
	private boolean estaRelleno;
	
	
	public Pedido(String articulo, int numero){
		this.articulo=articulo;
		this.numero=numero;
		estaRelleno=false;
		
	}
	
	public void fill(Almacen almacen) throws Exception{
		almacen.retirar(articulo, numero);
		estaRelleno=true;
	}
	
	public boolean getEstaRelleno(){
		return estaRelleno;
	}
	
	
}
