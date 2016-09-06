package es.rf.pruebas.paneles.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import es.rf.pruebas.paneles.client.paneles.*;
import es.rf.pruebas.paneles.client.utils.*;

public class GWT_PanelesSimples implements EntryPoint {

	private ContentPanel contentPanel;
	TabLayoutPanel tabPanel;

	public void onModuleLoad() {
		DockLayoutPanel app = new DockLayoutPanel(Unit.EM);
		app.addNorth(montaCabecera(), 10);
		app.addWest(montaMenu(), 20);

		tabPanel = new TabPanelExample(4);
		StackLayoutPanel stackPanel = new StackPanelExample(5);
		Widget hSplitPanel = new HSplitPanelExample();
		Widget vSplitPanel = new VSplitPanelExample();
		Widget layoutPanel = new LayoutPanelExample();
		Widget deckLayout = new DeckPanelExample(4);
		Widget[] contentWidgets = { tabPanel, stackPanel, hSplitPanel, vSplitPanel, layoutPanel, deckLayout };
		String[] nombresWidgets = {"tabs",     "stack0"    ,"hsplit",   "vsplit",    "lpanel",    "dPanel"};
		contentPanel = new ContentPanel(contentWidgets, nombresWidgets);
		app.add(contentPanel);
		RootLayoutPanel.get().add(app);
		/****************************** para history ********************/
		History.addValueChangeHandler(new HistoryHandler());
		History.fireCurrentHistoryState();
	}

	public HTML montaCabecera() {
		return new HTML("<h1>Esto es la cabecera</h1>");
	}

	private Panel montaMenu() {

		NavPanel navPanel = new NavPanel();
		navPanel.addStyleName("nav-panel");
		/*		 * sin historia 
		 * Button[] navButtons = { makeNavButton(
		 * "Presenta TabLayoutPanel"), makeNavButton("Presenta StackLayoutPanel"
		 * ), makeNavButton("Presenta Horizontal SplitLayoutPanel"),
		 * makeNavButton("Presenta Vertical SplitLayoutPanel"), makeNavButton(
		 * "Presenta LayoutPanel"), makeNavButton("Presenta DeckLayoutPanel") };
		 * for (int i = 0; i < navButtons.length; i++) { Button button =
		 * navButtons[i]; button.addClickHandler(new ButtonHandler(i));
		 * navPanel.add(button); }
		 */
		/* con historia */
		navPanel.add(new Hyperlink("Presenta TabLayoutPanel", "tab0"));
		navPanel.add(new Hyperlink("Presenta StackLayoutPanel", "stack0"));
		navPanel.add(new Hyperlink("Presenta Horizontal SplitLayoutPanel", "hsplit"));
		navPanel.add(new Hyperlink("Presenta Vertical SplitLayoutPanel", "vsplit&range=20"));
		navPanel.add(new Hyperlink("Presenta LayoutPanel", "lpanel"));
		navPanel.add(new Hyperlink("Presenta DeckLayoutPanel", "dPanel"));

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

	private class HistoryHandler implements ValueChangeHandler<String> {
		public void onValueChange(ValueChangeEvent<String> event) {
			String historyToken = event.getValue();
			if (historyToken.startsWith("tab")) {
				selectTab(historyToken);
			} else if (true) {
				contentPanel.showWidgetByName(historyToken);
			} else {
				selectTab("tab0");
			}
		}

		private void selectTab(String historyToken) {
			historyToken = historyToken.substring(3);
			int tabIndex = 0;
			try {
				tabIndex = Integer.parseInt(historyToken);
				if (tabIndex < 0 && tabIndex > 3) {
					tabIndex = 0;
				}
			} catch (NumberFormatException e) {
			}
			tabPanel.selectTab(tabIndex);
			contentPanel.showWidget(0);
		}
	}
}
