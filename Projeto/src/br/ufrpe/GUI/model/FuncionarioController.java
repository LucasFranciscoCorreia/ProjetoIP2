package br.ufrpe.GUI.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.negocios.FachadaControlador;
import br.ufrpe.repositorios.RepositorioPessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FuncionarioController {
	@FXML
	private TextField nome, cpf, aniversario;
	@FXML
	private TextField rua, complemento, numero;
	@FXML
	private TextField cep, cidadeUF, salario, cargo;
	@FXML 
	private Label avisoCadastro, avisoRemover, avisoAtualizar, aviso, funcionarioToString;
	@FXML
	private TableView<Funcionario> tableFuncionario;
	@FXML
	private TableColumn<Funcionario, String> nomeTab;
	@FXML
	private TableColumn<Funcionario, String> cpfTab;
	@FXML
	private TableColumn<Funcionario, Double> salarioTab;
	@FXML
	private TableColumn<Funcionario, String> cargoTab;
	// Variavel usada para ter certeza que o funcionario foi encontrado no sistema
	boolean confirmar = false;
	
	public ObservableList<Funcionario> getFuncionarios(){
		ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();
		
		funcionarios.addAll(FachadaControlador.getInstance().listarFuncionario());
		
		return funcionarios;
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
	public void voltarMenu(ActionEvent evt){
		ScreenManager.getInstance().showMenu();
	}
	
	@FXML
	public void abrirFuncionarioCadastrar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioCadastrar();
	}
	
	@FXML
	public void abrirFuncionarioPesquisar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioPesquisar();
	}
	
	@FXML
	public void abrirFuncionarioRemover(ActionEvent event){
		ScreenManager.getInstance().showFuncionarioRemover();
	}
	
	@FXML
	public void abrirFuncionarioAtualizar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioAtualizar();
	}
	
	@FXML
	public void abrirFuncionarioListar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioListar();
		tableFuncionario.setPlaceholder(new Label("Nenhum funcionário foi encontrado."));
		tableFuncionario.setItems(getFuncionarios());
		
		//TODO está incompleto
	}
	
	@FXML
	public void buttonVoltarMenuFuncionario(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioListar();
	}
	
	@FXML
	public void buttonSalvarCadastrarFuncionario(ActionEvent evento) throws ObjectNaoExisteException{
		if(rua.getText().isEmpty() || numero.getText().isEmpty() || cep.getText().isEmpty()
				|| cidadeUF.getText().isEmpty() || cpf.getText().isEmpty()
				|| nome.getText().isEmpty() || aniversario.getText().isEmpty()
				|| salario.getText().isEmpty() || cargo.getText().isEmpty()){
			avisoCadastro.setText("Dado Inválido!! Tente novamente");
		
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
					
					FachadaControlador.getInstance().cadastrar(funcionario);
					FachadaControlador.getInstance().salvarNoArquivoPessoa();
					
					avisoCadastro.setText(nome.getText() + " cadastrado(a) com sucesso no sistema");
				} catch (NumberFormatException e) {
					avisoCadastro.setText("Numero de residencia deve ser um numero");
				} catch (ErroAoSalvarException | ObjectJaExisteException e) {
					avisoCadastro.setText(e.getMessage());
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
			
		} else if (!avisoCadastro.getText().isEmpty()) {
			avisoCadastro.setText("");
		}
	}
	
	@FXML
	public void buttonPesquisarFuncionario(ActionEvent event){
		if(!funcionarioToString.getText().isEmpty()){
			funcionarioToString.setText("");
		}else if (!aviso.getText().isEmpty()) {
			aviso.setText("");
		}
		
		
		if(cpf.getText().isEmpty()){
			aviso.setText("Informe um CPF valido!!!");
		}else{
			try {
				Funcionario achada = null;
				
				achada = (Funcionario) FachadaControlador.getInstance().buscarPessoa(cpf.getText());
				aviso.setText("Funcionario(a) encontrado no sistema!!!");
				funcionarioToString.setText(achada.toString());
			} catch (ObjectNaoExisteException e) {
				aviso.setText(e.getMessage());
			}
		}
	}
	
	
	@FXML
	public void buttonFuncionarioRemover(ActionEvent event) {
		if(!cpf.getText().isEmpty()){
			try {
				FachadaControlador.getInstance().removerPessoa(cpf.getText());
				FachadaControlador.getInstance().salvarNoArquivoPessoa();
				
				avisoRemover.setText("Funcionario removido do sistema!!!");
			} catch (ObjectNaoExisteException | ErroAoRemoverException e) {
				avisoRemover.setText(e.getMessage());
			}
		}else{
			avisoRemover.setText("Dado invalido!!!");
		}

		if(!avisoRemover.getText().isEmpty() || !aviso.getText().isEmpty() 
				|| !funcionarioToString.getText().isEmpty()){
			avisoRemover.setText("");
			aviso.setText("");
			funcionarioToString.setText("");
		}
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
					FachadaControlador.getInstance().atualizar(novo);
					FachadaControlador.getInstance().salvarNoArquivoPessoa();
					
					avisoAtualizar.setText("Informações atualizadas");
					
				} catch (ObjectNaoExisteException | ErroAoAtualizarException e) {
					avisoAtualizar.setText(e.getMessage());
				}				
			}else{
				avisoAtualizar.setText("Dados incompletos!!!");
			}
			
		}else{
			avisoAtualizar.setText("Dados inválidos!!!");
		}
	}
	
	public void initialize (URL url, ResourceBundle rb){
		nomeTab.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		cpfTab.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cpf"));
		salarioTab.setCellValueFactory(new PropertyValueFactory<Funcionario, Double>("salario"));
		cargoTab.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cargo"));
	}
}
