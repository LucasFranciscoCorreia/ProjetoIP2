package br.ufrpe.GUI.model;

import javafx.scene.control.TextField;
import java.util.ArrayList;

import br.ufrpe.GUI.ScreenManager;
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
	private TableView<Servico> servicosTable;
	@FXML
	private TableColumn<Servico, String> nomeCol;
	@FXML
	private TableColumn<Servico, String> codigoCol;
	@FXML
	private TableColumn<Servico, Float> precoCol;
	
	@FXML
	private TextField codigo, cpf, nomeAnimal;
	@FXML
	private Label avisoPesquisar, avisoCliente, listarAnimais, avisoServico;
	@FXML
	private AnchorPane clientePesquisarScene, petsScene, iniciarServicoScene;
	
	

	public void preencherTabela(){
		ArrayList<Servico> servicoListar = FachadaControlador.getInstance().listarServico();
		
		nomeCol.setCellValueFactory(new PropertyValueFactory<Servico, String>("nome"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Servico, Float>("preco"));
		codigoCol.setCellValueFactory(new PropertyValueFactory<Servico, String>("codigo"));
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
