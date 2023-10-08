package es.rf.banco.servicio;

import org.springframework.stereotype.Service;

import es.rf.banco.model.Logon;

@Service
public class ControlAcceso {

	public static boolean valida(Logon dato){
		
		return ((dato.getUsuario().toLowerCase().equals("miguel")) &&
				(dato.getPassword().equals("miguel")));
	}
}
