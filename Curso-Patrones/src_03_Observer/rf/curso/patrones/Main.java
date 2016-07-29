package rf.curso.patrones;

public class Main {
	public static void main(String[] args) {
		Subject o=new Subject();
		ObserverQuePinta ob=new ObserverQuePinta(o);
		ObserverQuePinta ob2=new ObserverQuePinta(o);
		
		}

}
