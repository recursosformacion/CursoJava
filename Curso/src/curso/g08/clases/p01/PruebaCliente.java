package curso.g08.clases.p01;

public class PruebaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente c1 = new Cliente("Miguel", 25, "1029384756");
		c1.setId(1);;
		imprimir(c1);
		guardar(c1);
		
		
		Usuario u1 = new Usuario("abcd", "Antonio", "123");
		u1.setId(2);
		u1.setRol(new Administrador());
		imprimir(u1);
		guardar(u1);
		Usuario u2 = new Usuario("Pepito","khjkjhkj","kjhkjhkjh");
		
		Persona c3 = new Cliente("Jose", 888, "0123456789");
		c3.setId(3);
		imprimir(c3);
		guardar((Salvable)c3);
		
	}
	private static void imprimir(Persona p){
		System.out.println("La informacion solicitada es:");
		System.out.println(p.aString());
	}
	private static void guardar(Salvable p){
		p.salvar();
	}
}
