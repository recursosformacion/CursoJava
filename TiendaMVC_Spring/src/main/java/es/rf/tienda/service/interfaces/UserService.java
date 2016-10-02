package es.rf.tienda.service.interfaces;

import es.rf.tienda.exception.DAOException;

/**
 * Implementacion usuario valido
 * 
 * @author Miguel Garcia
 *
 */
public interface UserService {
	public boolean isValidUser(String username, String password) throws  DAOException;
}