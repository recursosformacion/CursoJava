package curso.g07.funciones.p05;



/*
 * Calcular el factorial de n recursivamente.
 */
public class FactorialRecursivo {

	public static void main(String[] args) {
		int num, resultado;		
		num = 12;
		resultado = factorial(num);
		System.out.println(num + "! es igual a " + resultado);
	}

	static int factorial(int num) {
		int res;
		if (num == 0) // caso base: 0! es igual a 1
			res = 1;
		else
			res = num * factorial(num - 1); // n!= n*(n-1)*(n-2)... un ejemplo
											// 3!=3*2*1
											// también ocurre que n!=n*(n-1)!
											// como ejemplo 4!=4*3*2*1!
		return (res);
	}
}
