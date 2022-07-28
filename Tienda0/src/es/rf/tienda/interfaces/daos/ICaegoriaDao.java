package es.rf.tienda.interfaces.daos;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

public interface ICaegoriaDao {
	
	public Categoria leerRegistro(Categoria cat) throws DAOException;
	public List<Categoria> leerTodos();
	public List<Categoria> leerRegistros(Categoria cat);
	public int insertar(Categoria cat);
	public int actualizar(Categoria cat);
	public int borrar(Categoria cat);
	
	

}
