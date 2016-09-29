package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.HibernateUtil;
import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAOH extends InterfacesDAO<Categoria> {

	private Session sesion;
	private Transaction tx;

	@Override
	public List<Categoria> leerTodos() throws DAOException {
		List<Categoria> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from Categoria").list();
		} finally {
			sesion.close();
		}
		return lista;
	}

	@Override
	public List<Categoria> leerRegistros(Categoria clase) throws DAOException {
		String where = obtenWhere(clase);
		List<Categoria> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from Categoria " + where).list();
		} finally {
			sesion.close();
		}
		return lista;
	}

	@Override
	public Categoria leerRegistro(Categoria clase) throws DAOException {
		List<Categoria> lista = leerRegistros(clase);
		if (lista.size() == 1) {
			return lista.get(0);
		} else
			throw new DAOException("Demasiados registros en Categorias");
	}

	@Override
	public int actualizarRegistro(Categoria clase) throws DAOException {
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
	public int insertarRegistro(Categoria clase) throws DAOException {
		long id = 0;

		try {
			iniciaOperacion();
			sesion.save(clase);
			tx.commit();
			clase.setId_categoria((int) id);
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
	public int borrarRegistro(Categoria clase) throws DAOException {
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

	private String obtenWhere(Categoria clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}

	public String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addSalida(salida, "idCategoria", clase.getId_categoria(), separador);
		}
		if (clase.getCat_nombre() != null && clase.getCat_nombre().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "tituloCategoria", clase.getCat_nombre(), separador);
		}
		return salida;
	}

	private void iniciaOperacion() throws HibernateException {
		sesion = HibernateUtil.getSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurri� un error en la capa de acceso a datos", he);
	}
}
