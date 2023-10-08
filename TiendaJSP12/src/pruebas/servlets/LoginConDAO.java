package pruebas.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.objetos.daos.UsuarioDAOH;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginCDAO")
public class LoginConDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginConDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsuarioDAOH uDAO = new UsuarioDAOH();
		String user = request.getParameter("usuario");
		String pwd = request.getParameter("password");
		
		Usuario clase = new Usuario();
		clase.setUser_email(user);
		Usuario us;
		try {
			us = uDAO.leerRegistro(clase);
		} catch (DAOException e) {
			us = new Usuario();
		}
		
		if (us.getUser_email().equals(user) && us.getUser_pass().equals(pwd)) {
			//******************************************************* Session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//ajustar sesion para que expire en 30 mins
			session.setMaxInactiveInterval(30*60);
			//****************************************************** Cookie
			Cookie loginCookie = new Cookie("user", user);
			// ajustar cookies para que expire en 30 mins
			loginCookie.setMaxAge(30 * 60);
			response.addCookie(loginCookie);
			//***************************************************** Comun
			response.sendRedirect("/index.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Error de identificacion.</font>");
			rd.include(request, response);
		}

	}

}
