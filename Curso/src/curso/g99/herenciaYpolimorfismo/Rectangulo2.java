package curso.g99.herenciaYpolimorfismo;

public class Rectangulo2 extends Figura {

	
	Rectangulo2(int ancho, int alto){
		super(ancho,alto);
		if (ancho>=30) setAncho(30);
		if (alto>=30) setAlto(30);
		super.nombre="Rectangulo2";
		
		
	}
	@Override
	public double area() {

		area=ancho*alto;
		return area;
	}
	public void dibujar(){
		for (int alt=0;alt<alto;alt++){
			for (int anc = 0; anc < ancho; anc++) System.out.print("*"); 
			System.out.println("");
		}
	}

}

