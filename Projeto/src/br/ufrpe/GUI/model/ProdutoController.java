package br.ufrpe.GUI.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Produto;
import br.ufrpe.negocios.FachadaControlador;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProdutoController{
	@FXML
	private TableView<Produto> tableProduto;
	@FXML
	private TableColumn<Produto, String> codigo;
	@FXML
	private TableColumn<Produto, String> nome;
	@FXML
	private TableColumn<Produto, String> tipo;
	@FXML
	private TableColumn<Produto, Float> preco;
	@FXML
	private TableColumn<Produto, Integer> estoque;
	

	public void preencherTabela() {
		ArrayList<Produto> produtoLista = FachadaControlador.getInstance().listarProduto();
		
		codigo.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));
		nome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		tipo.setCellValueFactory(new PropertyValueFactory<Produto, String>("tipo"));
		preco.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
		estoque.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("estoque"));
		
		tableProduto.setItems(FXCollections.observableArrayList(produtoLista));	
	}
	
	public void voltarMenu(){
		ScreenManager.getInstance().showMenu();
	}

}
