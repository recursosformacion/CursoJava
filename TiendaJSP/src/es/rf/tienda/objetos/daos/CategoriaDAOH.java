package es.rf.tienda.objetos.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.HibernateUtil;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAOH extends InterfacesDAO<Categoria> {

	private Session sesion;
	private Transaction tx;

	public CategoriaDAOH(){
		setNombreTabla("Categoria");
	}

	public String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addSalida(salida, "id_Categoria", clase.getId_categoria(), separador);
		}
		if (clase.getCat_nombre() != null && clase.getCat_nombre().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "cat_nombre", clase.getCat_nombre(), separador);
		}
		return salida;
	}

	

	
}
