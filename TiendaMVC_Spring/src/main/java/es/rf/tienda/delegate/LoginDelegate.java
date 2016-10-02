package es.rf.tienda.delegate;

import es.rf.tienda.exception.DAOException;
import es.rf.tienda.service.interfaces.UserService;

public class LoginDelegate {
	private UserService userService;

	public UserService getUserService() {
		return this.userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public boolean isValidUser(String username, String password) throws DAOException {
		return userService.isValidUser(username, password);
	}
}