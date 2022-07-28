package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.interfaces.daos.ICategoria;

import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAO implements ICategoria {

	private static final String SELECT = "SELECT * FROM Categoria ";
	private static final String UPDATE = "UPDATE  Categoria SET ";
	private static final String INSERT = "INSERT INTO  Categoria VALUES ";
	private static final String DELETE = "DELETE FROM Categoria ";

	
	@Override
	public List<Categoria> listarTodos() throws DAOException, DomainException  {
		String sql = SELECT;
		return montaLista(sql);
	}

	@Override
	public List<Categoria> listar(Categoria clase) throws DAOException, DomainException {
		String where = obtenWhere(clase);
		String sql = SELECT + where;
		return montaLista(sql);
	}

	@Override
	public Categoria leer(Categoria clase) throws  DomainException, DAOException {
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
			throw new DAOException("Error " + e.getMessage() + "\nen " + sql);
		}

	}

	@Override
	public boolean actualiza(Categoria clase) throws DAOException {
		String where = " WHERE id_Categoria = " + clase.getId_categoria();
		int tmp = clase.getId_categoria();
		clase.setId_categoria(0);
		String update = obtenUddate(clase);
		clase.setId_categoria(tmp);
		String sql = UPDATE + update + where;
		return RFDataConnection.ejecutar(sql)>1;
	}

	@Override
	public boolean guardar(Categoria clase) throws DAOException {
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
		return true;
	}
	

	@Override
	public boolean borra(Categoria clase) throws DAOException {
		String where = obtenWhere(clase);
		String sql = DELETE + where;
		return RFDataConnection.ejecutar(sql)>0;
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
		salida = Rutinas.addCampo(salida, "Id_categoria", clase.getId_categoria(), separador);
		salida = Rutinas.addCampo(salida, "Cat_nombre", clase.getCat_nombre(), separador);
		salida = Rutinas.addCampo(salida, "Cat_Descripcion", clase.getCat_descripcion(), separador);
		return salida;
	}

	private Categoria montaRegistro(ResultSet rs) throws DomainException, DAOException {
		Categoria salida = new Categoria();
		try {
			salida.setId_categoria(rs.getInt("Id_categoria"));

			salida.setCat_nombre(rs.getString("Cat_nombre"));
			salida.setCat_descripcion(rs.getString("Cat_descripcion"));
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen montaRegistro" );
		}
		return salida;
	}

	private List<Categoria> montaLista(String sql) throws DAOException, DomainException {
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			while (rs.next()) {
				lista.add(montaRegistro(rs));
			}
		
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen "+ sql);
	
		}
		return lista;
	}

	@Override
	public List<Categoria> leerSQL(String where) throws DAOException, DomainException {
		String sql = SELECT + "WHERE" + where;
		return montaLista(sql);
	}

	

	

}
