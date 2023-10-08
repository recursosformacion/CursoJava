package curso.g90.herenciaAgroalimentaria;

import java.util.Calendar;

public class PRefrigerados extends Productos {

	private int codOrgSupAlim;

	public int getCodOrgSupAlim() {
		return codOrgSupAlim;
	}

	public void setCodOrgSupAlim(int codOrgSupAlim) {
		this.codOrgSupAlim = codOrgSupAlim;
	}

	public PRefrigerados() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PRefrigerados(Calendar fechaCaducidad, int numeroLote, int codOrgSupAlim) {
		super(fechaCaducidad, numeroLote);
		setCodOrgSupAlim(codOrgSupAlim);
	}
	
	public String toString(){
		return super.toString() +
				" Codigo organismo supervisor:" + getCodOrgSupAlim();
	}
	
}
