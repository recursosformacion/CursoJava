package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.RFDataConnection;

public class UsuarioDAO implements InterfacesDAO<Usuario> {
	
	public Usuario montarRegistro(ResultSet rs){
		Usuario nuevo = new Usuario();
		try {
			nuevo.setId_usuario(rs.getInt("id_usuario"));
			nuevo.setUser_nombre(rs.getString("User_nombre"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nuevo;
	}
	@Override
	public List<Usuario> leerTodos() throws DAOException {
		String sql = "SELECT * FROM USUARIOS";
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			while (rs.next()){
				Usuario mio = montarRegistro(rs);
				lista.add(mio);
				
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Usuario> leerRegistros(Usuario clase) throws DAOException {
		
		
		return null;
	}

	// select * from usuarios where ID_usuario = 7
	@Override
	public Usuario leerRegistro(Usuario clase) throws DAOException {
		String sql = "SELECT * FROM USUARIOS WHERE ID_USUARIO = ";
		sql = sql + clase.getId_usuario();
		System.out.println("------>"+sql);
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		try {
			rs.next();
			
			
			return montarRegistro(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	// UPDATE USUARIO SET USER_NOMBRE='nombre', USER_EMAIL= 'jjjjjjjjjj',.....WHERE ID_USUARIO=7
	@Override
	public int actualizarRegistro(Usuario clase) throws DAOException {
		String sql = "UPDATE USUARIO SET ";
		sql  = sql + "user_nombre = '";
		sql = sql + clase.getUser_nombre();
		sql = sql + "', USER_EMAIL='";
		sql = sql + clase.getUser_email();
		
    
		return RFDataConnection.ejecutar(sql);
	}

	@Override
	public int insertarRegistro(Usuario clase) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarRegistro(Usuario clase) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
