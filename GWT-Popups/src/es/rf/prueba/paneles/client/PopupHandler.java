package es.rf.prueba.paneles.client;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;

public class PopupHandler implements ClickHandler {
  @Override
  public void onClick(ClickEvent event) {
    PopupPanel popup = new PopupPanel(true);
    String text = 
      "El PopupPanel puede contener otros widgets.<br/>" +
      "En este caso, contiene VerticalPanel.<br/>" +
      "El PopupPanel no tiene caption independiente, y<br/>" +
      "el tamaño depende desu contenido.";
    Widget sampleContent = 
      new PopupSampleContentPanel(text, popup);
    popup.setWidget(sampleContent);
    UIObject button = (UIObject)event.getSource();
    int x = button.getAbsoluteLeft() + 100;
    int y = button.getAbsoluteTop() - 100;
    popup.setPopupPosition(x, y);
    popup.setAnimationEnabled(true);
    popup.show();
  }
}
