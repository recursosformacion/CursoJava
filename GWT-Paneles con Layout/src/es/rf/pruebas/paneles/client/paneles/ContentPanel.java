package es.rf.pruebas.paneles.client.paneles;

import com.google.gwt.user.client.ui.*;

public class ContentPanel extends DeckLayoutPanel {
  public ContentPanel(Widget[] panels) {
    for (Widget panel : panels) {
      System.out.println("A�adiendo contenido a: " + panel);
      add(panel);
    }
    showWidget(0);
    setAnimationDuration(800);
    setAnimationVertical(true);
    // addStyleName("red");
  }
}
