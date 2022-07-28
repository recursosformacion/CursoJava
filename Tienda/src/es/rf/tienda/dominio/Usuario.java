package es.rf.tienda.dominio;

import java.util.Date;

public class Usuario {
private int id_usuario;				// identificador de usuario
	
	private String user_nombre;			// nombre de usuario
	
	private String user_email;			// Correo electronico del usuario
	
	private String user_pass;			// Contraseña del usuario
	
	private String user_tipo;			// Tipo de usuario
	
	private String user_dni;			// DNI del usuario
	
	private Date user_fecAlta;			// Fecha alta
	
	private Date user_fecConfirmacion;	// Fecha en que confirma el correo
	
	private Direccion  user_pago;		// Datos direccion de pago
	
	private Direccion  user_envio;		// Datos direccion de envio

	/**
	 * @return el id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * @param id_usuario el id_usuario a establecer
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * @return el user_nombre
	 */
	public String getUser_nombre() {
		return user_nombre;
	}

	/**
	 * @param user_nombre el user_nombre a establecer
	 */
	public void setUser_nombre(String user_nombre) {
		this.user_nombre = user_nombre;
	}

	/**
	 * @return el user_email
	 */
	public String getUser_email() {
		return user_email;
	}

	/**
	 * @param user_email el user_email a establecer
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	/**
	 * @return el user_pass
	 */
	public String getUser_pass() {
		return user_pass;
	}

	/**
	 * @param user_pass el user_pass a establecer
	 */
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	/**
	 * @return el user_tipo
	 */
	public String getUser_tipo() {
		return user_tipo;
	}

	/**
	 * @param user_tipo el user_tipo a establecer
	 */
	public void setUser_tipo(String user_tipo) {
		this.user_tipo = user_tipo;
	}

	/**
	 * @return el user_dni
	 */
	public String getUser_dni() {
		return user_dni;
	}

	/**
	 * @param user_dni el user_dni a establecer
	 */
	public void setUser_dni(String user_dni) {
		this.user_dni = user_dni;
	}

	/**
	 * @return el user_fecAlta
	 */
	public Date getUser_fecAlta() {
		return user_fecAlta;
	}

	/**
	 * @param user_fecAlta el user_fecAlta a establecer
	 */
	public void setUser_fecAlta(Date user_fecAlta) {
		this.user_fecAlta = user_fecAlta;
	}

	/**
	 * @return el user_fecConfirmacion
	 */
	public Date getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	/**
	 * @param user_fecConfirmacion el user_fecConfirmacion a establecer
	 */
	public void setUser_fecConfirmacion(Date user_fecConfirmacion) {
		this.user_fecConfirmacion = user_fecConfirmacion;
	}

	/**
	 * @return el user_pago
	 */
	public Direccion getUser_pago() {
		return user_pago;
	}

	/**
	 * @param user_pago el user_pago a establecer
	 */
	public void setUser_pago(Direccion user_pago) {
		this.user_pago = user_pago;
	}

	/**
	 * @return el user_envio
	 */
	public Direccion getUser_envio() {
		return user_envio;
	}

	/**
	 * @param user_envio el user_envio a establecer
	 */
	public void setUser_envio(Direccion user_envio) {
		this.user_envio = user_envio;
	}
	
	
	
	
	
}