package curso.g99.herenciaYpolimorfismo;

public class PruebaFiguras1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura redonda = new Circulo(10);
		Rectangulo pequ = new Rectangulo(20,20);
		Figura bola=(Figura) new Circulo(2);
		
		presenta(redonda);
		presenta(pequ);
		presenta(bola);
		
	}
	private static void presenta(Figura dato){
		System.out.println("Area " + 
								dato.getClass().getSimpleName() +
								"  de " + 
								dato.getAncho()+
								"x"+
								dato.getAlto()+
								"="+
								dato.area());
	}
}

