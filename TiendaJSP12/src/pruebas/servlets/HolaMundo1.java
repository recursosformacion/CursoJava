package pruebas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class holaMundo1
 */
public class HolaMundo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundo1() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<UserMio> lista = new ArrayList<UserMio>();
		PrintWriter out = response.getWriter();
		HttpSession sesion = request.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		
		String nu = request.getParameter("nombreUsuario");
		response.setContentType("text/html");
		out.println("Bienvenido " + nu + "<br/>");
		
		if (sesion.getAttribute("lista")!=null){
			lista=(ArrayList<UserMio>) sesion.getAttribute("lista");
		}
		UserMio usm = new UserMio();
		usm.setNombre(nu);
		usm.setHora(sdf.format(new Date()));
		lista.add(usm);
		sesion.setAttribute("lista",lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("hm.jsp");
		if (dispatcher != null) dispatcher.forward(request, response);


		
		
	}

	
}
