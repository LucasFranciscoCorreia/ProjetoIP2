package br.ufrpe.GUI.model;

import java.util.ArrayList;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
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
import javafx.scene.layout.AnchorPane;

public class MenuServicosController {
	@FXML
	private TableView<Produto> servicosTable;
	@FXML
	private TableColumn<Produto, String> nomeCol;
	@FXML
	private TableColumn<Produto, String> codigoCol;
	@FXML
	private TableColumn<Produto, Float> precoCol;
	@FXML
	private TextField nome, preco, codigo;
	@FXML
	private Label aviso, servicoToString;
	@FXML
	private Button buttonRemover;
	@FXML
	private AnchorPane pesquisarScene, atualizarScene;
	
	
	public void preencherTabela(){
		ArrayList<Produto> servicoListar = FachadaControlador.getInstance().listarServico();
		
		nomeCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
		codigoCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));
		
		servicosTable.setItems(FXCollections.observableArrayList(servicoListar));
		servicosTable.refresh();
	}
	
	@FXML
	public void adicionarServico(ActionEvent evt) throws ObjectNaoExisteException{
		if(!aviso.getText().isEmpty()){
			aviso.setText("");
		}
		
		if(nome.getText().isEmpty() || preco.getText().isEmpty()){
			aviso.setText("INFORME DADOS VÁLIDOS!!!");
		}else{
			Servico servico = new Servico(nome.getText(), Float.parseFloat(preco.getText()));
			
			try {
				FachadaControlador.getInstance().cadastrarServico(servico);
				FachadaControlador.getInstance().salvarNoArquivoServico();
				aviso.setText("Serviço adiciona com sucesso!!!");
			} catch (ObjectJaExisteException | ErroAoSalvarException e) {
				aviso.setText(e.getMessage());
			}
		}
		
		nome.setText("");
		preco.setText("");
	}
	
	@FXML
	public void pesquisarServico(ActionEvent evt){
		if(!servicoToString.getText().isEmpty() | !aviso.getText().isEmpty()){
			servicoToString.setText("");
			aviso.setText("");
		}
		
		if(codigo.getText().isEmpty()){
			servicoToString.setText("INFORME UM CÓDIGO VÁLIDO!!!");
		}else{
			try {
				Servico achado = null;
				achado = FachadaControlador.getInstance().buscarServico(codigo.getText());
				servicoToString.setText(achado.toString());
				buttonRemover.setVisible(true);
			} catch (ObjectNaoExisteException e) {
				servicoToString.setText(e.getMessage());
			}
		}
	}
	
	@FXML
	public void removerServico(ActionEvent evt){
		if(!aviso.getText().isEmpty() || !servicoToString.getText().isEmpty()){
			aviso.setText("");
			servicoToString.setText("");
		}
		
		try {
			FachadaControlador.getInstance().removerServicoNome(codigo.getText());
			FachadaControlador.getInstance().salvarNoArquivoServico();
			aviso.setText("SERVICO REMOVIDO COM SUCESSO!!!");
			buttonRemover.setVisible(false);
		} catch (ObjectNaoExisteException e) {
			aviso.setText(e.getMessage());
		}
		
		codigo.setText("");
	}
	
	@FXML
	public void pesquisarServicoAtualizar(ActionEvent evt){
		if(!servicoToString.getText().isEmpty()){
			servicoToString.setText("");
		}
		
		if(codigo.getText().isEmpty()){
			servicoToString.setText("INFORME UM CÓDIGO VÁLIDO!!!");
		}else{
			try {
				Servico achado = null;
				achado = FachadaControlador.getInstance().buscarServico(codigo.getText());
				servicoToString.setText(achado.toString());
				atualizarScene.setVisible(true);
			} catch (ObjectNaoExisteException e) {
				servicoToString.setText(e.getMessage());
			}
		}
	}
	
	@FXML
	public void atualizarServico(ActionEvent evt){
		if(!aviso.getText().isEmpty()){
			aviso.setText("");
		}
		
		if(nome.getText().isEmpty() && preco.getText().isEmpty()){
			aviso.setText("INFORME DADOS VÁLIDOS!!!");						
		}else{
			try {
				Servico antigo = FachadaControlador.getInstance().buscarServico(codigo.getText());
				Servico novo;
				if(nome.getText().isEmpty()){
					novo = new Servico(antigo.getNome(), Float.parseFloat(preco.getText()));
				}else{
					novo = new Servico(nome.getText(), Float.parseFloat(preco.getText()));					
				}
				
				FachadaControlador.getInstance().atualizarServico(antigo, novo);
				FachadaControlador.getInstance().salvarNoArquivoServico();
				atualizarScene.setVisible(false);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		codigo.setText("");
		nome.setText("");
		preco.setText("");
		aviso.setText("");
		servicoToString.setText("");
		
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
		MenuServicosController controlador = ScreenManager.getInstance().getMenuServicos().getController();
		controlador.preencherTabela();
	}
	
	@FXML
	public void voltarMenu(ActionEvent evt){
		ScreenManager.getInstance().showMenu();
	}
}
