package es.rf.tienda.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.rf.tienda.delegate.LoginDelegate;
import es.rf.tienda.formularios.LoginBean;

@Controller
public class LoginController
{
		@Autowired
		private LoginDelegate loginDelegate;

		@RequestMapping(value="/login",method=RequestMethod.GET)
		public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean)
		{
			ModelAndView model = new ModelAndView("login");
			//LoginBean loginBean = new LoginBean();
			model.addObject("loginBean", loginBean);
			return model;
		}
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
		{
				ModelAndView model= null;
				try
				{
						boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
						if(isValidUser)
						{
								System.out.println("Usuario autentificado");
								request.setAttribute("loggedInUser", loginBean.getUsername());
								model = new ModelAndView("bienvenido");
						}
						else
						{
								model = new ModelAndView("login");
								request.setAttribute("message", "Credenciales erroneos!!");
						}

				}
				catch(Exception e)
				{
						e.printStackTrace();
				}

				return model;
		}
}

