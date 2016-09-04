package es.rf.pruebas.paneles.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import es.rf.pruebas.paneles.client.paneles.*;
import es.rf.pruebas.paneles.client.utils.*;

public class GWT_PanelesSimples implements EntryPoint {

	private DeckLayoutPanel contentPanel;

	public void onModuleLoad() {
		DockLayoutPanel app = new DockLayoutPanel(Unit.EM);
		app.addNorth(montaCabecera(), 10);
		app.addWest(montaMenu(), 20);

		TabLayoutPanel tabPanel = new TabPanelExample(4);
		StackLayoutPanel stackPanel = new StackPanelExample(5);
		SplitLayoutPanel hSplitPanel = new HSplitPanelExample();
		SplitLayoutPanel vSplitPanel = new VSplitPanelExample();
		Widget[] contentWidgets = { tabPanel, stackPanel, hSplitPanel, vSplitPanel };

		contentPanel = new ContentPanel(contentWidgets);
		app.add(contentPanel);
		RootLayoutPanel.get().add(app);
	}

	public HTML montaCabecera() {
		return new HTML("<h1>Esto es la cabecera</h1>");
	}

	private Panel montaMenu() {

		NavPanel navPanel = new NavPanel();
		navPanel.addStyleName("nav-panel");
		Button[] navButtons = { makeNavButton("Presenta TabLayoutPanel"), 
								makeNavButton("Presenta StackLayoutPanel"),
								makeNavButton("Presenta Horizontal SplitLayoutPanel"), 
								makeNavButton("Presenta Vertical SplitLayoutPanel") 
				};
		for (int i = 0; i < navButtons.length; i++) {
			Button button = navButtons[i];
			button.addClickHandler(new ButtonHandler(i));
			navPanel.add(button);
		}
		return navPanel;

	}

	public Button makeNavButton(String label) {
		Button navButton = new Button(label);
		navButton.addStyleName("nav-button");
		return navButton;
	}

		/*--------------------------------Manejadores---------------------------*/
	private class ButtonHandler implements ClickHandler {
		private int subPanelIndex;

		public ButtonHandler(int subPanelIndex) {
			this.subPanelIndex = subPanelIndex;
		}

		@Override
		public void onClick(ClickEvent event) {
			contentPanel.showWidget(subPanelIndex);
		}
	}
}
