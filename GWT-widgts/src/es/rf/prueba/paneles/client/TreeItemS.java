package es.rf.prueba.paneles.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TreeItem;

public class TreeItemS extends TreeItem {
	public TreeItemS(String item){
		super(new HTML(item));
	}
}
