package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Rutinas;
import es.rf.tienda.util.Validator;

public class CategoriaDAO implements InterfacesDAO<Categoria> {

	private static final String SELECT = "SELECT * FROM Categoria ";
	private static final String UPDATE = "UPDATE  Categoria SET ";
	private static final String INSERT = "INSERT INTO  Categoria VALUES ";
	private static final String DELETE = "DELETE FROM Categoria ";

	@Override
	public List<Categoria> leerTodos() throws DAOException {
		String sql = SELECT;
		return montaLista(sql);
	}

	@Override
	public List<Categoria> leerRegistros(Categoria clase) throws DAOException {
		String where = obtenWhere(clase);
		String sql = SELECT + where;
		return montaLista(sql);
	}

	@Override
	public Categoria leerRegistro(Categoria clase) throws DAOException {
		String where = obtenWhere(clase);
		String sql = SELECT + where;
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);

		try {
			rs.next();
			if (rs.isLast()) {
				return montaRegistro(rs);
			} else
				throw new DAOException("Demasiados registros en " + sql);
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DAOException("Error en " + sql);
		}

	}

	@Override
	public int actualizarRegistro(Categoria clase) throws DAOException {
		int clave = clase.getId_categoria();
		String where = "WHERE idCategoria = " + clave;
		clase.setId_categoria(0);
		String update = obtenUddate(clase);
		clase.setId_categoria(clave);
		String sql = UPDATE + update + where;
		return RFDataConnection.ejecutar(sql);
	}

	@Override
	public int insertarRegistro(Categoria clase) throws DAOException {
		String salida = "";
		clase.setId_categoria(RFDataConnection.consigueClave("Categoria", "idCategoria"));
		salida = Rutinas.addSalida(salida, "", clase.getId_categoria(), ",");
		salida = Rutinas.addSalida(salida, "", clase.getCat_nombre(), ",");
		salida = Rutinas.addSalida(salida, "", clase.getCat_descripcion(), ",");
		String sql = INSERT + "(" + salida + ")";
		System.out.println(sql);
		int ret = RFDataConnection.ejecutar(sql);
		if (ret == 0)
			throw new DAOException("Error en " + sql);
		return ret;
	}

	@Override
	public int borrarRegistro(Categoria clase) throws DAOException {
		String where = obtenWhere(clase);
		String sql = DELETE + where;
		return RFDataConnection.ejecutar(sql);
	}

	private String obtenWhere(Categoria clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}

	private String obtenUddate(Categoria clase) {

		return obtenLista(clase, ",");
	}

	private String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addSalida(salida, "id_Categoria", clase.getId_categoria(), separador);
		}
		if (!Validator.isVacio(clase.getCat_nombre())) {
			salida = Rutinas.addSalida(salida, "Cat_nombre", clase.getCat_nombre(), separador);
		}
		if (!Validator.isVacio(clase.getCat_descripcion())) {
			salida = Rutinas.addSalida(salida, "Cat_descripcion", clase.getCat_descripcion(), separador);
		}
		return salida;
	}

	private Categoria montaRegistro(ResultSet rs) throws SQLException {
		Categoria salida = new Categoria();
		salida.setId_categoria(rs.getInt("id_Categoria"));
		salida.setCat_nombre(rs.getString("Cat_nombre"));
		salida.setCat_descripcion(rs.getString("Cat_Descripcion"));
		return salida;
	}

	private List<Categoria> montaLista(String sql) throws DAOException {
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		List<Categoria> lista = new ArrayList<Categoria>();
		if (rs != null) {
			try {
				while (rs.next()) {
					lista.add(montaRegistro(rs));
				}
			} catch (SQLException e) {

				e.printStackTrace();
				throw new DAOException("Error en " + sql);
			}
		}
		return lista;
	}

}
