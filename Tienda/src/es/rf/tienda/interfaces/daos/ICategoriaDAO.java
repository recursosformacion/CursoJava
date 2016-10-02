package es.rf.tienda.interfaces.daos;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

public interface ICategoriaDAO {
/**
 * Recibe un objeto categoria con los campos que se desea utilizar para la lectura
 * llenos.
 * 
 * @param c
 * @return
 * @throws DAOException 
 */
	public Categoria leer(Categoria c) throws DAOException;
	public int insertar(Categoria c) throws DAOException;
	public int actualizar(Categoria c) throws DAOException;
	public int borrar (Categoria c) throws DAOException;
	public List<Categoria> leerTodos() throws DAOException;
	public List<Categoria> leerVarios(Categoria c) throws DAOException;
	
}
