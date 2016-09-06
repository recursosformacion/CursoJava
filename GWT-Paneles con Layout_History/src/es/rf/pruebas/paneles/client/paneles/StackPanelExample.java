package es.rf.pruebas.paneles.client.paneles;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import es.rf.pruebas.paneles.client.utils.PanelUtils;

public class StackPanelExample extends StackLayoutPanel {
	public StackPanelExample(int numTabs) {
		super(Unit.EM);
		for (int i = 0; i < numTabs; i++) {
			add(stackContent(i), stackLabel(i), 2);
		}
		showWidget(numTabs - 1);
		addStyleName("stack-panel");
		setAnimationDuration(500);
	}

	private Widget stackContent(int index) {
		String content = "<h1>Contenido de pestaña " + index + "</h1>" + PanelUtils.randomText()
				+ PanelUtils.randomText();
		ScrollPanel p = new ScrollPanel(new HTML(content));
		return (p);
	}

	private String stackLabel(int index) {
		return ("Presentar Panel " + index);
	}
}