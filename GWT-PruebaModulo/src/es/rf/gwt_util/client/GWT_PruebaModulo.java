package es.rf.gwt_util.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import es.rf.gwt_util.work.TextBoxOptional;


public class GWT_PruebaModulo implements EntryPoint {

	public void onModuleLoad() {

		TextBoxOptional fancyOptTextBox = new TextBoxOptional(
				"Desmarca, para borrar comentario", true, true);
		fancyOptTextBox.setClearTextOnDisable(true);
		RootPanel.get("optional-textbox-4").add(fancyOptTextBox);
	}
}
