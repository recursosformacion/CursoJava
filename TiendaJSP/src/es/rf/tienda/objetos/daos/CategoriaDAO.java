package es.rf.tienda.objetos.daos;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAO extends InterfacesDAO<Categoria> {
	public CategoriaDAO(){
		setNombreTabla("Categoria");
	}
	@Override
	/**
	 * Recibe un objeto Categoria y genera una string con los datos pasados y el
	 * separador que se le indique (normalmente sera ',' para inserts, updates y
	 * la palabra 'AND' para condiciones WHERE
	 * 
	 * @param clase
	 * @param separador
	 * @return
	 */

	public String obtenLista(Categoria clase, String separador) {
		String salida = "";
		
		salida = Rutinas.addSalida(salida, "id_Categoria", clase.getId_categoria(), separador);
	
		if (clase.getCat_nombre() != null && clase.getCat_nombre().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "Cat_nombre", clase.getCat_nombre(), separador);
		}
		return salida;
	}

}
