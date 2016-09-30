package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.ICategoriaDAO;
import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Validator;

public class CategoriaDAO1 implements ICategoriaDAO {

	@Override
	public Categoria leer(Categoria c) throws DAOException {
		String and = "";
		String sql = "SELECT * FROM Categoria WHERE ";
		if (c.getId_categoria() > 0) {
			sql += and + " id_categoria = " + c.getId_categoria();
			and = " AND ";
		}
		if (!Validator.isVacio(c.getCat_nombre())) {
			sql += and + " Cat_nombre = " + c.getCat_nombre();
			and = " AND ";
		}
		if (!Validator.isVacio(c.getCat_descripcion())) {
			sql += and + " Cat_descripcion = " + c.getCat_descripcion();
			and = " AND ";
		}
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);

		try {
			if (rs.next()) {
				if (rs.isLast()) {
					return construirCategoria(rs);
				} else
					throw new DAOException("Demasiados registros en " + sql);
			} else
				throw new DAOException("No hay ningun resultado"+ sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error en " + sql);
		}
	}

	@Override
	public int insertar(Categoria c) throws DAOException {
		c.setId_categoria(RFDataConnection.consigueClave("Categoria","id_Categoria"));
		if (c.isValid()) {
			String sql = "INSERT INTO Categoria VALUES ";
			String lista = "";
			lista += c.getId_categoria();
			lista += ",";
			lista += entraString(c.getCat_nombre());
			lista += ",";
			lista += entraString(c.getCat_descripcion());
			sql += "(" + lista + ")";
			return RFDataConnection.ejecutar(sql);
		} else
			return 0;
	}

	
	@Override
	public int actualizar(Categoria c) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrar(Categoria c) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Categoria> leerTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> leerVarios(Categoria c) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	private Categoria construirCategoria(ResultSet rs) throws DAOException {
		Categoria cs = new Categoria();
		try {
			cs.setId_categoria(rs.getInt("id_categoria"));
			cs.setCat_nombre(rs.getString("Cat_nombre"));
			cs.setCat_descripcion(rs.getString("Cat_descripcion"));
			return cs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error en lectura");
		}

	}
	public String entraString(String s){
		if (s!=null && !Validator.isVacio(s)){
			return "'"+s+"'";
		}
		return "null";
	}
}