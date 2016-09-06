package es.rf.gwtrpcinicio.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.rf.gwtrpcinicio.client.DataService;
import es.rf.gwtrpcinicio.shared.RandomNumber;

@SuppressWarnings("serial")
public class DataServiceImpl extends RemoteServiceServlet implements DataService {

	public String getButton1Data() {
		String result = String.format("Numero: %.2f", Math.random() * 10);
		return (result);
	}

	@Override
	public String[] getButton2Data() {
		String[] results = { String.format("%.2f", Math.random()), String.format("%.2f", Math.random() * 10),
				String.format("%.2f", Math.random() * 100), String.format("%.2f", Math.random() * 1000) };
		return (results);
	}

	public RandomNumber getButton3Data(String rangeString) {
		return (new RandomNumber(rangeString));
	}

	public void logClientRandom(RandomNumber clientRandom) {
		log("El numero aleatorio enviado al cliente es: " + clientRandom.getValue());
		System.out.println("Numero aleatorio '" + clientRandom.getValue() + "' registrado.");
	}

}
