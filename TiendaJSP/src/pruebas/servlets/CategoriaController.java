package pruebas.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.objetos.daos.CategoriaDAOH;
import es.rf.tienda.util.Validator;

/**
 * Servlet implementation class ListCategoria
 */

public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAOH cDAO = new CategoriaDAOH();
	private String error = "";
	private String continuar = "";
	private String letrero = "Enviar";
	private String modo = "";
	private boolean readOnly = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriaController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		String id = request.getParameter("id_categoria");

		if (op == null || op.equals(""))
			continuar = listado(request, response);
		else {
			Categoria gestor = new Categoria();
			// -------------------------------------compruebo si ha llegado
			// id_categoria
			int id_categoria = 0;
			if (id != null && Validator.isNumeric(id))
				id_categoria = Integer.parseInt(id);
			gestor.setId_categoria(id_categoria);

			switch (op) {

			case "borrar":
				readOnly = true;
				modo = "delete";
				letrero = "Borrar";
				try {
					request.setAttribute("objCate", cDAO.leerRegistro(gestor));
				} catch (DAOException e) {
					error = e.getMessage();
				}
				continuar = "listados/formulario.jsp";
				break;
			case "editar":
				readOnly = false;
				modo = "update";
				letrero = "Actualizar";
				try {
					request.setAttribute("objCate", cDAO.leerRegistro(gestor));
				} catch (DAOException e) {
					error = e.getMessage();
				}
				continuar = "listados/formulario.jsp";
				break;
			case "insertar":
				readOnly = false;
				modo = "add";
				letrero = "A�adr";
				request.setAttribute("objCate", new Categoria());
				continuar = "listados/formulario.jsp";
				break;

			default:
				continuar = listado(request, response);
			}

		}

		request.setAttribute("Mensajes", error);
		request.setAttribute("Letrero", letrero);
		request.setAttribute("Visibilidad", readOnly);
		request.setAttribute("modo", modo);
		request.getRequestDispatcher(continuar).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		String id = request.getParameter("id_categoria");

		if (!(op == null || op.equals(""))) {

			Categoria gestor = new Categoria();
			int id_categoria = 0;
			if (id != null && Validator.isNumeric(id))
				id_categoria = Integer.parseInt(id);

			gestor.setId_categoria(id_categoria);
			if (request.getParameter("cat_nombre") != null)
				gestor.setCat_nombre(request.getParameter("cat_nombre"));
			if (request.getParameter("cat_descripcion") != null)
				gestor.setCat_descripcion(request.getParameter("cat_descripcion"));

			switch (op) {

			case "update":
				System.out.println("Update");
				try {
					cDAO.actualizarRegistro(gestor);
				} catch (DAOException e) {
					error = e.getMessage();
				}
				break;

			case "delete":
				System.out.println("Delete");
				try {
					cDAO.borrarRegistro(gestor);
				} catch (DAOException e) {
					error = e.getMessage();
				}
				break;

			case "add":
				System.out.println("Alta");
				try {
					cDAO.insertarRegistro(gestor);
				} catch (DAOException e) {
					error = e.getMessage();
				}
				break;
			}
		}
		continuar = listado(request, response);
		request.setAttribute("Mensajes", error);
		request.setAttribute("Letrero", letrero);
		request.setAttribute("Visibilidad", readOnly);
		request.getRequestDispatcher(continuar).forward(request, response);

	}

	public String listado(HttpServletRequest req, HttpServletResponse resp) {
		List<Categoria> lista = null;
		try {
			lista = cDAO.leerTodos();
		} catch (DAOException e) {

			e.printStackTrace();
		}
		req.setAttribute("lisCategoria", lista);
		return "/listados/listadoCategoria.jsp";
	}
}
