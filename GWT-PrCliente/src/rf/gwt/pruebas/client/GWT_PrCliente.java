package rf.gwt.pruebas.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWT_PrCliente implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final ListBox listaProvincias = new ListBox();
		cargaListaProvincias(listaProvincias);
		listaProvincias.setVisibleItemCount(1);
		
		final ListBox listaCiudades = new ListBox();
		listaCiudades.addItem("Seleccione ciudad");
		listaCiudades.setVisibleItemCount(1);
		listaCiudades.setEnabled(false);

		listaProvincias.addChangeHandler(new ProvinciasHandler(listaProvincias, listaCiudades) );
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("paraSelectorProvincia").add(listaProvincias);
		RootPanel.get("paraSelectorPoblacion").add(listaCiudades);
		
		listaProvincias.setFocus(true);
	}
	private void cargaListaProvincias(ListBox listaProvincias){
		listaProvincias.addItem("Indique provincia");
		InfoProvincia[] lasProvincias = InfoProvincia.getLasProvincias();
		for(InfoProvincia provincia: lasProvincias){
			listaProvincias.addItem(provincia.getNombre());
		}
	}
	
	private class ProvinciasHandler implements ChangeHandler{

			private ListBox listaProvincias, listaCiudades;
			
			public ProvinciasHandler(ListBox listaProvincias,ListBox listaCiudades){
				this.listaProvincias = listaProvincias;
				this.listaCiudades = listaCiudades;
			}
			@Override
			public void onChange(ChangeEvent event) {
				int index = listaProvincias.getSelectedIndex();
				String provincia = listaProvincias.getItemText(index);
				InfoProvincia[] lasProvincias = InfoProvincia.getLasProvincias();
				String[] ciudades = InfoProvincia.buscaPoblaciones(lasProvincias, provincia);
				listaCiudades.clear();
				for (String pobla : ciudades){
					listaCiudades.addItem(pobla);
				}
				listaCiudades.setEnabled(true);
				
			}
		
	}
}
