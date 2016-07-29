package es.rf.tienda.objetos.daos;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAO extends InterfacesDAO<Categoria> {
	public CategoriaDAO(){
		setNombreTabla("Categoria");
	}
	@Override
	public String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getIdCategoria() > 0) {
			salida = Rutinas.addSalida(salida, "idCategoria", clase.getIdCategoria(), separador);
		}
		if (clase.getTituloCategoria() != null && clase.getTituloCategoria().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "tituloCategoria", clase.getTituloCategoria(), separador);
		}
		return salida;
	}

}
