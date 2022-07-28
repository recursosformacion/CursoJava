package es.rf.tienda.interfaces.daos;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;

public interface ICategoria {

	public boolean guardar(Categoria c) throws DAOException;
	public boolean actualiza(Categoria c) throws DAOException;
	public boolean borra(Categoria c) throws DAOException;
	
	public Categoria leer(Categoria c) throws DAOException, DomainException;
	public List<Categoria> listarTodos() throws DAOException, DomainException;
	public List<Categoria> listar(Categoria c) throws DAOException, DomainException;
	public List<Categoria> leerSQL(String where) throws DAOException, DomainException;
}
