package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.RFDataConnection;

public abstract class BObjetosDAO<T> {

	public final String SELECTM = "SELECT * FROM ";
	public final String DELETEM = "DELETE FROM ";

	private String nombreTabla;

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	public List<T> leerTodos() throws DAOException, DomainException {
		String sql = SELECTM + getNombreTabla();		
		return montaLista(sql);
	}

	public List<T> leerRegistros(T t) throws DAOException, DomainException {
		String where = obtenWhere(t);
		String sql = SELECTM + getNombreTabla() + " " + where;		
		return montaLista(sql);
	}

	public T leerRegistro(T clase) throws DAOException, DomainException {
		List<T> lista = leerRegistros(clase);
		if (lista.size() == 1) {
			return lista.get(0);
		} else {
			if (lista.size() == 0) {
				throw new DAOException("No existe el registro solicitado en " + getNombreTabla());
			} else
				throw new DAOException("Demasiados registros en " + getNombreTabla() + ".Numero->" + lista.size());
		}
	}

	public abstract int actualizarRegistro(T clase) throws DAOException ;

	public abstract int insertarRegistro(T clase) throws DAOException ;
		

	public int borrarRegistro(T clase) throws DAOException {
		String where = obtenWhere(clase);
		String sql = DELETEM + getNombreTabla() + " " + where;
		return RFDataConnection.ejecutar(sql);
	}

	private String obtenWhere(T clase) {
		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}

	public abstract String obtenLista(T clase, String separador);
	
	public String obtenUpdate(T clase) {
		return obtenLista(clase, ",");
	}
	
	public abstract T montaRegistro(ResultSet rs) throws DomainException, DAOException ;
	
	public List<T> montaLista(String sql) throws DAOException, DomainException {
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		List<T> lista = new ArrayList<T>();
		try {
			while (rs.next()) {
				lista.add(montaRegistro(rs));
			}
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen "+ sql);
		}
		return lista;
	}
	public List<T> leerSQL(String where) throws DAOException, DomainException {
		String sql = SELECTM + getNombreTabla() + " WHERE" + where;
		return montaLista(sql);
	}
}

