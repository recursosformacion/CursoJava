package es.rf.tienda.objetos.daos;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Pais;
import es.rf.tienda.util.Rutinas;

public class PaisDAOH extends BObjetosDAO<Pais> {

	public PaisDAOH(){
		setNombreTabla("Pais");
	}
	

	public String obtenLista(Pais clase, String separador) {
		String salida = "";
		if (clase.getId_pais() > 0) {
			salida = Rutinas.addCampo(salida, "id_pais", clase.getId_pais(), separador);
		}
		if ((clase.getPais_nombre() != null && clase.getPais_nombre().compareTo("") != 0) || separador.equals(",")){
			salida = Rutinas.addCampo(salida, "cat_nombre", clase.getPais_nombre(), separador);
		}
		
		return salida;
	}


	
}
