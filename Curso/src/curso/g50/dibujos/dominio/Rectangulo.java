package curso.g50.dibujos.dominio;

public class Rectangulo extends Forma {
	
	private int lado1;
	private int lado2;
	
	@Override
	public double calculaArea() {
		// TODO Auto-generated method stub
		return lado1*lado2;
	}

	public int getLado1() {
		return lado1;
	}

	public void setLado1(int lado1) {
		this.lado1 = lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public void setLado2(int lado2) {
		this.lado2 = lado2;
	}

	

	
}
