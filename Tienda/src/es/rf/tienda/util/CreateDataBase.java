package es.rf.tienda.util;

import es.rf.tienda.exception.DAOException;

public class CreateDataBase {

	final static String creaCategoria = "CREATE TABLE CATEGORIA "
										+ "("
										+ " ID_CATEGORIA NUMBER NOT NULL " 
										+ ", CAT_NOMBRE VARCHAR2(50) NOT NULL "
										+ ", CAT_DESCRIPCION VARCHAR2(200) "
										+ ", CONSTRAINT CATEGORIA_PK PRIMARY KEY " 
										+ " ("
										+ "   ID_CATEGORIA "
										+ "  )"
										+ "  ENABLE "
										+ ")";
	
	final static String creaUsuario = "CREATE TABLE USUARIOS "
									  + "("
									  + "  ID_USUARIO INT NOT NULL "
									  + ", USER_NOMBRE VARCHAR2(100) NOT NULL "
									  + ", USER_EMAIL VARCHAR2(100) NOT NULL "
								 	  + ", USER_PASS VARCHAR2(20) NOT NULL "
							  		  + ", USER_TIPO NUMBER NOT NULL "
									  + ", USER_DNI VARCHAR2(12) "
									  + ", USER_FECALTA DATE "
									  + ", USER_FECCONFIRMACION DATE "
									  + ", CONSTRAINT USUARIOS_PK PRIMARY KEY "
									  + "  ("
									  + "    ID_USUARIO "
									  + "  )"
									  + "  ENABLE "
									  + ")";
	
												
	public static void main(String[] args) throws DAOException {
		RFDataConnection.ejecutar(creaCategoria);
		RFDataConnection.ejecutar(creaUsuario);

	}

}
