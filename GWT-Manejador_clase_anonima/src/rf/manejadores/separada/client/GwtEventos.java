package rf.manejadores.separada.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class GwtEventos implements EntryPoint {

	private TextBox textField;
	private HTML resultArea;

	@Override
	public void onModuleLoad() {
		textField = new TextBox();
		textField.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				String text = textField.getText();
				if (text.equalsIgnoreCase("rojo")) {
					setResults("<span class='correcto'>De Acuerdo!</span>");
					ponerFondoRojo();
				} else {
					setResults(text);
					ponerFondoNormal();
				}
			}
		});
		resultArea = new HTML("<i>Aqui aparecera el resultado</i>");
		RootPanel.get().addStyleName("tan");
		RootPanel.get("textfieldID").add(textField);
		RootPanel.get("resultID").add(resultArea);
	}

	public void setResults(String html) {
		resultArea.setHTML(html);
	}

	public void ponerFondoRojo() {
		RootPanel.get().addStyleName("rojo");
		RootPanel.get().removeStyleName("tan");
	}

	public void ponerFondoNormal() {
		RootPanel.get().removeStyleName("rojo");
		RootPanel.get().addStyleName("tan");
	}

}
