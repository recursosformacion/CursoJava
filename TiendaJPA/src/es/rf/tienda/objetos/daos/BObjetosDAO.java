package es.rf.tienda.objetos.daos;

import java.util.List;

import org.hibernate.*;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.persister.entity.EntityPersister;

import es.rf.tienda.exception.DAOException;
import es.rf.tienda.util.HibernateUtil;

public abstract class BObjetosDAO<T> {
	private Session sesion;
	private Transaction tx;
	
	private String nombreTabla;

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	public List<T> leerTodos() throws DAOException {
		List<T> lista = null;
		
			iniciaOperacion();
			System.out.println("******************************");
			System.out.println("**********************" + nombreTabla);
			lista = sesion.createQuery("from " + nombreTabla).list();
		
			sesion.close();
		
		return lista;
	}

	public List<T> leerRegistros(T t) throws DAOException {
		String where = obtenWhere(t);
		List<T> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from " + nombreTabla + " " + where).list();
		} finally {
			sesion.close();
		}
		return lista;
	}

	public T leerRegistro(T clase) throws DAOException {
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

	public int actualizarRegistro(T clase) throws DAOException {
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

	public int insertarRegistro(T clase) throws DAOException {
		long id = 0;

		try {
			iniciaOperacion();
			sesion.save(clase);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			if (sesion != null)
				sesion.close();
		}
		return 1;
	}

	public int borrarRegistro(T clase) throws DAOException {
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

	private String obtenWhere(T clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}

	public abstract String obtenLista(T clase, String separador);
//*****************************************************************Hibernate
	private void iniciaOperacion() throws HibernateException {
		sesion = HibernateUtil.getSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}
//*****************************************************************************
	/**
	 * Determinar nombre de tabla
	 */
	
	public String nombreTabla(){
		String tableName ="";
		ClassMetadata hibernateMetadata = ((EntityPersister) sesion).getClassMetadata();
	
		if (hibernateMetadata == null)
		{
		    return "";
		}
	
		if (hibernateMetadata instanceof AbstractEntityPersister)
		{
		     AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
		     tableName = persister.getTableName();
		     
		}
		return tableName;
	}
}
