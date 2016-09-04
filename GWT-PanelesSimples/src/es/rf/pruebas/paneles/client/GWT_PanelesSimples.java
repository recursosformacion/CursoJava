package es.rf.pruebas.paneles.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GWT_PanelesSimples implements EntryPoint {

	public void onModuleLoad() {
		TabLayoutPanel tlp = new TabLayoutPanel(2, Unit.EM);
		tlp.setWidth("80%");
		tlp.setHeight("600px");

		TabPanel tp = new TabPanel();
		tp.add(vPanel(), "VerticalPanel");
		tp.add(hPanel(), "HorizontalPanel");
		tp.add(fPanel(), "Flow Panel");
		tp.add(fvPanel(), "Flow como vertical");
		tp.add(fhPanel(), "Flow como horizontal");
		tp.add(gPanel(), "Grid Panel");
		tp.add(fxPanel(), "FlezTable");
		tp.selectTab(0);
		tlp.add(tp, "Sin Layout");

		tlp.selectTab(0);
		RootPanel.get("Datos").add(tlp);
	}

	public VerticalPanel vPanel() {
		VerticalPanel vp = new VerticalPanel();
		vp.add(new HTML("Panel vertical<br/>"));
		for (int a = 1; a <= 10; a++) {
			Button b = new Button("Boton " + a);
			vp.add(b);
		}
		Button b = new Button("Boton 99");
		vp.insert(b, 5);
		return vp;
	}

	public HorizontalPanel hPanel() {
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(new HTML("Panel horizontal<br/>"));
		for (int a = 1; a <= 30; a++) {
			Button b = new Button("Boton" + a);
			hp.add(b);
		}
		Button b = new Button("Boton 99");
		hp.insert(b, 5);
		return hp;
	}

	public FlowPanel fPanel() {
		FlowPanel fp = new FlowPanel();
		fp.add(new HTML("Flow Panel<br/>"));
		for (int a = 1; a <= 30; a++) {
			Button b = new Button("Boton" + a);
			b.getElement().setAttribute("style", "margin-right:10px");
			fp.add(b);
		}
		Button b = new Button("Boton 99");
		fp.insert(b, 5);
		return fp;
	}

	public FlowPanel fvPanel() {
		FlowPanel fp = new FlowPanel();
		fp.add(new HTML("Flow/Vertical Panel<br/>"));
		for (int a = 1; a <= 30; a++) {
			SimplePanel sp = new SimplePanel();
			Button b = new Button("Boton" + a);
			b.getElement().setAttribute("style", "margin-right:10px");
			sp.add(b);
			fp.add(sp);
		}
		return fp;
	}

	public FlowPanel fhPanel() {
		FlowPanel fp = new FlowPanel();
		fp.add(new HTML("Flow/Horizontal Panel<br/>"));
		for (int a = 1; a <= 30; a++) {
			SimplePanel sp = new SimplePanel();
			Button b = new Button("Boton" + a);
			b.getElement().setAttribute("style", "margin-right:10px;float:left;");
			sp.add(b);
			fp.add(sp);
		}
		return fp;
	}

	public Grid gPanel() {
		Grid p = new Grid(20, 10);
		//p.add(new HTML("Flow/Horizontal Panel<br/>"));
		for (int a = 0; a < 20; a++) {
			p.setHTML(a, 0, "Valor en <b>HTML</b>");
			for (int b = 1; b < 10; b++) {
				Button bu = new Button("Boton" + a + ":" + b);
				p.setWidget(a, b, bu);
			}
		}
		return p;
	}
	
	public FlexTable fxPanel() {
		FlexTable p = new FlexTable();
		p.setHTML(0,5,"FlexTable y colspan<br/>");
		p.getFlexCellFormatter().setColSpan(0, 5, 10);
		for (int a = 1; a < 20; a++) {
			p.setHTML(a, 0, "Valor en <b>HTML</b>");
			for (int b = 1; b < 10; b++) {
				Button bu = new Button("Boton" + a + ":" + b);
				p.setWidget(a, b, bu);
			}
		}
		return p;
	}
}
