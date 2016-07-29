package es.rf.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import es.rf.tienda.dominio.Usuario;

/* ***************************************************************************************
 * NOMBRE: LoginController                                                                 *
 * 
 * DESCRIPCIÓN: *//**
 * 			Controlador para el evento de Logueo
 */
/*
 * @version Enero 2016
 * 
 * @author Miguel Garcia- Barcelona
 * 
 * **************************************************************************************/

@Controller
public class LoginController 
{
	
	/* ***************************************************************************************
	 * NOMBRE: login                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 			Obtener la página para loguearse en la web
	 */
	/*
	 * FECHA: Enero 2016
	 * 
	 * AUTOR: Miguel Garcia- Barcelona
	 * 
	 * **************************************************************************************/	
	
	@RequestMapping(value="_login.html",
			method=RequestMethod.GET)
	public ModelAndView login()
	{
		return new ModelAndView("Login.jsp", 
				"command", new Usuario());
	}

}
