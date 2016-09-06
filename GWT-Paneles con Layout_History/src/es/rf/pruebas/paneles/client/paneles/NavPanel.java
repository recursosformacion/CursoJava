package es.rf.pruebas.paneles.client.paneles;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class NavPanel extends FlowPanel {
	@Override
	public void add(Widget w) {
		// Force to be block-level element
		SimplePanel wrapper = new SimplePanel();
		wrapper.addStyleName("center-block");
		wrapper.add(w);
		super.add(wrapper);
	}
}
