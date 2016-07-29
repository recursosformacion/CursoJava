package curso.g99.herenciaYpolimorfismo;

public class Rectangulo extends Figura {

	
	Rectangulo(int ancho, int alto){
		super(ancho,alto);
		super.nombre="Rectangulo";
	}
	@Override
	public double area() {

		area=ancho*alto;
		return area;
	}

}

