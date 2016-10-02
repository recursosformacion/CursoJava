package es.rf.tienda.objetos.daos;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.ParentDAO;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAO extends ParentDAO<Categoria> {
	public CategoriaDAO(){
		setNombreTabla("Categoria");
	}
	@Override
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

}
