package br.ufrpe.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalGui extends Application{
	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	@Override
	public void start(Stage primaryStage){
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Pet42");
			this.primaryStage.setResizable(false);
			initRootLayout();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void initRootLayout() {
		try{	
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PrincipalGui.class.getResource("view/Login.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login");
			primaryStage.show();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
	}
	
	/**
	 * Telinha de cadastro de funcionario
	 * 
	 */
	private void initRootFuncionarioCadastro() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PrincipalGui.class.getResource("view/FuncionarioCadastrar.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Cadastro de Funcionario");
			primaryStage.show();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
