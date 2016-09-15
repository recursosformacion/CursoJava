package curso.g50.dibujos.dominio;

public class Triangulo extends Forma {

	public int lado1, lado2, lado3;
	
	@Override
	public double calculaArea() {
		// TODO Auto-generated method stub
		double semiperimetro=(lado1+lado2+lado3)/2;
		double area = Math.sqrt(semiperimetro*(semiperimetro-lado1)*(semiperimetro-lado2)*(semiperimetro-lado3));
		return area;
		
	}

	
}
