package es.rf.pruebas.paneles.client.paneles;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;


import es.rf.pruebas.paneles.client.utils.PanelUtils;

public class DeckPanelExample extends DockLayoutPanel {

	DeckLayoutPanel dkPanel ;
	
	public DeckPanelExample(int numTabs) {
		super(Unit.EM);
		HorizontalPanel hr = new HorizontalPanel();
		for (int i = 0; i < numTabs; i++) {
			Button b = btn(i);
			b.addClickHandler(new ButtonHandler(i));
			hr.add(b);
		}
		addNorth(hr,4);
		
		dkPanel = new DeckLayoutPanel();
		for (int i = 0; i < numTabs; i++) {
			dkPanel.add(deckContent(i));
		}
		dkPanel.addStyleName("tab-panel");
		dkPanel.setAnimationDuration(500);
		dkPanel.showWidget(0);
		add(dkPanel);
		
	}

	private Widget deckContent(int index) {
		String content = "<h1>Aqui esta el contenido de la ficha " + index + "</h1>" + PanelUtils.randomText();
		return (new ScrollPanel(new HTML(content)));
	}

	private Button btn(int index) {
		return new Button("Ficha " + index);
	}
	/*--------------------------------Manejadores---------------------------*/
	private class ButtonHandler implements ClickHandler {
		private int index;

		public ButtonHandler(int index) {
			this.index = index;
		}

		@Override
		public void onClick(ClickEvent event) {
			dkPanel.showWidget(index);
		}
	}
}
