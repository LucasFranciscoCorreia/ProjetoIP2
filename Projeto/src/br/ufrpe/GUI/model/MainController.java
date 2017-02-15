package br.ufrpe.GUI.model;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.repositorios.RepositorioPessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainController implements Initializable{
	@FXML
	private JFXPasswordField password;
	@FXML
	private JFXTextField login;
	@FXML
	private JFXButton okButton;
	
	public MainController(){
		
	}
	@FXML
	public void realizarLogin(ActionEvent evt){
		ControladorPessoa p = new ControladorPessoa(RepositorioPessoa.getInstance());
		Pessoa lucas = new Funcionario("Lucas", "101.575.184-93",new Endereco(), 3500, LocalDate.of(1996, 7, 26), "Balconista");
		Pessoa diego = new Funcionario("Diego", "108.332.834-48",new Endereco(), 3500, LocalDate.of(1997, 4, 24), "Balconista");
		Pessoa fernanda = new Funcionario("Fernanda", "xxx.xxx.xxx-yy",new Endereco(), 3500, LocalDate.of(1997, 4, 25), "Balconista");
		Pessoa raissa = new Funcionario("Raissa", "xxx.xxx.xxx-yx",new Endereco(), 3500, LocalDate.of(1998, 4,22), "Balconista");
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
