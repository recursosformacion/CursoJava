package curso.g11.genericos;

public class Comparando<T extends Comparable<T>> {
	T oper1;
	T oper2;
	
	Comparando(T op1, T op2){
		oper1=op1;
		oper2=op2;
	}
	public T maximo(){
		return ((oper1.compareTo(oper2))>0) ? oper1 : oper2;
	}
}
