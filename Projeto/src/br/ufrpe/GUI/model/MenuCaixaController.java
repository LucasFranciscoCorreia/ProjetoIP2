package br.ufrpe.GUI.model;

import br.ufrpe.GUI.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class MenuCaixaController {
	
	@FXML
	public void menuCaixa(ActionEvent evt){
		ScreenManager.getInstance().showMenuCaixa();
	}
	
	@FXML
	public void abrirTelaCaixa(ActionEvent evt){
		ScreenManager.getInstance().showTelaCaixa();
	}
	
	@FXML
	public void abrirClienteMenuCaixa(ActionEvent evt){
		ScreenManager.getInstance().showClienteMenuCaixa();
		ClienteController controlador = ScreenManager.getInstance().getClientesCaixa().getController();
		controlador.preencherTabela();
	}
	
	@FXML
	public void abrirPetCareMenu(ActionEvent evt){
		ScreenManager.getInstance().showPetCareMenu();
		PetCareController controlador = ScreenManager.getInstance().getServicos().getController();
		controlador.preencherTabela();
	}
	@FXML
	public void voltarLogin(ActionEvent evt){
		ScreenManager.getInstance().showLogin();
	}
}
