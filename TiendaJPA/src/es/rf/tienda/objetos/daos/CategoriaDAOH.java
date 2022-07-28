package es.rf.tienda.objetos.daos;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAOH extends BObjetosDAO<Categoria> {

	CategoriaDAOH(){
		setNombreTabla("Categoria");
	}
	

	public String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addCampo(salida, "id_Categoria", clase.getId_categoria(), separador);
		}
		if ((clase.getCat_nombre() != null && clase.getCat_nombre().compareTo("") != 0) || separador.equals(",")){
			salida = Rutinas.addCampo(salida, "cat_nombre", clase.getCat_nombre(), separador);
		}
		if ((clase.getCat_descripcion() != null && clase.getCat_descripcion().compareTo("") != 0) || separador.equals(",")){
			salida = Rutinas.addCampo(salida, "cat_descripcion", clase.getCat_descripcion(), separador);
		}
		return salida;
	}


	
}
