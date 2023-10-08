package es.rf.banco.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.rf.banco.model.Logon;
import es.rf.banco.servicio.ControlAcceso;

@Controller
public class LogonController {

	public static final String FORMULARIO_LOGON = "logon/formulario";
	public static final String CONTROLADOR_INDICE = "redirect:indice";
	
	@RequestMapping(value = "/logon", method = RequestMethod.GET)
	public String presentaForm (ModelMap model ){
		model.addAttribute("formLogon", new Logon());
		return FORMULARIO_LOGON;
	}
	
	@RequestMapping(value = "/logon", method = RequestMethod.POST)
	public String recibeForm(@Valid Logon dato,BindingResult bdr, HttpSession session,ModelMap model) {
		if (bdr.hasErrors())
			return FORMULARIO_LOGON;
		System.out.println("sin errores*************************************");
		System.out.println(dato.getUsuario());
		System.out.println(dato.getPassword());
		if (ControlAcceso.valida(dato)) {
			session.setAttribute("logon", dato);
			return CONTROLADOR_INDICE;
		}
		else{
			model.addAttribute("formLogon",dato);
			return FORMULARIO_LOGON;
		}
	}
}







