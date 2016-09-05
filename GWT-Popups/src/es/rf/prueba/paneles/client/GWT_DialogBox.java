package es.rf.prueba.paneles.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.ui.*;

public class GWT_DialogBox implements EntryPoint {
	@Override
	public void onModuleLoad() {

		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setSpacing(10);
		Button button1 = new Button("DialogBox");
		button1.addClickHandler(new DialogHandler());
		buttonPanel.add(button1);
		Button button2 = new Button("PopupPanel");
		button2.addClickHandler(new PopupHandler());
		buttonPanel.add(button2);
		Button button3 = new Button("Native Dialog (Alert) Box");
		button3.addClickHandler(new AlertHandler());
		buttonPanel.add(button3);
		RootPanel.get("popup-buttons").add(buttonPanel);
	}

}
