package br.ufrpe.GUI.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.FachadaControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FuncionarioController implements Initializable{
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
	boolean confirmar = false;
	
	
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
		
		if(!cpf.isEmpty() && cpf.length() == 14){
			char[] cpfChar = cpf.toCharArray();
			for (int i = 0; i < cpf.length(); i++) {
				if(i != 3 || i != 7 || i != 11){
					if(!Character.isDigit(cpfChar[i])){
						ok = false;
					}					
				}
			}
		}else{
			ok = false;
		}
		
		return ok; 
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
		try {				
			Funcionario achada = null;
			
			achada = (Funcionario) FachadaControlador.getInstance().buscarPessoa(cpf.getText());
			
			aviso.setText("Funcionario(a) encontrado no sistema!!!");
			funcionarioToString.setText(achada.toString());
		} catch (ObjectNaoExisteException e) {
			aviso.setText(e.getMessage());
		}		
		
		if(!cpf.getText().isEmpty()){
			cpf.setText("");
		}
	}
	
	@FXML
	public void buttonPesquisarFuncionarioRemover(ActionEvent event){
		try {				
			Funcionario achada = null;
			
			achada = (Funcionario) FachadaControlador.getInstance().buscarPessoa(cpf.getText());
			
			aviso.setText("Funcionario(a) encontrado no sistema!!!");
			funcionarioToString.setText(achada.toString());

			buttonRemover.setVisible(true);
		} catch (ObjectNaoExisteException e) {
			aviso.setText(e.getMessage());
		}		
		
		
		if(!cpf.getText().isEmpty()){
			cpf.setText("");
		}
	}
	
	@FXML
	public void buttonPesquisarFuncionarioAtualizar(ActionEvent event){
		try {				
			Funcionario achada = null;
			
			achada = (Funcionario) FachadaControlador.getInstance().buscarPessoa(cpf.getText());
			
			aviso.setText("Funcionario(a) encontrado no sistema!!!");
			funcionarioToString.setText(achada.toString());
			
			buttonAtualizar.setVisible(true);
		} catch (ObjectNaoExisteException e) {
			aviso.setText(e.getMessage());
		}				
	}
	
	@FXML
	public void buttonFuncionarioRemover(ActionEvent event) {
		if(!avisoRemover.getText().isEmpty() || !aviso.getText().isEmpty() 
				|| !funcionarioToString.getText().isEmpty()){
			avisoRemover.setText("");
			aviso.setText("");
			funcionarioToString.setText("");
		} 

		try {
			FachadaControlador.getInstance().removerPessoa(cpf.getText());
			FachadaControlador.getInstance().salvarNoArquivoPessoa();
			
			avisoRemover.setText("Funcionario removido do sistema!!!");
		} catch (ObjectNaoExisteException | ErroAoRemoverException e) {
			avisoRemover.setText(e.getMessage());
		}

		if(!cpf.getText().isEmpty()){
			cpf.setText("");
		}
	}
	
	@FXML
	public void buttonAtualizarFuncionario(ActionEvent evento){
		boolean salvar = false;
		
		if(!cpf.getText().isEmpty()){
			Funcionario novo = new Funcionario(cpf.getText());

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

	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		//ArrayList<Funcionario> funcionarioLista = FachadaControlador.getInstance().listarFuncionario();
		
		//nomeTab.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		//cpfTab.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cpf"));
		//salarioTab.setCellValueFactory(new PropertyValueFactory<Funcionario, Double>("salario"));
		//cargoTab.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cargo"));
		
		//tableFuncionario.setItems(FXCollections.observableArrayList(funcionarioLista));	
	}
}
