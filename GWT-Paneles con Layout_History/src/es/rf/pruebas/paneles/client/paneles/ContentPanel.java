package es.rf.pruebas.paneles.client.paneles;

import com.google.gwt.user.client.ui.*;

public class ContentPanel extends DeckLayoutPanel {
	String[] nombres;
  public ContentPanel(Widget[] panels,String[] nombres) {
    for (Widget panel : panels) {
      System.out.println("Añadiendo contenido a: " + panel);
      add(panel);
    }
    showWidget(0);
    setAnimationDuration(800);
    setAnimationVertical(true);
    // addStyleName("red");
    this.nombres=nombres;
   
  }
  public void showWidgetByName(String s){
  		for (int a=0;a<nombres.length;a++){
  			if (s.split("&")[0].equalsIgnoreCase(nombres[a])){
  				showWidget(a);
  			}
  		}
  }
}
