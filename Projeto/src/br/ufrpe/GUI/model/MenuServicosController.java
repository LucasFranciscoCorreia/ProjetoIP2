package br.ufrpe.GUI.model;

import java.util.ArrayList;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.FachadaControlador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuServicosController {
	@FXML
	private TableView<Servico> servicosTable;
	@FXML
	private TableColumn<Servico, String> nomeCol;
	@FXML
	private TableColumn<Servico, String> codigoCol;
	@FXML
	private TableColumn<Servico, Float> precoCol;
	@FXML
	private TextField nome, preco;
	@FXML
	private Label aviso;
	
	public void preencherTabela(){
		ArrayList<Servico> servicoListar = FachadaControlador.getInstance().listarServico();
		
		nomeCol.setCellValueFactory(new PropertyValueFactory<Servico, String>("nome"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Servico, Float>("preco"));
		codigoCol.setCellValueFactory(new PropertyValueFactory<Servico, String>("codigo"));
		
		servicosTable.setItems(FXCollections.observableArrayList(servicoListar));
	}
	
	@FXML
	public void adicionarServico(ActionEvent evt) throws ObjectNaoExisteException{
		if(nome.getText().isEmpty() || preco.getText().isEmpty()){
			aviso.setText("INFORME DADOS VÁLIDOS!!!");
		}else{
			Servico servico = new Servico(nome.getText(), Float.parseFloat(preco.getText()));
			
			try {
				FachadaControlador.getInstance().cadastrarServico(servico);
			} catch (ObjectJaExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	public void abrirServicoAdicionar(ActionEvent evt){
		ScreenManager.getInstance().showServicoAdicionar();
	}
	
	@FXML
	public void abrirServicoRemover(ActionEvent evt){
		ScreenManager.getInstance().showServicoRemover();
	}
	
	@FXML
	public void abrirServicoAtualizar(ActionEvent evt){
		ScreenManager.getInstance().showServicoAtualizar();
	}
	
	@FXML
	public void voltarMenuServicos(ActionEvent evt){
		ScreenManager.getInstance().showMenuServicos();
	}
	
	@FXML
	public void voltarMenu(ActionEvent evt){
		ScreenManager.getInstance().showMenu();
	}
}
