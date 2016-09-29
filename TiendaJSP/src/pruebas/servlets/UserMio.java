package pruebas.servlets;

import java.io.Serializable;

public class UserMio implements Serializable{

		private String nombre;
		private String hora;
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getHora() {
			return hora;
		}
		public void setHora(String hora) {
			this.hora = hora;
		}
	
}
