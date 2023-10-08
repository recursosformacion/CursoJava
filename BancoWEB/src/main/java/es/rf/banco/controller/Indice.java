package es.rf.banco.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.rf.banco.model.Logon;

@Controller
public class Indice {

	@RequestMapping(value = {"/","/indice"}, method = RequestMethod.GET)
	public String menu(Logon dato, HttpSession session){
		if (session.getAttribute("logon") != null){
			dato = (Logon) session.getAttribute("logon");
			return "indice";
		}
		else
			return "redirect:logon";
	}
}
