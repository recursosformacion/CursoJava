package rf.curso.patrones2;

public class Main {
	public static void main(String[] args) {
		Observado o=new Observado();
		Observador ob=new Observador(o);
		Observador ob2=new Observador(o);
		o.setF(45.5);
		}

}
