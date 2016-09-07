package es.rf.gwt_util.work;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;

public class TextBoxOptional extends Composite {
	private String previousText = "";
	private boolean checkedEnablesText;
	private boolean clearTextOnDisable;
	
	private TextBox textBox = new TextBox();
	private CheckBox checkBox = new CheckBox();
	

	public TextBoxOptional(String caption, 
							boolean checkedEnablesText, 
							boolean isChecked) {
		this.checkedEnablesText = checkedEnablesText;
		FlowPanel panel = new FlowPanel();
		initWidget(panel);
		setStyleName("rf-opt-text-widget");
		textBox.setStyleName("rf-opt-textbox");
		checkBox.setStyleName("rf-opt-checkbox");
		panel.add(checkBox);
		panel.add(textBox);
		checkBox.setText(caption);
		checkBox.setValue(isChecked);
		enableTextBox(checkedEnablesText, isChecked);
		checkBox.addClickHandler(new CheckBoxHandler());
	}

	private void enableTextBox(boolean checkedEnables, boolean isChecked) {
		boolean enable = (checkedEnables && isChecked) || (!checkedEnables && !isChecked);
		textBox.setStyleDependentName("disabled", !enable);
		clearOrRestoreTextBox(enable);
		textBox.setEnabled(enable);
	}

	private void clearOrRestoreTextBox(boolean enabledTextBox) {
		if (clearTextOnDisable && !enabledTextBox) {
			previousText = textBox.getText();
			textBox.setText("");
		} else {
			textBox.setText(previousText);
		}
	}

	public void setCaption(String caption) {
		checkBox.setText(caption);
	}

	public String getText() {
		return textBox.getText();
	}

	public boolean isChecked() {
		return checkBox.getValue();
	}

	public void setClearTextOnDisable(boolean clearTextOnDisable) {
		this.clearTextOnDisable = clearTextOnDisable;
	}

	private class CheckBoxHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
		enableTextBox(checkedEnablesText, checkBox.getValue());
		 } 
	}
}
