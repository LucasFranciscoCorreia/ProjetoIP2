<<<<<<< HEAD
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

=======
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
	private JFXButton okButton, buttonAddCliente, buttonRemoverCliente, buttonListarCliente, buttonPesquisarCliente, buttonAtualizarCliente, buttonCancelar;
	
	@FXML
	private Label aviso, avisoCadastro, clienteEncontrado, clienteDeletado, avisoRemover, avisoAtualizar, syso, erroPesquisa;
	
	@FXML
	private Label avisoAddPetCliente, infDonoPet; 
	
	@FXML
	private Button buttonCliente, buttonCadastrarCliente, buttonCancelarCadastroCliente, buttonCadastrarNovoCliente, buttonProcurar, buttonDeletar, btnPesquisar, salvarPet, salvarEnd	;
	
	private static Funcionario logado;
	
	private static Pessoa donoPet;
	
	@FXML	
	private TextField nome, cpf, aniversario, cep, rua, numero, complemento, cidadeUF, buscaRemover, salario, cargo, cpfDono;
	
	@FXML
	private TextField raça, nomePet, peso, altura, especie;
	
	
	@FXML
	public void procuraDono(ActionEvent evt){
		if(cpfDono.getText().isEmpty()){
			infDonoPet.setText("Digite um cpf para busca");
		}else{
			try {
				donoPet = FachadaControlador.getInstance().buscarPessoa(cpfDono.getText());
				infDonoPet.setText(donoPet.getNome());
				raça.setDisable(false);
				nomePet.setDisable(false);
				peso.setDisable(false);
				altura.setDisable(false);
				especie.setDisable(false);
				rua.setDisable(false);
				numero.setDisable(false);
				complemento.setDisable(false);
				cep.setDisable(false);
				cidadeUF.setDisable(false);
				salvarEnd.setDisable(false);
				salvarPet.setDisable(false);
			} catch (ObjectNaoExisteException e) {
				infDonoPet.setText(e.getMessage());
			}
		}
	}
	@FXML
	public void adicionarPet(ActionEvent evt){
		if(raça.getText().isEmpty() || peso.getText().isEmpty() || altura.getText().isEmpty() || especie.getText().isEmpty() || nome.getText().isEmpty()){
			avisoAddPetCliente.setText("Todos os campos devem ser preenchidos");
		}else{
			Animal novo = new Animal(true, especie.getText(), raça.getText(), donoPet, Double.parseDouble(peso.getText()), Double.parseDouble(altura.getText()), nomePet.getText(),null);
			try {
				FachadaControlador.getInstance().cadastrar(novo);
			} catch (ObjectJaExisteException e) {
				avisoAddPetCliente.setText(e.getMessage());
			}
			((Cliente) donoPet).addPet(novo);
			try {
				FachadaControlador.getInstance().atualizar(donoPet);
			} catch (ObjectNaoExisteException | ErroAoAtualizarException e) {
				avisoAddPetCliente.setText(e.getMessage());
			}
		}
		
	}
	
	@FXML
	public void pesquisarCliente(ActionEvent evt){
		Pessoa p;
		try {
			p = (Cliente) FachadaControlador.getInstance().buscarPessoa(this.cpf.getText());
			if(!(p instanceof Cliente)){
				throw new ObjectNaoExisteException();
			}
			syso.setText(p.toString());
		} catch (ObjectNaoExisteException e) {
			erroPesquisa.setText(e.getMessage());
		}
	}
	
	@FXML
	public void atualizaCliente(ActionEvent evt){
		ScreenManager.getInstance().showClienteAtualizar();
	}
	@FXML
	public void pesquisaCliente(ActionEvent evt){
		ScreenManager.getInstance().showClientePesquisar();
	}
	
	@FXML
	public void remocaoCliente(ActionEvent evt){
		ScreenManager.getInstance().showClienteRemover();
	}
	
	@FXML
	public void abrirFuncionarioListar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioListar();
	}
	
	
	@FXML
	public void cadastrarCliente(ActionEvent evt){
		if(nome.getText().isEmpty() || cpf.getText().isEmpty() || aniversario.getText().isEmpty() || cep.getText().isEmpty() || rua.getText().isEmpty() || numero.getText().isEmpty() || complemento.getText().isEmpty() || cidadeUF.getText().isEmpty()){
			avisoCadastro.setText("Todos os campos devem ser preenchidos");
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
					avisoCadastro.setText("Numero de residencia deve ser um numero");
				}
				try {
					p.cadastrar(novo);
				} catch (ObjectNaoExisteException | ErroAoSalvarException | ObjectJaExisteException e) {
					avisoCadastro.setText(e.getMessage());
					ok = false;
				}
				if(ok){
					avisoCadastro.setText("Cliente cadastrado com sucesso");
					FachadaControlador.getInstance().salvarNoArquivoPessoa();
				}
			}else{
				avisoCadastro.setText("Data invalida ou escrita num formato invalido(\"dia-mes-ano\")");
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
			avisoCadastro.setText("Data deve ser escrita no formato: \"dia-mes-ano\"");
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
					abrirMenu(evt);
				}else{
					abrirMenuFuncionario(evt);
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
	
	private void abrirMenuFuncionario(ActionEvent evt) {
		ScreenManager.getInstance().showMenuCaixa();
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

>>>>>>> branch 'master' of https://github.com/LucasFranciscoCorreia/ProjetoIP2.git
}