package br.ufrpe.GUI;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.negocios.FachadaControlador;
import br.ufrpe.repositorios.RepositorioPessoa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrincipalGui extends Application implements Initializable{
	@FXML
	private JFXPasswordField password;
	
	@FXML
	private JFXTextField login;
	
	@FXML
	private TableView<Funcionario> tableFuncionario;
	
	@FXML
	private Label aviso;
	
	private static Funcionario logado;
	
	@FXML
	public void abrirFuncionarioListar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioListar();
	}
	
	@FXML
	public void abrirClienteListar(ActionEvent evento){
		ScreenManager.getInstance().showClienteListar();
	}
	
	@FXML
	public void voltarMenu(ActionEvent evt){
		if(logado.getCargo().equalsIgnoreCase("Gerente") ||
				logado.getCargo().equalsIgnoreCase("Administrador")){
			ScreenManager.getInstance().showMenu();
		}else{
			ScreenManager.getInstance().showMenuCaixa();
		}
	}

	
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


	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		ScreenManager.getInstance().setMainStage(primaryStage);
		ScreenManager.getInstance().showLogin();
	}
	public static void main(String[] args) {
		launch(args);
	}

}