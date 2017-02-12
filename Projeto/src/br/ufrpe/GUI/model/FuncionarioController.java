package br.ufrpe.GUI.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
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
	private TextField nomeFuncionario, cpfFuncionario, dataFuncionario;
	@FXML
	private TextField ruaFuncionario, complementoFuncionario, numeroFuncionario;
	@FXML
	private TextField cepFuncionario, cidadeFuncionario, salarioFuncionario, salarioNovo;
	@FXML
	private TextField cargoFuncionario, cargoNovo;
	@FXML 
	private Label label, label2, funcionarioToString;
	@FXML
	private TableView<Funcionario> funcionarios;
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
	
	@FXML
	private void buttonSalvarCadastrarFuncionario(ActionEvent event){
		if(ruaFuncionario.getText().isEmpty() || complementoFuncionario.getText().isEmpty()
				|| numeroFuncionario.getText().isEmpty() || cepFuncionario.getText().isEmpty()
				|| cidadeFuncionario.getText().isEmpty() || cpfFuncionario.getText().isEmpty()
				|| nomeFuncionario.getText().isEmpty() || dataFuncionario.getText().isEmpty()
				|| salarioFuncionario.getText().isEmpty() || cargoFuncionario.getText().isEmpty()){
			label.setText("Dado Inválido!! Tente novamente");
		}else{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
			LocalDate date = LocalDate.parse(dataFuncionario.getText(), formatter);
			
			Endereco end = new Endereco(ruaFuncionario.getText(), complementoFuncionario.getText(), 
					Short.valueOf(numeroFuncionario.getText()), cepFuncionario.getText(), 
					cidadeFuncionario.getText());
			
			Funcionario funcionario = new Funcionario(nomeFuncionario.getText(), cpfFuncionario.getText(), 
					end, Double.parseDouble(salarioFuncionario.getText()), date, 
					cargoFuncionario.getText());
			
			//TODO : cadastrar o funcionario no sistema, verificar as possiveis exceptions
			
			label.setText("Funcionario cadastrado no sistema!!");
		}
		
	}
	
	@FXML
	private void buttonSalvarAtualizarFuncionario(ActionEvent event){
		Endereco end = null;
		
		if(ruaFuncionario.getText().isEmpty() || complementoFuncionario.getText().isEmpty()
				|| numeroFuncionario.getText().isEmpty() || cepFuncionario.getText().isEmpty()
				|| cidadeFuncionario.getText().isEmpty()){
			label2.setText("Dado Inválido, tente novamente");
		}else{
			end = new Endereco(ruaFuncionario.getText(), complementoFuncionario.getText(), 
					Short.valueOf(numeroFuncionario.getText()), cepFuncionario.getText(), 
					cidadeFuncionario.getText());			
		}
		
		//TODO atualizar informações 
		
		if(!cargoNovo.getText().isEmpty()){
			
			label2.setText("Alterações salvas!!");
		}else if (!salarioNovo.getText().isEmpty()) {
			label2.setText("Alterações salvas!!");
		}else if (end != null){
			label2.setText("Alterações salvas!!");
		}else{
			label2.setText("Dado inválido!! Tente novamente");
		}
	}
	
	@FXML
	private void buttonPesquisarFuncionario(ActionEvent event){
		if(cpfFuncionario.getText().isEmpty()){
			label.setText("Dado Inválido, tente novamente");
		}else {
			/* Se o funcionario existir:
			*  funcionarioToString.setText(funcionario.toString());
			*/
			
			//mensagem.setText("Funcionario " + );
			//TODO pesquisar funcionario
		}
	}
	
	@FXML
	private void buttonPesquisarFuncionarioNoSistema (ActionEvent event){
		if(cpfFuncionario.getText().isEmpty()){
			label.setText("Dado Inválido, tente novamente");
		}else {
			
			//mensagem.setText("Funcionario " + );
			//TODO pesquisar funcionario
		}
	}
	
	@FXML
	private void buttonRemoverFuncionario (ActionEvent event){
		if(confirmar == true){
			//TODO implementar a remoção de funcionario
		}else{
			label2.setText("Funcionario não pode ser removido!!");
		}
	}
	
	@FXML
	private void buttonMenuAction (ActionEvent  event){
		//Limpar a tela anterior
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		//TODO 
	}
	
	@FXML
	private void buttonAdicionarAction (ActionEvent event){
		//Limpar a tela anterior
		((Node) (event.getSource())).getScene().getWindow().hide();
		//TODO
	}
	
	@FXML
	private void buttonAtualizarAction (ActionEvent event){
		//Limpar a tela anterior
		((Node) (event.getSource())).getScene().getWindow().hide();
		//TODO
	}
	
	@FXML
	private void buttonRemoverAction (ActionEvent event){
		//Limpar a tela anterior
		((Node) (event.getSource())).getScene().getWindow().hide();
		//TODO
	}
	
	public ObservableList<Funcionario> getFuncionario(){
		ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();
		//TODO adicionar funcionarios na lista:
		// funcionarios.add(arg0);
		return funcionarios;
	}
	@FXML
	private void buttonListarAction (ActionEvent event){
		//Limpar a tela anterior
		((Node) (event.getSource())).getScene().getWindow().hide();
		//TODO
		nomeTab.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfTab.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		salarioTab.setCellValueFactory(new PropertyValueFactory<>("salario"));
		cargoTab.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		funcionarios.setItems(getFuncionario());
	}
	
	@FXML
	private void buttonPesquisarAction (ActionEvent event){
		//Limpar a tela anterior
		((Node) (event.getSource())).getScene().getWindow().hide();
		//TODO
	}
}
