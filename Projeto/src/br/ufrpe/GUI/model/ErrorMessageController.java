package br.ufrpe.GUI.model;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ErrorMessageController implements Initializable {
	@FXML
	private Label ErrorMessage;
	
	public ErrorMessageController(String txt){
		ErrorMessage.setText(txt);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
