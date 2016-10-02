package pruebas;

public class ClienteExportacion extends Cliente {
	String vat ;
	
	ClienteExportacion(String nombre, String direccion, String CorreoElectronico, String vat){
		super();
		this.nombre=nombre;
		this.direccion=direccion;
		this.correoElectronico=correoElectronico;
		this.vat=vat;
	}
}
