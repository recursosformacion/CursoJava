package es.rf.tienda.service.impl;

import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.UserDAO;
import es.rf.tienda.service.interfaces.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	public UserDAO getUserDao() {
		return this.userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean isValidUser(String username, String password) throws DAOException {
		return userDao.isValidUser(username, password);
	}

}
