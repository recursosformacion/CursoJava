package ejemplo.controller;

import ejemplo.interfaces.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Recurso2Handler implements RequestHandler{
    public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String mensaje = "Mensaje lanzado desde el manejador Recurso1"; 
        session.setAttribute("mensaje", mensaje);
//        req.setAttribute("mensaje", mensaje);
        return "Recurso2.jsp";

}

}