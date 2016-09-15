package rf.curso.EmpresaAlimentaria;

public class ProductosCongelados extends Productos {
	private int temperaturaRecomendada;

	public int getTemperaturaRecomendada() {
		return temperaturaRecomendada;
	}

	public void setTemperaturaRecomendada(int temperaturaRecomendada) {
		this.temperaturaRecomendada = temperaturaRecomendada;
	}

	@Override
	public String toString() {
		return "\nProductosCongelados -----------------\n" + super.toString() + "\n TemperaturaRecomendada=" + getTemperaturaRecomendada() + "º";
	}
	
	
}
