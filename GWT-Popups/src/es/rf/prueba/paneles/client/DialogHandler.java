package es.rf.prueba.paneles.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class DialogHandler implements ClickHandler {
  @Override
  public void onClick(ClickEvent event) {
    DialogBox dialog = new DialogBox(true);
    String text = "Un DialogBox, puede contener otros widgets. "
        + "En este caso, contiene un VerticalPanel"
        + "Dispone de un area de 'caption' y su tamaño"
        + "puede ser independiente de los widgets que contiene.";
    Widget sampleContent = new PopupSampleContentPanel(text, dialog);
    dialog.setWidget(sampleContent);
    dialog.setText("Titulo del DialogBox");
    UIObject button = (UIObject) event.getSource();
    int x = button.getAbsoluteLeft() + 100;
    int y = button.getAbsoluteTop() - 100;
    dialog.setPopupPosition(x, y);
    dialog.setAnimationEnabled(true);
    dialog.setWidth("350px");
    dialog.show();
  }
}
