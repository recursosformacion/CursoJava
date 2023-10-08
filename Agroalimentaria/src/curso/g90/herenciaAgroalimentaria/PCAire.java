package curso.g90.herenciaAgroalimentaria;

import java.util.Calendar;

public class PCAire extends PCongelados {

	private double pNitrogeno;
	private double pOxigeno;
	private double pDioxidoCarbono;
	private double pVaporAgua;
	
	public double getpNitrogeno() {
		return pNitrogeno;
	}
	public void setpNitrogeno(double pNitrogeno) {
		this.pNitrogeno = pNitrogeno;
	}
	public double getpOxigeno() {
		return pOxigeno;
	}
	public void setpOxigeno(double pOxigeno) {
		this.pOxigeno = pOxigeno;
	}
	public double getpDioxidoCarbono() {
		return pDioxidoCarbono;
	}
	public void setpDioxidoCarbono(double pDioxidoCarbono) {
		this.pDioxidoCarbono = pDioxidoCarbono;
	}
	public double getpVaporAgua() {
		return pVaporAgua;
	}
	public void setpVaporAgua(double pVaporAgua) {
		this.pVaporAgua = pVaporAgua;
	}
	public PCAire() {
		super();
	}
	
	public PCAire(Calendar fechaCaducidad, int numeroLote, int temperatura,
					double pNitrogeno, double pOxigeno, double pDioxidoCarbono, double pVaporAgua) {
		super(fechaCaducidad, numeroLote, temperatura);
		setpNitrogeno(pNitrogeno);
		setpOxigeno(pOxigeno);
		setpDioxidoCarbono(pDioxidoCarbono);
		setpVaporAgua(pVaporAgua);
		
	}
	public String toString(){
		return super.toString()+
				" %Nitrogeno:"+getpNitrogeno() +
				" %Oxigeno:"+getpOxigeno() +
				" %Dioxido de carbono:"+ getpDioxidoCarbono() +
				" %Vapor de agua:" + getpVaporAgua();
		
	}
	
}
