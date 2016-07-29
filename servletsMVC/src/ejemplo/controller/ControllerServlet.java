package ejemplo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejemplo.controller.*;
import ejemplo.interfaces.RequestHandler;

/**
 * Servlet implementation class EjemploServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	Map<String, RequestHandler> controladores;

    /**
	 * Método que se ejecuta durante la inicialización del Servlet (tras su
	 * instanciación).
	 * Inicializa todos aquellos atributos necesarios para ofrecer sus servicios:
	 * 		- controladores: para gestionar las peticiones de servicios
	 * 
	 * @throws ServletException
	 */
	public void init() throws ServletException {
    	
    	// Inicializamos el hashmap
    	controladores = new HashMap<String, RequestHandler>();
    	controladores.put("/res1.do", new Recurso1Handler());
    	controladores.put("/res2.do", new Recurso2Handler());
	}
	
	
    public ControllerServlet() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // Obtenemos el manejador asociado al evento ocurrido
        RequestHandler rh = (RequestHandler) controladores.get(request.getServletPath());
        
       
        // Comprobamos si se obtuvo correctamente el manejador
        if (rh == null) {
            // Mostramos el error en caso de no cargarse correctamente
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            
            // Obtenemos la URL resultante de ejecutar el manejador
            String viewUrl = rh.handleRequest(request, response);
            if (viewUrl == null) {
                // Nada
            } else {
                // El RequestHandler correspondiente nos dira que vista utilizar
                request.getRequestDispatcher(viewUrl).forward(request, response);
            }
        }
    }
    
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
