package es.rf.tienda.interfaces.daos;

import java.util.List;

import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;

public interface InterfacesDAO<T> {
	
	/**
	 * Muestra todas las categorias
	 * @return 
	 * @throws DAOException
	 * @throws DomainException 
	 */
	public List<T> leerTodos() throws DAOException, DomainException;
	public List<T> leerRegistros(T clase) throws DAOException, DomainException;
	
	/**
	 * Devuelve una Categoria con el id que se le indica; si no existe, devuelve null
	 * @param idCategoria
	 * @return
	 * @throws DAOException
	 * @throws DomainException 
	 */
	public T leerRegistro(T clase) throws DAOException, DomainException;
	
	/**
	 * Actualiza la base de datos con el registro que se le pasa
	 * @param categoria
	 * @return
	 * @throws DAOException
	 */
	public int actualizarRegistro(T clase) throws DAOException;
	
	/**
	 * Inserta en la base de datos el registro que se le pasa, modificandolo con
	 * el id con el que se ha grabado en la BBDD; devuelve
	 * el numeri de registros afectados
	 * @param categoria
	 * @return
	 * @throws DAOException
	 */
	public int insertarRegistro(T clase) throws DAOException;
	
	/**
	 * Borra un registro de categoria que recibe como id
	 * @param idCategoria
	 * @return
	 * @throws DAOException
	 */
	public int borrarRegistro(T clase) throws DAOException;
	
	/**
	 * Le añade la parte "SELECT * FROM tabla WHERE
	 * 
	 * @param categoria
	 * @return
	 * @throws DomainException 
	 * @throws DAOException
	 */
	
	public List<T> leerSQL(String where) throws DAOException, DomainException;
	
}
