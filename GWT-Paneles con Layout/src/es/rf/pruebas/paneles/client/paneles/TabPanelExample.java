package es.rf.pruebas.paneles.client.paneles;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import es.rf.pruebas.paneles.client.utils.PanelUtils;

public class TabPanelExample extends TabLayoutPanel {

	public TabPanelExample(int numTabs) {
		super(2, Unit.EM);
		for (int i = 0; i < numTabs; i++) {
			add(tabContent(i), tabLabel(i));
		}
		addStyleName("tab-panel");
		setAnimationDuration(500);
	}

	private Widget tabContent(int index) {
		String content = "<h1>Aqui esta el contenido del tab " + index + "</h1>" + PanelUtils.randomText();
		return (new ScrollPanel(new HTML(content)));
	}

	private String tabLabel(int index) {
		return ("Presenta Panel " + index);
	}
}
