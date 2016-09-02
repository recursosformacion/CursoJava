package rf.manejadores.separada.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class GwtEventos implements EntryPoint, IGwtAcciones {
	
	private TextBox textField;
	private HTML resultArea;
	
	@Override
	public void onModuleLoad() {
		textField = new TextBox();
		textField.addKeyUpHandler(new GestorKeyUp(this));
		resultArea = new HTML("<i>Aqui aparecera el resultado</i>");
		RootPanel.get().addStyleName("tan");
		RootPanel.get("textfieldID").add(textField);
		RootPanel.get("resultID").add(resultArea);
	}

	@Override
	public void setResults(String html) {
		resultArea.setHTML(html);		
	}

	@Override
	public void ponerFondoRojo() {
		RootPanel.get().addStyleName("rojo");		
	}

	@Override
	public void ponerFondoNormal() {
		RootPanel.get().removeStyleName("rojo");		
	}

}
