package curso.g60.herenciaYpolimorfismo;

public class PruebaFiguras {

	public static void main(String[] args) {
		Figura redonda = new Circulo(10);
		Rectangulo pequ = new Rectangulo(20,20);
		Figura bola=(Figura) new Circulo(2);
		
		System.out.println("Area redonda de " + redonda.getAncho()+"x"+redonda.getAlto()+"="+redonda.area());
		System.out.println("Area pequ de " + pequ.getAncho()+"x"+pequ.getAlto()+"="+pequ.area());
		System.out.println("Area bola de " + bola.getAncho()+"x"+bola.getAlto()+"="+bola.area());
		redonda.dibujar();
		pequ.dibujar();
		bola.dibujar();
	}
	
}
