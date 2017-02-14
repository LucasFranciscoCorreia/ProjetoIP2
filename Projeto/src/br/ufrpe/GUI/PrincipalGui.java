package br.ufrpe.GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.repositorios.RepositorioPessoa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalGui extends Application implements Initializable{
	@FXML
	private JFXPasswordField password;
	@FXML
	private JFXTextField login;
	@FXML
	private JFXButton okButton;
	@FXML
	private Label Aviso;
	private Stage primaryStage;
	private AnchorPane rootLayout;
	private Scene scene;
	@FXML
	public void realizarLogin(ActionEvent evt){
		ControladorPessoa p = carregarFuncionarios();
		String login = this.login.getText();
		int password = 0;
		boolean warn = true;
		try{			
			password = Integer.parseInt(this.password.getText());
		}catch(NumberFormatException e){
			Aviso.setText("Senha deve ser escrita em numeros");
			warn = false;
		}
		if(p.login(login, password)){
			try {
				Funcionario adm =(Funcionario) p.buscar(new Login(login, password));
				if(adm.getCargo().equalsIgnoreCase("Gerente") ||
						adm.getCargo().equalsIgnoreCase("Administrador")){
					abrirMenu(evt);
				}else{
					abrirMenuFuncionario(evt);
				}
			} catch (ObjectNaoExisteException e) {
				Aviso.setText(e.getMessage());
			}
		}else{
			if(warn){
				Aviso.setText("Senha ou login invalido");				
			}
		}
	}
	private void abrirMenuFuncionario(ActionEvent evt) {
		((Node) (evt.getSource())).getScene().getWindow().hide();
		FXMLLoader menu = new FXMLLoader(getClass().getResource("view/Menu.fxml"));
		AnchorPane rootMenu = null;
		try {
			rootMenu = (AnchorPane) menu.load();
		} catch (IOException e) {
			Aviso.setText(e.getMessage());
		}
		//Scene scene = new Scene(rootMenu);
		//primaryStage = new Stage();
		//primaryStage.setScene(scene);
		//primaryStage.setTitle("Menu");
		//primaryStage.show();
	}
	private void abrirMenu(ActionEvent evt) {
		((Node) (evt.getSource())).getScene().getWindow().hide();
		FXMLLoader menu = new FXMLLoader(getClass().getResource("view/Menu.fxml"));
		AnchorPane rootMenu = null;
		try {
			rootMenu = (AnchorPane) menu.load();
		} catch (IOException e) {
			Aviso.setText(e.getMessage());
		}
		Scene scene = new Scene(rootMenu);
		primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Menu");
		primaryStage.show();
	}
	private ControladorPessoa carregarFuncionarios() {
		ControladorPessoa p = new ControladorPessoa(RepositorioPessoa.getInstance());
		Pessoa lucas = new Funcionario("Lucas", "101.575.184-93",new Endereco(), 3500, LocalDate.of(1996, 7, 26), "Gerente");
		Pessoa diego = new Funcionario("Diego", "108.332.834-48",new Endereco(), 3500, LocalDate.of(1997, 4, 24), "Balconista");
		Pessoa fernanda = new Funcionario("Fernanda", "xxx.xxx.xxx-yy",new Endereco(), 3500, LocalDate.of(1997, 4, 25), "Balconista");
		Pessoa raissa = new Funcionario("Raissa", "xxx.xxx.xxx-yx",new Endereco(), 3500, LocalDate.of(1998, 4,22), "Balconista");
		try {
			p.cadastrar(lucas);
			p.cadastrar(diego);
			p.cadastrar(fernanda);
			p.cadastrar(raissa);
		} catch (ObjectNaoExisteException |ErroAoSalvarException | ObjectJaExisteException e) {
			Aviso.setText(e.getMessage());
		}
		return p;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			this.primaryStage = new Stage();
			this.primaryStage.setTitle("Pet42");
			this.primaryStage.setResizable(false);
			initRootLayout();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void initRootLayout(){
		try{	
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PrincipalGui.class.getResource("view/Login.fxml"));
			rootLayout = (AnchorPane) loader.load();
			scene = new Scene(rootLayout);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		launch(new String[0]);
	}

}