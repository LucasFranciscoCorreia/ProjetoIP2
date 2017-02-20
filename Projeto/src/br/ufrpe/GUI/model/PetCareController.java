package br.ufrpe.GUI.model;

import java.util.ArrayList;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Servico;
import br.ufrpe.negocios.FachadaControlador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PetCareController {
	@FXML
	private TableView<Servico> servicosTable;
	@FXML
	private TableColumn<Servico, String> nomeCol;
	@FXML
	private TableColumn<Servico, Float> precoCol;
	
	public void preencherTabela(){
		ArrayList<Servico> servicoListar = FachadaControlador.getInstance().listarServico();
		
		nomeCol.setCellValueFactory(new PropertyValueFactory<Servico, String>("nome"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Servico, Float>("preco"));
		
		servicosTable.setItems(FXCollections.observableArrayList(servicoListar));
	}
	
	@FXML
	public void voltarMenuCaixa(ActionEvent evt){
		ScreenManager.getInstance().showMenuCaixa();
	}
}
