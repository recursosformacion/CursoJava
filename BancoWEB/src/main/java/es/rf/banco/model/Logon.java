package es.rf.banco.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Repository;

@Repository
public class Logon {

	@NotNull
	@Size(min = 2, max = 30,  message= "La longitud de usuario ha de estar entre 2 y 30")
	private String usuario;

	@NotNull
	@Size(min = 2, max = 30)
	private String password;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
