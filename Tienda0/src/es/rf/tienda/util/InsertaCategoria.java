package es.rf.tienda.util;

import es.rf.tienda.exception.DAOException;

public class InsertaCategoria {

	public static void main(String[] args) throws DAOException {
		
		for (int a = 0; a < 10; a++) {
			int clave = RFDataConnection.consigueClave("Categorias", "id_categoria");
			RFDataConnection.ejecutar(
					"INSERT INTO CATEGORIAS VALUES(" + clave
							+ ",'Categoria "+clave+"','Descripcion de la categoria " + clave+"')");
		}
		RFDataConnection.commit();
	}

}
