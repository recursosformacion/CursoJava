package es.rf.banco.controller;

import java.io.IOException;
import java.util.Vector;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.rf.banco.model.CuentaMo;
import es.rf.banco.servicio.Cuentas;

@Controller
@RequestMapping("/cuentas")
public class CuentaController {

	public final String FORM_CUENTA = "cuenta/formAlta";
	public final String LISTADO_CUENTAS = "cuenta/listado";
	public final String ADD_ALTA_CUENTA_OK="../indice";
	
	@RequestMapping(value = "alta", method = RequestMethod.GET)
	public String presentaForm (ModelMap model ){
		model.addAttribute("cuentaM", new CuentaMo());
		return FORM_CUENTA;
	}
	
	@RequestMapping(value = "alta", method = RequestMethod.POST)
	public String recibeForm(@Valid CuentaMo cuenta,BindingResult bdr) {
		if (bdr.hasErrors())
			return FORM_CUENTA;
		Cuentas.add(cuenta);
		return "redirect:"+ADD_ALTA_CUENTA_OK;
	}
	
	@RequestMapping(value = "listado")
	public String lanzaListado(ModelMap model) throws ClassNotFoundException, IOException {
		Vector<CuentaMo> listaCuentas = Cuentas.leer();
		model.addAttribute("listado", listaCuentas);
		return LISTADO_CUENTAS;
	}
	
	@RequestMapping(value = "edicion/{numero}", method = RequestMethod.GET)
	public String presentaEdicion(@PathVariable("numero") String numeroCuenta, ModelMap model) throws ClassNotFoundException, IOException {
		
		CuentaMo variable = Cuentas.leer(numeroCuenta);
		model.addAttribute("cuentaM", variable);
		return FORM_CUENTA;
	}
	@RequestMapping(value = "borrar/{numero}", method = RequestMethod.GET)
	public String recibeForm(@PathVariable("numero") String numeroCuenta, ModelMap model) throws ClassNotFoundException, IOException {
		
		Cuentas.borrar(numeroCuenta);
		return "redirect:../listado";
		
	}
}
