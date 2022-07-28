package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAO extends BObjetosDAO<Categoria> {

	private static final String UPDATE = "UPDATE  Categoria SET ";
	private static final String INSERT = "INSERT INTO  Categoria VALUES ";

	public CategoriaDAO(){
		setNombreTabla("Categoria");
	}
	
	@Override
	public int actualizarRegistro(Categoria clase) throws DAOException {
		String where = "WHERE id_Categoria = " + clase.getId_categoria();
		int tmp = clase.getId_categoria();
		clase.setId_categoria(0);
		String update = obtenUpdate(clase);
		clase.setId_categoria(tmp);
		String sql = UPDATE + update + where;
		return RFDataConnection.ejecutar(sql);
	}

	@Override
	public int insertarRegistro(Categoria clase) throws DAOException {
		String salida = "";
		clase.setId_categoria(RFDataConnection.consigueClave("Categoria", "id_Categoria"));
		salida = Rutinas.addCampo(salida, "", clase.getId_categoria(), ",");
		salida = Rutinas.addCampo(salida, "", clase.getCat_nombre(), ",");
		salida = Rutinas.addCampo(salida, "", clase.getCat_descripcion(), ",");
		String sql = INSERT + "(" + salida + ")";
		System.out.println(sql);
		int ret = RFDataConnection.ejecutar(sql);
		if (ret == 0)
			throw new DAOException("Error en " + sql);
		return ret;
	}


	public String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0)
			salida = Rutinas.addCampo(salida, "id_categoria", clase.getId_categoria(), separador);
		if (clase.getCat_nombre().length() > 0)
			salida = Rutinas.addCampo(salida, "Cat_nombre", clase.getCat_nombre(), separador);

		return salida;
	}

	public Categoria montaRegistro(ResultSet rs) throws DomainException, DAOException {
		Categoria salida = new Categoria();
		try {
			salida.setId_categoria(rs.getInt("Id_categoria"));

			salida.setCat_nombre(rs.getString("Cat_nombre"));
			salida.setCat_descripcion(rs.getString("Cat_descripcion"));
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen montaRegistro");
		}
		return salida;
	}

}
