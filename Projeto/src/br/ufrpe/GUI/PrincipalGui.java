package br.ufrpe.GUI;

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