package rf.curso.EmpresaAlimentaria;

public class ProductosRefrigerados extends Productos {

	private String codigoOrganismoSupervisor;

	public String getCodigoOrganismoSupervisor() {
		return codigoOrganismoSupervisor;
	}

	public void setCodigoOrganismoSupervisor(String codigoOrganismoSupervisor) {
		this.codigoOrganismoSupervisor = codigoOrganismoSupervisor;
	}

	@Override
	public String toString() {
		return "\nProductosRefrigerados---------------------\n"+ 
				super.toString() + "\n" +  
				"CodigoOrganismoSupervisor=" + getCodigoOrganismoSupervisor() ;
	}
	
	
}
