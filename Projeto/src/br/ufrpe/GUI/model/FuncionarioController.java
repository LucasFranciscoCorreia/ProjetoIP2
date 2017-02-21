package br.ufrpe.GUI.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.FachadaControlador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FuncionarioController{
	@FXML
	private Button buttonRemover, buttonAtualizar;
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
	
	public void preencherTabela() {
		ArrayList<Funcionario> funcionarioLista = FachadaControlador.getInstance().listarFuncionario();
		
		nomeTab.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		cpfTab.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cpf"));
		salarioTab.setCellValueFactory(new PropertyValueFactory<Funcionario, Double>("salario"));
		cargoTab.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cargo"));
		
		tableFuncionario.setPlaceholder(new Label("Nenhum registro encontrado."));
		tableFuncionario.setItems(FXCollections.observableArrayList(funcionarioLista));	
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
	
	public boolean cpfOk(String cpf){
		boolean ok = true;
		char[] cpfChar = cpf.toCharArray();
		
		if(cpf.length() == 11){
			for(int i = 0; i < cpf.length(); i++){
				if(!Character.isDigit(cpfChar[i])){
					ok = false;
				}
			}			
		}else{
			ok = false;
		}
		
		return ok;
	}
	
	public String cpfPadronizar(String cpf){
		String novoCpf = "";
		char[] cpfChar = cpf.toCharArray();
		
		for(int i = 0; i < cpf.length(); i++){
			novoCpf += cpfChar[i];
			if(i == 2 || i == 5){
				novoCpf += ".";
			}else if(i == 8){
				novoCpf += "-";
			}
		}
		
		return novoCpf;
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
		FuncionarioController controlador = ScreenManager.getInstance().getFuncionarios().getController();
		controlador.preencherTabela();
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
			if(dataOk(aniversario.getText()) && cpfOk(cpf.getText())){
				try {
					String cpfNovo = cpfPadronizar(cpf.getText());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate date = LocalDate.parse(this.aniversario.getText(), formatter);
					
					Endereco end = new Endereco(rua.getText(), complemento.getText(), 
							Short.valueOf(numero.getText()), cep.getText(), 
							cidadeUF.getText());
					
					Funcionario funcionario = new Funcionario(nome.getText(), cpfNovo, 
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
			}else{
				avisoCadastro.setText("Entre com dados corretos!!");
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
		} if(!aviso.getText().isEmpty()){
			aviso.setText("");
		}
		
		if(cpfOk(cpf.getText())){
			try {				
				Funcionario achada = null;
				String cpfNovo = cpfPadronizar(cpf.getText());
				
				achada = (Funcionario) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
				
				aviso.setText("Funcionario(a) encontrado no sistema!!!");
				funcionarioToString.setText(achada.toString());
			} catch (ObjectNaoExisteException e) {
				aviso.setText(e.getMessage());
			}
		}else{
			aviso.setText("CPF invalido");
		}
		
		if(!cpf.getText().isEmpty()){
			cpf.setText("");
		}
	}
	
	@FXML
	public void buttonPesquisarFuncionarioRemover(ActionEvent event){		
		if(cpfOk(cpf.getText())){
			try {				
				Funcionario achada = null;
				String cpfNovo = cpfPadronizar(cpf.getText());
				
				achada = (Funcionario) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
				
				aviso.setText("Funcionario(a) encontrado no sistema!!!");
				funcionarioToString.setText(achada.toString());

				buttonRemover.setVisible(true);
			} catch (ObjectNaoExisteException e) {
				aviso.setText(e.getMessage());
			}
		}else{
			aviso.setText("Informe um CPF válido");
		}
		
	}
	
	@FXML
	public void buttonPesquisarFuncionarioAtualizar(ActionEvent event){
		if(cpfOk(cpf.getText())){
			try {				
				Funcionario achada = null;
				String cpfNovo = cpfPadronizar(cpf.getText());
				
				achada = (Funcionario) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
				
				aviso.setText("Funcionario(a) encontrado no sistema!!!");
				funcionarioToString.setText(achada.toString());
				
				buttonAtualizar.setVisible(true);
				
			} catch (ObjectNaoExisteException e) {
				aviso.setText(e.getMessage());
			}
			
		}else{
			aviso.setText("Informe um CPF válido!!!");
		}
		if(!avisoAtualizar.getText().isEmpty() && !funcionarioToString.getText().isEmpty()){
			avisoAtualizar.setText("");
			funcionarioToString.setText("");
		}
					
	}
	
	@FXML
	public void buttonFuncionarioRemover(ActionEvent event) {
		if(cpfOk(cpf.getText())){
			try {
				String cpfNovo = cpfPadronizar(cpf.getText());
				
				FachadaControlador.getInstance().removerPessoa(cpfNovo);
				FachadaControlador.getInstance().salvarNoArquivoPessoa();
				
				avisoRemover.setText("Funcionario removido do sistema!!!");
				buttonRemover.setVisible(false);
			} catch (ObjectNaoExisteException | ErroAoRemoverException e) {
				avisoRemover.setText(e.getMessage());
			}			
		}else{
			avisoRemover.setText("Informe um CPF válido!!!");
		}

		if(!cpf.getText().isEmpty()){
			cpf.setText("");
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
		boolean salvar = false;
		
		if(cpfOk(cpf.getText())){
			String cpfNovo = cpfPadronizar(cpf.getText());
			Funcionario novo = new Funcionario(cpfNovo);

			if(!cargo.getText().isEmpty()){
				novo.setCargo(cargo.getText());
				salvar = true;
			} if (!salario.getText().isEmpty()) {
				novo.setSalario(Double.parseDouble(salario.getText()));
				salvar = true;
			} if (!rua.getText().isEmpty() && !numero.getText().isEmpty() && !cep.getText().isEmpty()
				&& !cidadeUF.getText().isEmpty() && !cpf.getText().isEmpty()
				&& !nome.getText().isEmpty() && !aniversario.getText().isEmpty()
				&& !salario.getText().isEmpty() && !cargo.getText().isEmpty()) {
			
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
					buttonAtualizar.setVisible(false);
				} catch (ObjectNaoExisteException | ErroAoAtualizarException e) {
					avisoAtualizar.setText(e.getMessage());
				}				
			}else{
				avisoAtualizar.setText("Dados incompletos!!!");
			}
			
		}else{
			avisoAtualizar.setText("Informe um CPF válido!!!");
		}
	}
}
