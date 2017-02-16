package br.ufrpe.GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.beans.Cliente;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalGui extends Application implements Initializable{
	@FXML
	private JFXPasswordField password;
	
	@FXML
	private JFXTextField login;
	
	@FXML
	private JFXButton okButton, buttonAddCliente, buttonRemoverCliente, buttonListarCliente, buttonPesquisarCliente, buttonAtualizarCliente, buttonCancelar;
	
	@FXML
	private Label Aviso, AvisoCadastroCliente, clienteEncontrado, ClienteDeletado ;
	
	@FXML
	private Button buttonCliente, buttonCadastrarCliente, buttonCancelarCadastroCliente, buttonCadastrarNovoCliente, buttonProcurar, buttonDeletar	;
	
	private static Funcionario logado;
	
	@FXML	
	private TextField nome, cpf, aniversario, cep, rua, numero, complemento, cidadeUF, buscaRemover;
	
	@FXML
	public void removerCliente(ActionEvent evt){
		ScreenManager.getInstance().showClienteRemover();
	}
	
	@FXML
	public void cadastrarCliente(ActionEvent evt){
		if(nome.getText().isEmpty() || cpf.getText().isEmpty() || aniversario.getText().isEmpty() || cep.getText().isEmpty() || rua.getText().isEmpty() || numero.getText().isEmpty() || complemento.getText().isEmpty() || cidadeUF.getText().isEmpty()){
			AvisoCadastroCliente.setText("Todos os campos devem ser preenchidos");
		}else{
			if(dataOk(aniversario.getText())){
				ControladorPessoa p = carregarCadastros();
				Pessoa novo = null;
				boolean ok = true;
				try{					
					Endereco end = new Endereco(rua.getText(), complemento.getText(), Short.parseShort(numero.getText()), cep.getText(), cidadeUF.getText());
					DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate aniversario = LocalDate.parse(this.aniversario.getText(), DATE_FORMAT);
					novo = new Cliente(cpf.getText(),aniversario, nome.getText(), end);
				}catch(NumberFormatException e){
					AvisoCadastroCliente.setText("Numero de residencia deve ser um numero");
				}
				try {
					p.cadastrar(novo);
				} catch (ObjectNaoExisteException | ErroAoSalvarException | ObjectJaExisteException e) {
					AvisoCadastroCliente.setText(e.getMessage());
					ok = false;
				}
				if(ok){
					AvisoCadastroCliente.setText("Cliente cadastrado com sucesso");
					buttonCadastrarCliente.setVisible(false);
					buttonCadastrarCliente.setDisable(true);
					buttonCadastrarNovoCliente.setVisible(true);
					buttonCadastrarNovoCliente.setDisable(false);
					buttonCancelarCadastroCliente.setText("Voltar");
				}
			}else{
				AvisoCadastroCliente.setText("Data invalida ou escrita num formato invalido(\"dia-mes-ano\")");
			}
		}
	}
	
	@SuppressWarnings("finally")
	public boolean dataOk(String data){
		boolean ok = false;
		try{
			DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dataok = LocalDate.parse(data, DATE_FORMAT);
			ok = true;
		}catch(DateTimeParseException e){
			AvisoCadastroCliente.setText("Data deve ser escrita no formato: \"dia-mes-ano\"");
		}finally{
			return ok;			
		}
	}
	
	@FXML
	public void cadastroCliente(ActionEvent evt){
		ScreenManager.getInstance().showMenuCliente();
	}

	@FXML
	public void voltarMenu(ActionEvent evt){
		if(logado.getCargo().equalsIgnoreCase("Gerente") ||
				logado.getCargo().equalsIgnoreCase("Administrador")){
			abrirMenu(evt);
		}else{
			abrirMenuFuncionario(evt);
		}
	}

	
	@FXML
	public void menuCliente(ActionEvent evt){
		ScreenManager.getInstance().showMenuCliente();	
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
			Aviso.setText("Senha deve ser escrita em numeros");
			warn = false;
		}
		if(p.login(login, password)){
			try {
				logado = (Funcionario) p.buscar(new Login(login, password));
				if(logado.getCargo().equalsIgnoreCase("Gerente") ||
						logado.getCargo().equalsIgnoreCase("Administrador")){
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
		ScreenManager.getInstance().showMenu();
	}
	
	
	@FXML
	private void abrirMenu(ActionEvent evt) {
		ScreenManager.getInstance().showMenu();
	}
	
	
	private ControladorPessoa carregarCadastros() {
		ControladorPessoa p = new ControladorPessoa(RepositorioPessoa.getInstance());
		return p;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ScreenManager.getInstance().showLogin();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}

}