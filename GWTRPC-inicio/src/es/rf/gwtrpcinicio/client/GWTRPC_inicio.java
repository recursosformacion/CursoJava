package es.rf.gwtrpcinicio.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import es.rf.gwtrpcinicio.shared.RandomNumber;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTRPC_inicio implements EntryPoint {

	private HTML label1, label2, label3, label4;
	private TextBox rangeBox;

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final DataServiceAsync serviceProxy = GWT.create(DataService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// ****************************Boton 1
		Button button1 = new Button("Presentar numero aleatorio");
		label1 = new HTML("<i>El numero aparecera aqui</i>");
		button1.addClickHandler(new Button1Handler());
		RootPanel.get("button1").add(button1);
		RootPanel.get("label1").add(label1);

		// ****************************Boton 2
		Button button2 = new Button("Presentar lista");
		label2 = new HTML("<i>La lista aparecera aqui</i>");
		button2.addClickHandler(new Button2Handler());
		RootPanel.get("button2").add(button2);
		RootPanel.get("label2").add(label2);

		// ****************************Boton 3
		Button button3 = new Button("Presentar numero aleatorio(Objeto)");
		rangeBox = new TextBox();
		label3 = new HTML("<i>El numero aparecera aqui</i>");
		button3.addClickHandler(new Button3Handler());
		RootPanel.get("button3").add(button3);
		RootPanel.get("rangeBox").add(rangeBox);
		RootPanel.get("label3").add(label3);

		// ****************************Boton 4
		Button button4 = new Button("Registrar clientes ramdom");
		label4 = new HTML("<i>La confirmacion aparecera aqui</i>");
		RootPanel.get("button4").add(button4);
		RootPanel.get("label4").add(label4);
		button4.addClickHandler(new Button4Handler());
	}

	// ****************************Tratamiento boton 1
	private class Button1Handler implements ClickHandler {
		public void onClick(ClickEvent event) {
			
			label1.setHTML("<h1><i>Loading...</i></h1>");
			serviceProxy.getButton1Data(new Button1Callback());
		}
	}

	private class Button1Callback implements AsyncCallback<String> {
		public void onSuccess(String result) {
			label1.setHTML(result);
		}

		public void onFailure(Throwable caught) {
			Window.alert("Unable to get data from server.");
		}
	}

	// **********************Tratamiento boton 2
	private class Button2Handler implements ClickHandler {
		public void onClick(ClickEvent event) {
			serviceProxy.getButton2Data(new Button2Callback());
		}
	}

	private class Button2Callback implements AsyncCallback<String[]> {
		public void onSuccess(String[] listItems) {
			String result = "<ul>\n";
			for (String item : listItems) {
				result = result + "<li>" + item + "</li>\n";
			}
			result = result + "</ul>";
			label2.setHTML(result);
		}

		public void onFailure(Throwable caught) {
			Window.alert("Unable to get data from server.");
		}
	}

	// **********************Tratamiento boton 3
	private class Button3Handler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String range = rangeBox.getText();
			serviceProxy.getButton3Data(range, new Button3Callback());
		}
	}

	private class Button3Callback implements AsyncCallback<RandomNumber> {
		public void onSuccess(RandomNumber number) {
			String range = "Range: " + number.getRange();
			if (!number.isRangeLegal()) {
				range = range + " (default due to illegal range)";
			}
			String value = "Value: " + number.getValue();
			String result = "<ul>\n" + "<li>" + range + "</li>\n" + "<li>" + value + "</li>\n" + "</ul>";
			label3.setHTML(result);
		}

		public void onFailure(Throwable caught) {
			Window.alert("Unable to get data from server.");
		}
	}

	// **********************Tratamiento boton 4
	private class Button4Handler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String range = RootPanel.get("range4").getElement().getInnerText();
			RandomNumber clientRandom = new RandomNumber(range);
			serviceProxy.logClientRandom(clientRandom, new LogCallback(clientRandom));
		}
	}

	private class LogCallback implements AsyncCallback<Void> {
		RandomNumber clientRandom;

		public LogCallback(RandomNumber clientRandom) {
			this.clientRandom = clientRandom;
		}

		public void onFailure(Throwable caught) {
			Window.alert("Unable to log message to the server.");
		}

		public void onSuccess(Void result) {
			String message = "El numero enviado al servidor es: " + clientRandom.getValue();
			label4.setHTML(message);
		}
	}
	// ******************************
}
