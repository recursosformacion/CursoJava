package es.rf.pruebas.paneles.client.paneles;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import es.rf.pruebas.paneles.client.utils.PanelUtils;

public class LayoutPanelExample extends LayoutPanel {
	public LayoutPanelExample() {
		Widget child0= cargarPanelContent(1);
		Widget child1= cargarPanelContent(2);
		Widget child2= cargarPanelContent(3);
		child2.setStyleName("opaco");
		child2.setWidth("70em");
		add(child0);
		add(child1);
		add(child2);

		setWidgetLeftWidth(child0, 0, Unit.EM, 35, Unit.EM);  // Left panel
		setWidgetRightWidth(child1, 0, Unit.EM, 35, Unit.EM); // Right panel

		setWidgetLeftRight(child2, 5, Unit.EM, 5, Unit.EM);     // Center panel
		setWidgetTopBottom(child2, 5, Unit.EM, 5, Unit.EM);

	}

	private Widget cargarPanelContent(int index) {
		String content = "<h1>Aqui esta el contenido del panel " + index + "</h1>" + PanelUtils.randomText();
		return (new ScrollPanel(new HTML(content)));
	}
}