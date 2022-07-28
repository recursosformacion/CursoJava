package curso.g05.condicionalesybucles.p08;

public class FactorialRecursivo {

	public static void main(String[] args) {
		int fact=8;
		System.out.println(factorial(fact));
		

	}
	static int factorial(int num){
		if (num>1)
			return num*factorial(--num);
		else
			return num;
	}

}
