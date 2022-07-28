package es.rf.tienda.objetos.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.interfaces.daos.ICaegoriaDao;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.Conexion;
import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Rutinas;
import es.rf.tienda.util.Validator;

public class CategoriaMDAO implements InterfacesDAO<Categoria> {
	
	private final String SELECT = "SELECT * FROM categoria ";
	

	public Categoria leerRegistro(Categoria cat) throws DAOException, DomainException  {
		//String sql = SELECT + " WHERE id_categoria = " + cat.getId_categoria();
		String res = obtenwhere(cat);
		String sql = SELECT + " WHERE " + res;
		
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		
		try {
			rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error leyendo");
		} //comprobar si solo es un registro
		Categoria nueva = new Categoria();
		try {
			nueva.setId_categoria(rs.getInt("id_categoria"));
			nueva.setCat_nombre(rs.getString("cat_nombre"));
			nueva.setCat_descripcion(rs.getString("cat_descripcion"));			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error leyendo");
			
		}
		
		
		return nueva;
	}


	public String obtenwhere(Categoria cat){
		//WHERE id_categoria = " + cat.getId_categoria()
		String salida="";
		if (cat.getId_categoria()!=0)
			salida = Rutinas.addCampo(salida, "id_categoria", cat.getId_categoria(), "AND");
		if (!Validator.isVacio(cat.getCat_nombre()))
			salida = Rutinas.addCampo(salida, "Cat_nombre", cat.getCat_nombre(), "AND");
		if (salida.length()>0)
			salida = " WHERE " +salida;
		return salida;
	}


	public List<Categoria> leerTodos() throws DAOException, DomainException {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Categoria> leerRegistros(Categoria clase) throws DAOException, DomainException {
		// TODO Auto-generated method stub
		return null;
	}


	public int actualizarRegistro(Categoria clase) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}


	public int insertarRegistro(Categoria clase) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}


	public int borrarRegistro(Categoria clase) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<Categoria> leerSQL(String where) throws DAOException, DomainException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
