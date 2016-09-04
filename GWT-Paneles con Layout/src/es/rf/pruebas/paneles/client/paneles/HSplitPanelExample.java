package es.rf.pruebas.paneles.client.paneles;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import es.rf.pruebas.paneles.client.utils.PanelUtils;

public class HSplitPanelExample extends SplitLayoutPanel {
	public HSplitPanelExample() {
		addWest(makeScrollableText(), 200);
		add(makeScrollableText());
		
		addStyleName("split-panel");
	}

	private Widget makeScrollableText() {
		return new ScrollPanel(new HTML(PanelUtils.randomText()));
	}
}