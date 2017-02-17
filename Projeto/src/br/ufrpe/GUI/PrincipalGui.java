package br.ufrpe.GUI;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.negocios.FachadaControlador;

import br.ufrpe.repositorios.RepositorioPessoa;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	private TableView<Funcionario> tableFuncionario;
	
	@FXML
	private TableColumn<Funcionario, String> nomeFuncionario, cpfFuncionario, cargoFuncionario;
	
	@FXML
	private TableColumn<Funcionario, Double> salarioFuncionario;
	@FXML
	private Label Aviso, AvisoCadastro, clienteEncontrado, ClienteDeletado, funcionarioToString, AvisoRemover, AvisoAtualizar;
	
	@FXML
	private Button buttonCliente, buttonCadastrarCliente, buttonCancelarCadastroCliente, buttonCadastrarNovoCliente, buttonProcurar, buttonDeletar	;
	
	private static Funcionario logado;
	
	@FXML	
	private TextField nome, cpf, aniversario, cep, rua, numero, complemento, cidadeUF, buscaRemover, salario, cargo;
	
	
	/*@FXML
	public void removerCliente(ActionEvent evt){
		ScreenManager.getInstance().showClienteRemover();
	}*/
	
	
	@FXML
	public void cadastrarCliente(ActionEvent evt){
		if(nome.getText().isEmpty() || cpf.getText().isEmpty() || aniversario.getText().isEmpty() || cep.getText().isEmpty() || rua.getText().isEmpty() || numero.getText().isEmpty() || complemento.getText().isEmpty() || cidadeUF.getText().isEmpty()){
			AvisoCadastro.setText("Todos os campos devem ser preenchidos");
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
					AvisoCadastro.setText("Numero de residencia deve ser um numero");
				}
				try {
					p.cadastrar(novo);
				} catch (ObjectNaoExisteException | ErroAoSalvarException | ObjectJaExisteException e) {
					AvisoCadastro.setText(e.getMessage());
					ok = false;
				}
				if(ok){
					AvisoCadastro.setText("Cliente cadastrado com sucesso");
					buttonCadastrarCliente.setVisible(false);
					buttonCadastrarCliente.setDisable(true);
					buttonCadastrarNovoCliente.setVisible(true);
					buttonCadastrarNovoCliente.setDisable(false);
					buttonCancelarCadastroCliente.setText("Voltar");
				}
			}else{
				AvisoCadastro.setText("Data invalida ou escrita num formato invalido(\"dia-mes-ano\")");
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
			AvisoCadastro.setText("Data deve ser escrita no formato: \"dia-mes-ano\"");
		}finally{
			return ok;			
		}
	}
	
	@FXML
	public void cadastroCliente(ActionEvent evt){
		ScreenManager.getInstance().showClienteCadastrar();;
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
	public void menuFuncionario(ActionEvent evento){
		ScreenManager.getInstance().showMenuFuncionario();
	}
	
	@FXML
	public void abrirFuncionarioCadastrar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioCadastrar();
	}
	
	@FXML
	public void buttonSalvarCadastrarFuncionario(ActionEvent evento) throws ObjectNaoExisteException{
		if(rua.getText().isEmpty() || numero.getText().isEmpty() || cep.getText().isEmpty()
				|| cidadeUF.getText().isEmpty() || cpf.getText().isEmpty()
				|| nome.getText().isEmpty() || aniversario.getText().isEmpty()
				|| salario.getText().isEmpty() || cargo.getText().isEmpty()){
			AvisoCadastro.setText("Dado Inválido!! Tente novamente");
		
		}else{
			if(dataOk(aniversario.getText())){
				try {
					System.out.println("entrou no try");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate date = LocalDate.parse(this.aniversario.getText(), formatter);
					
					Endereco end = new Endereco(rua.getText(), complemento.getText(), 
							Short.valueOf(numero.getText()), cep.getText(), 
							cidadeUF.getText());
					
					Funcionario funcionario = new Funcionario(nome.getText(), cpf.getText(), 
							end, Double.parseDouble(salario.getText()), date, 
							cargo.getText());	
					
					System.out.println("passou por aqui 1");
					
					ControladorPessoa p = carregarCadastros();
					p.cadastrar(funcionario);
					p.salvarNoArquivo();
					//FachadaControlador.getInstance().cadastrar(funcionario);
					//FachadaControlador.getInstance().salvarNoArquivoPessoa();
					
					AvisoCadastro.setText(nome.getText() + " cadastrado(a) com sucesso no sistema");
				} catch (NumberFormatException e) {
					AvisoCadastro.setText("Numero de residencia deve ser um numero");
				} catch (ErroAoSalvarException | ObjectJaExisteException e) {
					AvisoCadastro.setText(e.getMessage());
				} 
			}				
		}

		if(!rua.getText().isEmpty() || !numero.getText().isEmpty() || !cep.getText().isEmpty()
				|| !cidadeUF.getText().isEmpty() || !cpf.getText().isEmpty()
				|| !nome.getText().isEmpty() || !aniversario.getText().isEmpty()
				|| !salario.getText().isEmpty() || !cargo.getText().isEmpty()){
			
			rua.setText("");
			numero.setText("");
			complemento.setText("");
			cep.setText("");
			cidadeUF.setText("");
			cpf.setText("");
			nome.setText("");
			aniversario.setText("");
			salario.setText("");
			cargo.setText("");
			
		} else if (!AvisoCadastro.getText().isEmpty()) {
			AvisoCadastro.setText("");
		}
	}
	
	@FXML
	public void abrirFuncionarioPesquisar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioPesquisar();
	}
	
	@FXML
	public void buttonPesquisarFuncionario(ActionEvent event){
		if(!funcionarioToString.getText().isEmpty()){
			funcionarioToString.setText("");
		}else if (!Aviso.getText().isEmpty()) {
			Aviso.setText("");
		}
		
		
		if(cpf.getText().isEmpty()){
			Aviso.setText("Informe um CPF valido!!!");
		}else{
			try {
				Funcionario achada = null;
				ControladorPessoa p = carregarCadastros();
				
				achada = (Funcionario) p.buscar(cpf.getText());
				Aviso.setText("Funcionario(a) encontrado no sistema!!!");
				funcionarioToString.setText(achada.toString());
			} catch (ObjectNaoExisteException e) {
				Aviso.setText(e.getMessage());
			}
		}
	}
	
	@FXML
	public void abrirFuncionarioRemover(ActionEvent event){
		ScreenManager.getInstance().showFuncionarioRemover();
	}
	
	@FXML
	public void buttonFuncionarioRemover(ActionEvent event) {
		if(!cpf.getText().isEmpty()){
			try {
				ControladorPessoa p = carregarCadastros();
				p.remover(cpf.getText());
				p.salvarNoArquivo();
				
				AvisoRemover.setText("Funcionario removido do sistema!!!");
			} catch (ObjectNaoExisteException | ErroAoRemoverException e) {
				AvisoRemover.setText(e.getMessage());
			}
		}else{
			AvisoRemover.setText("Dado invalido!!!");
		}

		if(!AvisoRemover.getText().isEmpty() || !Aviso.getText().isEmpty() 
				|| !funcionarioToString.getText().isEmpty()){
			AvisoRemover.setText("");
			Aviso.setText("");
			funcionarioToString.setText("");
		}
	}
	
	@FXML
	public void abrirFuncionarioAtualizar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioAtualizar();
	}
	
	@FXML
	public void buttonAtualizarFuncionario(ActionEvent evento){
		//TODO está incompleto
		boolean salvar = false;
		if(!cpf.getText().isEmpty()){
			Funcionario novo = new Funcionario(cpf.getText());

			if(!cargo.getText().isEmpty()){
				novo.setCargo(cargo.getText());
				salvar = true;
			} if (!salario.getText().isEmpty()) {
				novo.setSalario(Double.parseDouble(salario.getText()));
				salvar = true;
			} if (!rua.getText().isEmpty() || !numero.getText().isEmpty() || !cep.getText().isEmpty()
				|| !cidadeUF.getText().isEmpty() || !cpf.getText().isEmpty()
				|| !nome.getText().isEmpty() || !aniversario.getText().isEmpty()
				|| !salario.getText().isEmpty() || !cargo.getText().isEmpty()) {
				Endereco end = new Endereco(rua.getText(), complemento.getText(), Short.valueOf(numero.getText()), 
						cep.getText(), cidadeUF.getText());
				novo.setEnd(end);
				salvar = true;
			}
			
			if(salvar){
				try {
					ControladorPessoa p = carregarCadastros();
					p.atualizar(novo);
					p.salvarNoArquivo();			
					
					AvisoAtualizar.setText("Informações atualizadas");
					
				} catch (ObjectNaoExisteException | ErroAoAtualizarException e) {
					AvisoAtualizar.setText(e.getMessage());
				}				
			}else{
				AvisoAtualizar.setText("Dados incompletos!!!");
			}
			
		}else{
			AvisoAtualizar.setText("Dados inválidos!!!");
		}
	}
	
	@FXML
	public void abrirFuncionarioListar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioListar();
		tableFuncionario.setItems(getFuncionarios());
		//TODO está incompleto
	}
	
	public ObservableList<Funcionario> getFuncionarios(){
		ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();
		
		funcionarios.addAll(RepositorioPessoa.getInstance().listarFuncionario());
		
		return funcionarios;
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
	public void start(Stage primaryStage) {
		ScreenManager.getInstance().setMainStage(primaryStage);
		ScreenManager.getInstance().showLogin();
	}
	public static void main(String[] args) {
		launch(args);
	}

}