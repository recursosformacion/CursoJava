package es.rf.prueba.paneles.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.*;
import com.google.gwt.user.client.*;
import java.util.*;

public class GWT_Widgets implements EntryPoint {
	@Override
	public void onModuleLoad() {
		addDatePanel();
		addDatePicker();
		addSuggestPanel();
		addMenuPanel();
		addTree();
	}

	private void addDatePanel() {
		
		Grid datePanel = new Grid(2, 2);
		DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
		datePanel.setText(0, 0, "Fecha de salida:");
		DateBox departureBox = new DateBox();
		Date departureDate = new Date();
		departureBox.setValue(departureDate);
		departureBox.setFormat(new DateBox.DefaultFormat(dtf));
		datePanel.setWidget(0, 1, departureBox);
		datePanel.setText(1, 0, "Fecha de regreso:");
		Date returnDate = new Date(departureDate.getTime());
		CalendarUtil.addDaysToDate(returnDate, 7); // add a week
		DateBox returnBox = new DateBox();
		returnBox.setValue(returnDate);
		returnBox.setFormat(new DateBox.DefaultFormat(dtf));
		datePanel.setWidget(1, 1, returnBox);
		RootPanel.get("date-panel").add(datePanel);
	}
	
	private void addDatePicker(){
		// Create a basic date picker
	      DatePicker datePicker = new DatePicker();
	      final Label text = new Label();

	      // Set the value in the text box when the user selects a date
	      datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
	         @Override
	         public void onValueChange(ValueChangeEvent<Date> event) {
	            Date date = event.getValue();
	            String dateString = 
	            DateTimeFormat.getFormat("dd/MM/yyyy").format(date);
	            text.setText(dateString);				
	         }
	      });
	      // Set the default value
	      datePicker.setValue(new Date(), true);

	      // Create a DateBox
	      DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");
	      DateBox dateBox = new DateBox();
	      dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));

	      Label selectLabel = new Label("Permanent DatePicker:");
	      Label selectLabel2 = new Label("DateBox with popup DatePicker:");
	      // Add widgets to the root panel.
	      VerticalPanel vPanel = new VerticalPanel();
	      vPanel.setSpacing(10);
	      vPanel.add(selectLabel);
	      vPanel.add(text);
	      vPanel.add(datePicker);
	      vPanel.add(selectLabel2);
	      vPanel.add(dateBox);
	      RootPanel.get("gwtDatePicker").add(vPanel);
	}

	private void addSuggestPanel() {
		HorizontalPanel langPanel = new HorizontalPanel();
		langPanel.setSpacing(5);
		langPanel.add(new HTML("Enter language:"));
		MultiWordSuggestOracle langChoices = new ProgrammingLanguageOracle();
		SuggestBox langBox = new SuggestBox(langChoices);
		langPanel.add(langBox);
		Button searchButton = new Button("Send to Google");
		searchButton.addClickHandler(new SearchHandler(langBox));
		langPanel.add(searchButton);
		RootPanel.get("suggest-panel").add(langPanel);
	}

	private void addMenuPanel() {
		HorizontalPanel searchPanel = new HorizontalPanel();
		searchPanel.setSpacing(5);
		searchPanel.add(new HTML("Enter language:"));
		MultiWordSuggestOracle langChoices = new ProgrammingLanguageOracle();
		final SuggestBox langBox = new SuggestBox(langChoices);
		searchPanel.add(langBox);
		MenuBar mainMenu = new MenuBar();
		mainMenu.setAutoOpen(true);
		//mainMenu.setWidth("100px");
		mainMenu.setAnimationEnabled(true);

		MenuBar searchMenu = new SearchMenuBar(langBox);
		mainMenu.addItem("Search", searchMenu);
		Command alertCommand = new Command() {
			@Override
			public void execute() {
				Window.alert("Selection is " + langBox.getText());
			}
		};
		mainMenu.addItem("Alert", alertCommand);
		MenuBar modifierMenu = new ModifierMenuBar(langBox);
		mainMenu.addItem("Modify", modifierMenu);
		searchPanel.add(mainMenu);
		RootPanel.get("menu-panel").add(searchPanel);
	}
	
	private void addTree(){
		//create a label
	      final Label labelMessage = new Label();
	      labelMessage.setWidth("300");

	      // Create a root tree item as department
	      TreeItem department = new TreeItemS("Department");

	      //create other tree items as department names
	      TreeItem salesDepartment = new TreeItemS("Sales");
	      TreeItem marketingDepartment = new TreeItemS("Marketing");
	      TreeItem manufacturingDepartment = new TreeItemS("Manufacturing");

	      //create other tree items as employees
	      TreeItem employee1 = new TreeItemS("Robert");
	      TreeItem employee2 = new TreeItemS("Joe");
	      TreeItem employee3 = new TreeItemS("Chris");

	      //add employees to sales department
	      salesDepartment.addItem(employee1);
	      salesDepartment.addItem(employee2);
	      salesDepartment.addItem(employee3);

	      //create other tree items as employees
	      TreeItem employee4 = new TreeItemS("Mona");
	      TreeItem employee5 = new TreeItemS("Tena");	   

	      //add employees to marketing department
	      marketingDepartment.addItem(employee4);
	      marketingDepartment.addItem(employee5);	    

	      //create other tree items as employees
	      TreeItem employee6 = new TreeItemS("Rener");
	      TreeItem employee7 = new TreeItemS("Linda");

	      //add employees to sales department
	      manufacturingDepartment.addItem(employee6);
	      manufacturingDepartment.addItem(employee7);

	      //add departments to department item
	      department.addItem(salesDepartment);
	      department.addItem(marketingDepartment);
	      department.addItem(manufacturingDepartment);

	      //create the tree
	      Tree tree = new Tree();

	      //add root item to the tree
	      tree.addItem(department);	   

	      tree.addSelectionHandler(new SelectionHandler<TreeItem>() {
	         @Override
	         public void onSelection(SelectionEvent<TreeItem> event) {
	            labelMessage.setText("Selected Value: "
	            + event.getSelectedItem().getText());
	         }
	      });

	      // Add text boxes to the root panel.
	      VerticalPanel panel = new VerticalPanel();
	      panel.setSpacing(10);
	      panel.add(tree);
	      panel.add(labelMessage);

	      //add the tree to the root panel
	      RootPanel.get("gwt_tree").add(panel);
	   }	
	}

