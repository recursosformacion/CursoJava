package curso.g05.condicionalesybucles.p05;


public class CalculaCuadrado {

	public static void main(String[] args) {
		int num, cuadrado;
		for (String nums : args){
			num=Integer.parseInt(nums);
			cuadrado = num * num;
			System.out.println(num + "² es igual a " + cuadrado);			
		}

	}

}
