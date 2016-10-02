package es.rf.tienda.objetos.daos;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.ParentDAO;
import es.rf.tienda.interfaces.daos.UserDAO;
import es.rf.tienda.util.Rutinas;

public class UsuarioDAOH extends ParentDAO<Usuario> implements UserDAO {
	public UsuarioDAOH(){
		setNombreTabla("Usuario");
	}
	
	public String obtenLista(Usuario clase, String separador) {
		String salida = "";
		if (clase.getId_usuario() > 0) {
			salida = Rutinas.addSalida(salida, "id_Usuario", clase.getId_usuario(), separador);
		}
		if (clase.getUser_nombre() != null && clase.getUser_nombre().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "user_nombre", clase.getUser_nombre(), separador);
		}
		if (clase.getUser_email() != null && clase.getUser_email().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "user_email", clase.getUser_email(), separador);
		}
		return salida;
	}

	@Override
	public boolean isValidUser(String username, String password) throws DAOException {
		Usuario us = new Usuario();
		us.setUser_email(username);
		us.setUser_pass(password);
		us = leerRegistro(us);
		return true;
	}
}
