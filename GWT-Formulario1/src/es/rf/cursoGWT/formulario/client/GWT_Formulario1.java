package es.rf.cursoGWT.formulario.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;

import es.rf.cursoGWT.formulario.client.richText.RichTextToolbar;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWT_Formulario1 implements EntryPoint {

	
	public void onModuleLoad() {
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setSpacing(20);
		vPanel.add(new HTML("<h1><center>Botones</center></h1>"));
		
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setSpacing(20);

		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(10);
		panel.add(new HTML("<p>Los botones<br><p>"));
		createButtons(panel);
		panel.add(new HTML("<p>&nbsp;<p>"));
		hPanel.add(panel);

		VerticalPanel panel1 = new VerticalPanel();
		panel1.setSpacing(10);
		panel1.add(new HTML("<p>Push Buttons<br>Con efectos over<p>"));
		createPushButtons(panel1);
		panel1.add(new HTML("<p>&nbsp;<p>"));
		hPanel.add(panel1);

		VerticalPanel panel2 = new VerticalPanel();
		panel2.setSpacing(10);
		panel2.add(new HTML("<p>toggle Buttons<br><p>"));
		createToggleButtons(panel2);
		panel2.add(new HTML("<p>&nbsp;<p>"));
		hPanel.add(panel2);

		VerticalPanel panel3 = new VerticalPanel();
		panel3.setSpacing(10);
		panel3.add(new HTML("<p>Checkbox<br><p>"));
		createCheckBox(panel3);
		panel3.add(new HTML("<p>&nbsp;<p>"));
		hPanel.add(panel3);
		
		VerticalPanel panel4 = new VerticalPanel();
		panel4.setSpacing(10);
		panel4.add(new HTML("<p>RadioButtons<br><p>"));
		createRadios(panel4);
		panel4.add(new HTML("<p>&nbsp;<p>"));
		hPanel.add(panel4);
		
		vPanel.add(hPanel);
		vPanel.add(new HTML("<h1><center>Listas y TextBoxs</center></h1>"));
		
		HorizontalPanel hPanel2 = new HorizontalPanel();
		hPanel2.setSpacing(20);
		
		VerticalPanel panel5 = new VerticalPanel();
		panel5.setSpacing(10);
		panel5.add(new HTML("<p>ListBox<br><p>"));
		createListBox(panel5);
		panel5.add(new HTML("<p>&nbsp;<p>"));
		hPanel2.add(panel5);
		
		VerticalPanel panel6 = new VerticalPanel();
		panel6.setSpacing(10);
		panel6.add(new HTML("<p>SuggestBox<br><p>"));
		createSuggestBox(panel6);
		panel6.add(new HTML("<p>&nbsp;<p>"));
		hPanel2.add(panel6);
		
		VerticalPanel panel7 = new VerticalPanel();
		panel7.setSpacing(10);
		panel7.add(new HTML("<p>TextBox<br><p>"));
		createTextBox(panel7);
		panel7.add(new HTML("<p>&nbsp;<p>"));
		hPanel2.add(panel7);
		
		VerticalPanel panel8 = new VerticalPanel();
		panel8.setSpacing(10);
		panel8.add(new HTML("<p>Password TextBox<br><p>"));
		createPasswordTextBox(panel8);
		panel8.add(new HTML("<p>&nbsp;<p>"));
		hPanel2.add(panel8);
		
		VerticalPanel panel9 = new VerticalPanel();
		panel9.setSpacing(10);
		panel9.add(new HTML("<p>TextArea<br><p>"));
		createTextArea(panel9);
		panel9.add(new HTML("<p>&nbsp;<p>"));
		hPanel2.add(panel9);
		
		vPanel.add(hPanel2);
		
		HorizontalPanel hPanel3 = new HorizontalPanel();
		hPanel3.setSpacing(20);
		vPanel.add(new HTML("<h1><center>RichText y hiddens</center></h1>"));
		
		VerticalPanel panel10 = new VerticalPanel();
		panel10.setSpacing(10);
		panel10.add(new HTML("<p>RichTextArea<br><p>"));
		createRichTextArea(panel10);
		panel10.add(new HTML("<p>&nbsp;<p>"));
		hPanel3.add(panel10);
		
		VerticalPanel panel14 = new VerticalPanel();
		panel14.setSpacing(10);
		panel14.add(new HTML("<p>RichTextArea<br><p>"));
		createFileUpload(panel14);
		panel14.add(new HTML("<p>&nbsp;<p>"));
		hPanel3.add(panel14);
		
		VerticalPanel panel11 = new VerticalPanel();
		panel11.setSpacing(10);
		panel11.add(new HTML("<p>Hidden<br><p>"));
		createHidden(panel11);
		panel11.add(new HTML("<p>&nbsp;<p>"));
		hPanel3.add(panel11);
		
		vPanel.add(hPanel3);
		
		RootPanel.get("gwtContainer").add(vPanel);
	}

	public void createButtons(Panel panel) {

		Button redButton = new Button("Rojo");
		Button greenButton = new Button("Verde");
		Button blueButton = new Button("Azul");

		// usando metodos de UIObject .
		redButton.setWidth("100px");
		greenButton.setWidth("100px");
		blueButton.setWidth("100px");
		redButton.setStylePrimaryName("tx_red");
		greenButton.setStylePrimaryName("tx_green");
		blueButton.setStylePrimaryName("tx_blue");

		// add a clickListener to the button
		redButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resetea(panel);
				panel.addStyleName("bk_red");
			}
		});

		// add a clickListener to the button
		greenButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resetea(panel);
				panel.addStyleName("bk_green");
			}
		});

		// add a clickListener to the button
		blueButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resetea(panel);
				panel.addStyleName("bk_blue");
			}
		});

		// Add button to the panel.
		panel.add(redButton);
		panel.add(greenButton);
		panel.add(blueButton);

	}

	public void createPushButtons(Panel panel) {
		// crear botones
		PushButton pushButton = new PushButton("Pulsame!");
		PushButton pushButton1 = new PushButton("Pulsame!");

		// desactivar uno
		pushButton1.setEnabled(false);

		// add a clickListener to the push button
		pushButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Hola mundo!!!!!");
			}
		});

		panel.add(pushButton);
		panel.add(pushButton1);
	}

	public void createToggleButtons(Panel panel) {
		// crear toggle buttons
		ToggleButton toggleButton = new ToggleButton("Pulsame!");
		ToggleButton toggleButton1 = new ToggleButton("Pulsame!");

		// desactivar a toggle button
		toggleButton1.setEnabled(false);

		// add a clickListener to the toggle button
		toggleButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Hola mundo, desde toggle!");
			}
		});

		// Add toggle button to the root panel.

		panel.add(toggleButton);
		panel.add(toggleButton1);
	}

	public void createCheckBox(Panel panel) {
		// Make a new check box, and select it by default.
		CheckBox checkBox1 = new CheckBox("Check Me!");
		CheckBox checkBox2 = new CheckBox("Check Me!");

		// set check box as selected
		checkBox1.setValue(true);

		// disable a checkbox
		checkBox2.setEnabled(false);

		checkBox1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				CheckBox checkBox = (CheckBox) event.getSource();
				Window.alert("CheckBox está " + (checkBox.getValue() ? "marcado" : "no marcado"));
			}
		});

		// Add checkboxes to the root panel.

		panel.add(checkBox1);
		panel.add(checkBox2);
	}

	public void createRadios(Panel panel){
		// Create some radio buttons, all in one group 'radioGroup'.
	       RadioButton radioButton1 = new RadioButton("nombreGrupo", "Primero");
	       RadioButton radioButton2 = new RadioButton("nombreGrupo", "Segundo");
	       RadioButton radioButton3 = new RadioButton("nombreGrupo", "Tercero");

	       // Check 'First' by default.
	       radioButton1.setValue(true);

	      //disable 'Second' radio button
	      radioButton2.setEnabled(false);

	      // Add toggle button to the root panel.      
	      panel.add(radioButton1);
	      panel.add(radioButton2);
	      panel.add(radioButton3);
	}
	
	public void createListBox(Panel panel){
		// Make a new list box, adding a few items to it.
	      ListBox listBox1 = new ListBox();
	      listBox1.addItem("Uno");
	      listBox1.addItem("Dos");
	      listBox1.addItem("Tres");
	      listBox1.addItem("Cuatro");
	      listBox1.addItem("Cinco");
	      
	   // add a clickListener 
	      listBox1.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				int seleccionado=listBox1.getSelectedIndex();
				String txtSeleccionado=listBox1.getItemText(seleccionado);
				Window.alert("Se selecciono "+ txtSeleccionado + " que es el elemento " + seleccionado);
				
			}
		});


	      // Make a new list box, adding a few items to it.
	      ListBox listBox2 = new ListBox();
	      listBox2.addItem("Uno","1");
	      listBox2.addItem("Dos","2");
	      listBox2.addItem("Tres","3");
	      listBox2.addItem("Cuatro","4");
	      listBox2.addItem("Cinco","5");

	      // Make enough room for all five items 
	      listBox1.setVisibleItemCount(5);
		  
	      //setting itemcount value to 1 turns listbox into a drop-down list.
	      listBox2.setVisibleItemCount(1);
	      
	   // add a clickListener 
	      listBox2.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					int seleccionado=listBox2.getSelectedIndex();
					String txtSeleccionado=listBox2.getItemText(seleccionado);
					Window.alert("Se selecciono "+ txtSeleccionado + " que es el elemento " + seleccionado
							+ "\n o tambien " + listBox2.getSelectedItemText()
							+ "\n y con el valor " + listBox2.getSelectedValue());
					
				}
			});


	      // Add listboxes to the root panel.
	      panel.add(listBox1);
	      panel.add(listBox2);
	}

	public void createSuggestBox(Panel panel){
		//create the suggestion data 	  
	      MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();  
	      oracle.add("Abelardo");
	      oracle.add("Adan");
	      oracle.add("Adolfo");
	      oracle.add("Arturo");
	      oracle.add("Bartolo");
	      oracle.add("Benjamin");
	      oracle.add("Bernardo");
	      oracle.add("Bruno");
	      oracle.add("Cain");
	      oracle.add("Carlos");
	      oracle.add("Carmen");
	      oracle.add("Cristiano");
	      oracle.add("Diego");
	      oracle.add("Dimas");
	      oracle.add("Domingo");
	      oracle.add("Doroteo");
	      
	      //create the suggestion box and pass it the data created above
	      SuggestBox suggestionBox = new SuggestBox(oracle);
	 
	      //set width to 200px.
	      suggestionBox.setWidth("200");
	      
	      // Add suggestionbox to the root panel. 
	      
	      panel.add(suggestionBox);

	   }	

	public void createTextBox(Panel panel){
		//create textboxes
	      TextBox textBox1 = new TextBox(); 
	      TextBox textBox2 = new TextBox();

	      //add text to text box
	      textBox2.setText("Hello World!");

	      //set textbox as readonly
	      textBox2.setReadOnly(true);

	      // Add text boxes to the root panel.
	      panel.add(textBox1);
	      panel.add(textBox2);
	}
	
	public void createPasswordTextBox(Panel panel){
		//create password textboxes
	      PasswordTextBox passwordTextBox1 = new PasswordTextBox(); 
	      PasswordTextBox passwordTextBox2 = new PasswordTextBox();

	      //add text to text box
	      passwordTextBox2.setText("hell@W@rld");

	      //set textbox as readonly
	      passwordTextBox2.setReadOnly(true);

	      // Add text boxes to the root panel.
	      panel.add(passwordTextBox1);
	      panel.add(passwordTextBox2);

	}
	
	public void createTextArea(Panel panel){
		 //create textarea elements
	      TextArea textArea1 = new TextArea(); 
	      TextArea textArea2 = new TextArea();

	      //set width as 10 characters
	      textArea1.setCharacterWidth(20);
	      textArea2.setCharacterWidth(30);
	     
	      //set height as 5 lines
	      textArea1.setVisibleLines(5);
	      textArea2.setVisibleLines(6);
	      
	      //add text to text area
	      textArea2.setText(" Hola Mundo! \n a que se podia esperar \n que este texto se repitiese \n hasta la saciedad");

	      //set textbox as readonly
	      textArea2.setReadOnly(true);

	      // Add text boxes to the root panel.
	      panel.add(textArea1);
	      panel.add(textArea2);
	}
	
	public void createRichTextArea(Panel panel){
		//create RichTextArea elements
	      RichTextArea richTextArea = new RichTextArea(); 
	      
	      richTextArea.setHeight("200");
	      richTextArea.setWidth("200");
	      
	      //add text to text area
	      richTextArea.setHTML("<b>Hello World!</b> <br/> <br/>" + 
		  "<i>Be Happy!</i> </br> <br/> <u>Stay Cool!</u>");

	      RichTextToolbar toolbar = new RichTextToolbar(richTextArea);
	      toolbar.ensureDebugId("cwRichText-toolbar");
	      toolbar.setWidth("100%");

	      // Add the components to a panel
	      Grid grid = new Grid(2, 1);
	      grid.setStyleName("cw-RichText");
	      grid.setWidget(0, 0, toolbar);
	      grid.setWidget(1, 0, richTextArea);
	    
	      panel.add(grid);      
	}

	public void createFileUpload(Panel panel){
		//create a FormPanel 
	      final FormPanel form = new FormPanel();
	      //create a file upload widget
	      final FileUpload fileUpload = new FileUpload();
	      //create labels
	      Label selectLabel = new Label("Indique un fichero:");
	      //create upload button
	      Button uploadButton = new Button("Enviar fichero");
	      //pass action to the form to point to service handling file 
	      //receiving operation.
	      form.setAction("");
	      // set form to use the POST method, and multipart MIME encoding.
	      form.setEncoding(FormPanel.ENCODING_MULTIPART);
	      form.setMethod(FormPanel.METHOD_POST);
	    
	      //add a label
	      panel.add(selectLabel);
	      //add fileUpload widget
	      panel.add(fileUpload);
	      //add a button to upload the file
	      panel.add(uploadButton);
	      uploadButton.addClickHandler(new ClickHandler() {
	         @Override
	         public void onClick(ClickEvent event) {
	            //get the filename to be uploaded
	            String filename = fileUpload.getFilename();
	            if (filename.length() == 0) {
	               Window.alert("No se ha indicado fichero!");
	            } else {
	               //submit the form
	               form.submit();			          
	            }				
	         }
	      });
	   
	      form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
	         @Override
	         public void onSubmitComplete(SubmitCompleteEvent event) {
	            // When the form submission is successfully completed, this 
	            //event is fired. Assuming the service returned a response 
	            //of type text/html, we can get the result text here 
	            Window.alert(event.getResults());				
	         }

			
	      });
		  
	      // Add form to the root panel.      
	      form.add(panel); 
	}
	
	public void createHidden(Panel panel){
		//create textboxes
	      final TextBox textBox = new TextBox(); 
	      textBox.setWidth("275");
	      Button button1 = new Button("Asignar contenido al campo oculto");
	      Button button2 = new Button("Leer valor desde campo oculto");
	      final Hidden hidden = new Hidden();

	      button1.addClickHandler(new ClickHandler() {
	         @Override
	         public void onClick(ClickEvent event) {
	            hidden.setValue(textBox.getValue());
	            Window.alert("Se actualizo el valor del campo oculto!");
	         }
	      });

	      button2.addClickHandler(new ClickHandler() {
	         @Override
	         public void onClick(ClickEvent event) {
	            Window.alert("El valor del campo oculto es...: " + hidden.getValue());				
	         }
	      });

	     // Add widgets to the root panel.
	     panel.add(textBox);
	     panel.add(button1);
	     panel.add(hidden);
	     panel.add(button2);
	}
	
	public void resetea(Panel panel) {
		panel.removeStyleName("bk_blue");
		panel.removeStyleName("bk_green");
		panel.removeStyleName("bk_red");
	}

}
