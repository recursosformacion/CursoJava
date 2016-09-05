package es.rf.prueba.paneles.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.*;
import com.google.gwt.user.client.*;
import java.util.*;

public class GWT_Widgets implements EntryPoint {
	@Override
	public void onModuleLoad() {
		addDatePanel();
		addSuggestPanel();
		addMenuPanel();
	}

	private void addDatePanel() {
		Grid datePanel = new Grid(2, 2);
		datePanel.setText(0, 0, "Departure Date:");
		DateBox departureBox = new DateBox();
		Date departureDate = new Date();
		departureBox.setValue(departureDate);
		datePanel.setWidget(0, 1, departureBox);
		datePanel.setText(1, 0, "Return Date:");
		Date returnDate = new Date(departureDate.getTime());
		CalendarUtil.addDaysToDate(returnDate, 7); // add a week
		DateBox returnBox = new DateBox();
		returnBox.setValue(returnDate);
		datePanel.setWidget(1, 1, returnBox);
		RootPanel.get("date-panel").add(datePanel);
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
}
