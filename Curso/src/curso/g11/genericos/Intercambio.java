package curso.g11.genericos;

class Intercambio<T> {
	private T ele1;
	private T ele2;
	
	public Intercambio(T a, T b){
		ele1=a;
		ele2=b;
	}
	
	public T getUno(){
		return ele1;
	}
	public T getDos(){
		return ele2;
	}
	public void invierte(){
		T tmp=ele1;
		ele1=ele2;
		ele2=tmp;
	}
}


