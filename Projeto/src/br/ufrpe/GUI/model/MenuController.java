package br.ufrpe.GUI.model;

import br.ufrpe.GUI.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {

	@FXML
	public void abrirMenuServicos(ActionEvent evt){
		ScreenManager.getInstance().showMenuServicos();
		MenuServicosController controlador = ScreenManager.getInstance().getMenuServicos().getController();
		controlador.preencherTabela();
	}
	@FXML
	public void abrirFuncionarioListar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioListar();
		FuncionarioController controlador = ScreenManager.getInstance().getFuncionarios().getController();
		controlador.preencherTabela();
	}
	
	@FXML
	public void abrirProdutoListar(ActionEvent evento){
		ScreenManager.getInstance().showProdutoListar();
		ProdutoController controlador = ScreenManager.getInstance().getProdutos().getController();
		controlador.preencherTabela();
	}
	
	@FXML
	public void abrirClienteListar(ActionEvent evento){
		ScreenManager.getInstance().showClienteListar();
		ClienteController controlador = ScreenManager.getInstance().getClientes().getController();
		controlador.preencherTabela();
	}
	
	@FXML
	public void voltarLogin(ActionEvent evt){
		
		ScreenManager.getInstance().showLogin();
	}
}
