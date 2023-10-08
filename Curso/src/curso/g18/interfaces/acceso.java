package curso.g18.interfaces;

public interface acceso {

	public String acceder(int a);
	public boolean grabar(String s);
	
	public default void cuenta(int a) {
		System.out.println(a);
	}
	
}
