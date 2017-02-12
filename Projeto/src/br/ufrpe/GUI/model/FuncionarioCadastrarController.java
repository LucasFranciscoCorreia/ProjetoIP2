package br.ufrpe.GUI.model;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FuncionarioCadastrarController {
	
	@FXML
	private TextField nomeFuncionario;
	@FXML
	private TextField cpfFuncionario;
	@FXML
	private TextField dataFuncionario;
	@FXML
	private TextField ruaFuncionario;
	@FXML
	private TextField complementoFuncionario;
	@FXML
	private TextField numeroFuncionario;
	@FXML
	private TextField cepFuncionario;
	@FXML
	private TextField cidadeFuncionario;
	@FXML
	private TextField salarioFuncionario;
	@FXML
	private TextField cargoFuncionario;
	@FXML 
	private Label label;
	
	
	@FXML
	private void buttonSalvar(ActionEvent event){
		//TODO
	}
	
	@FXML
	private void buttonMenuAction (ActionEvent  event){
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
	
	@FXML
	private void buttonListarAction (ActionEvent event){
		//Limpar a tela anterior
		((Node) (event.getSource())).getScene().getWindow().hide();
		//TODO
	}
	
	@FXML
	private void buttonPesquisarAction (ActionEvent event){
		//Limpar a tela anterior
		((Node) (event.getSource())).getScene().getWindow().hide();
		//TODO
	}
	
	
}
