package rf.prueba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecibeLista
 */
@WebServlet("/HolaMundoCordial")
public class RecibeLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecibeLista() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//Buscamos el listado en la sesión, y en caso de que no exista, lo instanciamos
		Vector<String> listado = (Vector<String>)request.getSession().getAttribute("listado");
		if ( listado == null )
		{
			listado = new Vector<String>();
		}
		//Añadimos el visitante al listado en caso de que hayamos recibido su nombre
		if ( (String)request.getParameter("NOMBRE") != null )
		{
			listado.addElement((String)request.getParameter("NOMBRE"));
		}
		request.getSession().setAttribute("listado",listado);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listado.jsp");

		if (dispatcher != null) dispatcher.forward(request, response);


		
	}

}
