package pruebas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.objetos.daos.CategoriaDAO;
import es.rf.tienda.objetos.daos.CategoriaDAOH;
import es.rf.tienda.objetos.daos.UsuarioDAOH;

/**
 * Servlet implementation class ListCategoria
 */
@WebServlet("/ListCategoria")
public class ListCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoriaDAOH cDAO = new CategoriaDAOH();
		
		List<Categoria> lista=null;
		try {
			lista = cDAO.leerTodos();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("lisCategoria", lista);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listarCategorias.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
