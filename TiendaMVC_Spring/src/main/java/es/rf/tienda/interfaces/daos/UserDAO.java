package es.rf.tienda.interfaces.daos;

import es.rf.tienda.exception.DAOException;

public interface UserDAO {

		public boolean isValidUser(String username, 
				String password) throws DAOException;

}
