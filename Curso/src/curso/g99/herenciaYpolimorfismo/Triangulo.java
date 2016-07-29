package curso.g99.herenciaYpolimorfismo;

public class Triangulo extends Figura {

	Triangulo(int a,int b){
		super(a,b);
		super.nombre="Triangulo";
	}
	@Override
	public double area() {

		area=ancho*alto/2;
		return area;
	}

}
