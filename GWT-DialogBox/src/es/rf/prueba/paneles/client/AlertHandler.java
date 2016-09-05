package es.rf.prueba.paneles.client;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Window;

public class AlertHandler implements ClickHandler {
  @Override
  public void onClick(ClickEvent event) {
    String text = 
      "Calling Window.alert just invokes\n" +
      "the native JavaScript 'alert' function.\n" +
      "It contains simple plain text only.";
    Window.alert(text);
  }
}
