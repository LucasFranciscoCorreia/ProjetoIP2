package br.ufrpe.GUI.model;

import javafx.scene.control.TextField;
import java.util.ArrayList;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
import br.ufrpe.negocios.FachadaControlador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class PetCareController {
	@FXML
	private TableView<Produto> servicosTable;
	@FXML
	private TableColumn<Produto, String> nomeCol;
	@FXML
	private TableColumn<Produto, String> codigoCol;
	@FXML
	private TableColumn<Produto, Float> precoCol;
	
	@FXML
	private TextField codigo, cpf, nomeAnimal;
	@FXML
	private Label avisoPesquisar, avisoCliente, listarAnimais, avisoServico;
	@FXML
	private AnchorPane clientePesquisarScene, petsScene, iniciarServicoScene;
	
	

	public void preencherTabela(){
		ArrayList<Produto> servicoListar = FachadaControlador.getInstance().listarServico();
		
		nomeCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
		codigoCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));
		
		servicosTable.setItems(FXCollections.observableArrayList(servicoListar));
	}
	
	@FXML
	public void abrirRealizarServico(ActionEvent evt){
		ScreenManager.getInstance().showRealizarServico();
	}
	
	@FXML
	public void voltarMenuServico(ActionEvent evt){
		ScreenManager.getInstance().showPetCareMenu();
		PetCareController controlador = ScreenManager.getInstance().getServicos().getController();
		controlador.preencherTabela();
	}
	
	@FXML
	public void voltarMenuCaixa(ActionEvent evt){
		ScreenManager.getInstance().showMenuCaixa();
	}
	
	@FXML
	public void abrirServicoAndamento(ActionEvent evt){
		ScreenManager.getInstance().showServicoAndamento();
	}
	
	@FXML
	public void abrirServicoConcluido(ActionEvent evt){
		ScreenManager.getInstance().showServicoConcluido();
	}
	
	@FXML
	public void pesquisarServico(ActionEvent evt){
		//clientePesquisarScene.setVisible(true);
	}
	
	@FXML
	public void pesquisarCliente(ActionEvent evt){
		//petsScene.setVisible(true);
		//iniciarServicoScene.setVisible(true);
	}
	
	@FXML
	public void iniciarServico(ActionEvent evt){
		
	}
}
