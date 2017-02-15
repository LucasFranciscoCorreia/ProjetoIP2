package br.ufrpe.GUI.model;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.repositorios.RepositorioPessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginController implements Initializable{
	@FXML
	private JFXPasswordField password;
	@FXML
	private JFXTextField login;
	@FXML
	private JFXButton okButton;
	
	public LoginController(){
		
	}
	@FXML
	public void realizarLogin(ActionEvent evt){
		ControladorPessoa p = new ControladorPessoa(RepositorioPessoa.getInstance());
		String login = this.login.getText();
		System.out.println(login);
		int Password = Integer.parseInt(this.password.getText());
		System.out.println(Password);
		System.out.println(p.login(login, Password));
		if(p.login(login, Password)){
			System.out.println("ok");
		}else{
			System.out.println("nao ok");
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}
