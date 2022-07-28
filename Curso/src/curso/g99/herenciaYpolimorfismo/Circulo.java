package curso.g99.herenciaYpolimorfismo;

public class Circulo extends Figura {

	
	Circulo(int radio){
		super(radio*2,radio*2);
		super.nombre="Circulo";
	}
	@Override
	public double area() {
		if (ancho==alto){
			area= Math.PI* (ancho/2)*(ancho/2);
		}
		else
			area=0;
		return area;
	}

}

