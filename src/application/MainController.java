package application;


import java.io.IOException;

import org.w3c.dom.events.EventListener;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class MainController {
	
	private MainModel myModel = new MainModel();
	
	@FXML
	private Button LOAD_A;

	@FXML
	private Button SAVE_A;
	
	@FXML
	private Button LOAD_B;

	@FXML
	private Button SAVE_B;
	
	@FXML
	private Button CLEAR;
	
	@FXML
	private Button CLEAR_H;
	
	@FXML
	private Button FIND_B;
	
	@FXML
	private Button OTHER_SAVE;
	
	@FXML
	private TextField TEXT_FIELD;
	
	@FXML
	private TextArea TEXT_AREA;
	
	@FXML
    private RadioButton RAD_B;
	
	@FXML
	void onKeyTyped(KeyEvent event){	
		TEXT_AREA.setWrapText(true);		
	}
	
	//disable one keystroke
	@FXML
	void onKeyPressed(KeyEvent event){	
		if (RAD_B.isSelected()) {
			if (event.getCode() == KeyCode.A) {
				TEXT_AREA.setEditable(false);
				TEXT_AREA.requestFocus();
				}
			else if (event.getCode() != KeyCode.A) {
				TEXT_AREA.requestFocus();
				TEXT_AREA.setEditable(true);
			}
		}	
	}
	
	@FXML
	void Disable(ActionEvent event){
		TEXT_AREA.requestFocus();
	}

	//Read file savea.txt when button is clicked.
	@FXML
    void LoadTextA(ActionEvent event) throws IOException //Load file A
	{
		TEXT_AREA.setText("");
		TEXT_AREA.appendText(myModel.LoadContentA());		
	}
	
	//Write to file savea.txt when button is clicked.
	@FXML
	void SaveTextA(ActionEvent event) throws IOException //Save to file A
	{
		String dataA = null;
		dataA = TEXT_AREA.getText();
		myModel.WriteToFileA(dataA);//call write method from model.
	}

	//Read saveb.txt when button is clicked.
	@FXML
    void LoadTextB(ActionEvent event) throws IOException //Load file B
	{
		TEXT_AREA.setText("");
		TEXT_AREA.appendText(myModel.LoadContentB());		
	}
	
	//Write to file saveb.txt when button is clicked.
	@FXML
	void SaveTextB(ActionEvent event) throws IOException //Save to file B
	{
		String dataB = null;
		dataB = TEXT_AREA.getText();
		myModel.WriteToFileB(dataB);//call write method from model.
	}
	
	@FXML
	void ClearAll(ActionEvent event) //Clear all and replace with "CLEAR" 
	{
		TEXT_AREA.setText("CLEAR" + "\n");
	}
	
	@FXML
	void ClearOnlyLetterH(ActionEvent event) {
		String defaultText = TEXT_AREA.getText();
		String newText = defaultText.replaceAll("(?i)h", ""); //replace all letter "h" and "H" from text file.
		TEXT_AREA.setText(newText);
	}
	
	@FXML
	void WordSearch(ActionEvent event) {
		String selectedWord = TEXT_FIELD.getText().toLowerCase();
		String matchedWord = TEXT_AREA.getText().toLowerCase();
		int pos = matchedWord.indexOf(selectedWord);//get int position of the word that is needed to find
		TEXT_AREA.requestFocus();//must focus on theTextArea
		if (selectedWord.equalsIgnoreCase(selectedWord + " ")) {
		TEXT_AREA.positionCaret(pos);//move cursor to this position
		}
	}
	
	//Textfield and new Save button
	//Only write to file when user type specific name and hit Save.
	@FXML
	void SaveNew(ActionEvent event) throws IOException {
		String fileName = TEXT_FIELD.getText();
		if (fileName.equalsIgnoreCase(fileName)) {
			String data = null;
			data = TEXT_AREA.getText();
			myModel.WriteToFile(data, fileName);//call write method from model.
		}
	}
}

