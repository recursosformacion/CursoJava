package es.rf.tienda.interfaces.daos;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

public interface InterfacesDAO<T> {
	
	/**
	 * Muestra todas las categorias
	 * @return 
	 * @throws DAOException
	 */
	public List<T> leerTodos() throws DAOException;
	public List<T> leerRegistros(T clase) throws DAOException;
	
	/**
	 * Devuelve una Categoria con el id que se le indica; si no existe, devuelve null
	 * @param idCategoria
	 * @return
	 * @throws DAOException
	 */
	public T leerRegistro(T clase) throws DAOException;
	
	/**
	 * Actualiza la base de datos con el registro que se le pasa
	 * @param categoria
	 * @return
	 * @throws DAOException
	 */
	public int actualizarRegistro(T clase) throws DAOException;
	
	/**
	 * Inserta en la base de datos el registro que se le pasa; devuelve
	 * el objeto con el id que le ha correspondido
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
	 * Borra de la tabla de categoria el registro correspondiente al
	 * objeto que le pasan
	 * 
	 * @param categoria
	 * @return
	 * @throws DAOException
	 */
	
	
	
}
