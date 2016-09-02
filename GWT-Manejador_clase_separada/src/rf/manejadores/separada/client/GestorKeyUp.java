package rf.manejadores.separada.client;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.TextBox;

public class GestorKeyUp implements KeyUpHandler {

	private IGwtAcciones app;

	public GestorKeyUp(IGwtAcciones app){
		this.app = app;
	}
	@Override
	public void onKeyUp(KeyUpEvent event) {
		if (event.getSource() instanceof TextBox){
			TextBox txt = (TextBox) event.getSource();
			String text = txt.getText();
			if (text.equalsIgnoreCase("rojo")){
				app.setResults("<span class='correcto'>De Acuerdo!</span>");
				app.ponerFondoRojo();
			} else {
				app.setResults(text);
				app.ponerFondoNormal();
			}
		}
	}

}
