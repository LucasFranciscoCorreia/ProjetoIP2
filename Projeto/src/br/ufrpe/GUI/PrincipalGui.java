package br.ufrpe.GUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.ufrpe.GUI.model.FuncionarioController;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.negocios.FachadaControlador;
import javafx.application.Application;
import javafx.stage.Stage;

public class PrincipalGui extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		ScreenManager.getInstance().setMainStage(primaryStage);
		ScreenManager.getInstance().showLogin();
	}
	public static void main(String[] args) {
		launch(args);
	} 
}