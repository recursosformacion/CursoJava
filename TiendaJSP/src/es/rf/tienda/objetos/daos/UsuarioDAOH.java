package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.HibernateUtil;
import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Rutinas;

public class UsuarioDAOH extends InterfacesDAO<Usuario> {

	private Session sesion;
	private Transaction tx;

	@Override
	public List<Usuario> leerTodos() throws DAOException {
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from Usuario").list();
		} finally {
			sesion.close();
		}
		return lista;
	}

	@Override
	public List<Usuario> leerRegistros(Usuario clase) throws DAOException {
		String where = obtenWhere(clase);
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from Usuario " + where).list();
		} finally {
			sesion.close();
		}
		return lista;
	}

	@Override
	public Usuario leerRegistro(Usuario clase) throws DAOException {
		List<Usuario> lista = leerRegistros(clase);
		if (lista.size() == 1) {
			return lista.get(0);
		} else
			throw new DAOException("Demasiados registros en Usuarios");
	}

	@Override
	public int actualizarRegistro(Usuario clase) throws DAOException {
		try {
			iniciaOperacion();
			sesion.update(clase);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		return 1;
	}

	@Override
	public int insertarRegistro(Usuario clase) throws DAOException {
		long id = 0;

		try {
			iniciaOperacion();
			sesion.save(clase);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			if (sesion!=null)
				sesion.close();
		}
		return 1;
	}

	@Override
	public int borrarRegistro(Usuario clase) throws DAOException {
		try {
			iniciaOperacion();
			sesion.delete(clase);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		return 1;
	}

	private String obtenWhere(Usuario clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
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

	private void iniciaOperacion() throws HibernateException {
		sesion = HibernateUtil.getSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}
}
