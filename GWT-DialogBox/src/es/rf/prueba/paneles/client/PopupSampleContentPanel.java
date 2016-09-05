package es.rf.prueba.paneles.client;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;

public class PopupSampleContentPanel extends VerticalPanel {
  public PopupSampleContentPanel(String text, 
                                 final PopupPanel container) {
    setSpacing(5); 
    setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    add(new HTML(text));
    Button button = new Button("Cerrar");
    button.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        container.hide();
      }
    });
    add(button);
  }
}
