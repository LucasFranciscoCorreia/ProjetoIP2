package br.ufrpe.GUI.model;

import br.ufrpe.GUI.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {

	@FXML
	public void abrirFuncionarioListar(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioListar();
		FuncionarioController controlador = ScreenManager.getInstance().getF().getController();
		controlador.preencherTabela();
	}
	
	@FXML
	public void abrirClienteListar(ActionEvent evento){
		ScreenManager.getInstance().showClienteListar();
	}
	
	@FXML
	private void inicialize(){
		
	}
}
