package br.ufrpe.GUI.model;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.repositorios.RepositorioPessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class LoginController{
	
	@FXML
	private Label aviso;
	@FXML
	private JFXPasswordField password;
	@FXML
	private JFXTextField login;
	
	private static Funcionario logado;
	
	private ControladorPessoa carregarCadastros() {
		ControladorPessoa p = new ControladorPessoa(RepositorioPessoa.getInstance());
		return p;
	}
	
	@FXML
	public void realizarLogin(ActionEvent evt){
		ControladorPessoa p = carregarCadastros();
		String login = this.login.getText();
		int password = 0;
		boolean warn = true;
		try{			
			password = Integer.parseInt(this.password.getText());
		}catch(NumberFormatException e){
			aviso.setText("Senha deve ser escrita em numeros");
			warn = false;
		}
		if(p.login(login, password)){
			try {
				logado = (Funcionario) p.buscar(new Login(login, password));
				if(logado.getCargo().equalsIgnoreCase("Gerente") ||
						logado.getCargo().equalsIgnoreCase("Administrador")){
					ScreenManager.getInstance().showMenu();
				}else{
					ScreenManager.getInstance().showMenuCaixa();
				}
			} catch (ObjectNaoExisteException e) {
				aviso.setText(e.getMessage());
			}
		}else{
			if(warn){
				aviso.setText("Senha ou login invalido");				
			}
		}
	}
	
}
