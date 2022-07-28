package curso.g99.herenciaYpolimorfismo;

public class Cuadrado extends Figura {

	Cuadrado(int lado){
		super(lado,lado);
		super.nombre="Cuadrado";
	}
	Cuadrado(int lado, int vacio){
		super(lado,lado);
		super.nombre="Cuadrado";
	}
	@Override
	public double area() {

		area=getAncho()*getAlto();
		return area;
	}

}

