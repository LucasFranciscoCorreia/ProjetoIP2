package br.ufrpe.GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScreenManager {
	private static ScreenManager unicInstanc;
	private Stage mainStage;
	
	private Scene clienteAtualizar, clienteCadastrar, clienteListar, clientePesquisar, clienteRemover;
	private Scene funcionarioAtualizar, funcionarioCadastrar, funcionarioListar, funcionarioPesquisar, funcionarioRemover;
	private Scene login, menu, menuCaixa, menuCliente, errorMessage, menuFuncionario;
	private Scene produtoAtualizar, produtoCadastrar, produtoListar, produtoPesquisar, produtoRemover; 
	
	public static ScreenManager getInstance(){
		if(unicInstanc == null){
			unicInstanc = new ScreenManager();
		}
		
		return unicInstanc;
	}

	private ScreenManager(){
		try {
			// CLIENTE TELAS:
//			AnchorPane clienteAtualizar = FXMLLoader.load(getClass().getResource(
//		              "view/ClienteRemover.fxml"));
//			this.clienteAtualizar = new Scene(clienteAtualizar);
			
			AnchorPane clienteCadastrar = FXMLLoader.load(getClass().getResource(
		              "view/ClienteCadastrar.fxml"));
			this.clienteCadastrar = new Scene(clienteCadastrar);
			
//			AnchorPane clienteListar = FXMLLoader.load(getClass().getResource(
//		              "view/ClienteListar.fxml"));
//			this.clienteListar = new Scene(clienteListar);
//			
//			AnchorPane clientePesquisar = FXMLLoader.load(getClass().getResource(
//		              "view/ClientePesquisar.fxml"));
//			this.clientePesquisar = new Scene(clientePesquisar);
//			
//			AnchorPane clienteRemover = FXMLLoader.load(getClass().getResource(
//		              "view/ClienteRemover.fxml"));
//			this.clienteRemover = new Scene(clienteRemover);
			
			
			
			// FUNCIONARIO TELAS:
			AnchorPane funcionarioAtualizar = FXMLLoader.load(getClass().getResource(
		              "view/FuncionarioAtualizar.fxml"));
			this.funcionarioAtualizar = new Scene(funcionarioAtualizar);
			
			StackPane funcionarioCadastar =  FXMLLoader.load(getClass().getResource(
		              "view/FuncionarioCadastrar.fxml"));
			this.funcionarioCadastrar = new Scene(funcionarioCadastar);
			
			AnchorPane funcionarioListar = FXMLLoader.load(getClass().getResource(
		              "view/FuncionarioListar.fxml"));
			this.funcionarioListar = new Scene(funcionarioListar);
			
			AnchorPane funcionarioPesquisar = FXMLLoader.load(getClass().getResource(
		              "view/FuncionarioPesquisar.fxml"));
			this.funcionarioPesquisar = new Scene(funcionarioPesquisar);
			
			AnchorPane funcionarioRemover = FXMLLoader.load(getClass().getResource(
		              "view/FuncionarioRemover.fxml"));
			this.funcionarioRemover = new Scene(funcionarioRemover);
			
			
			
			// OUTRAS TELAS:
//			Pane errorMessage = FXMLLoader.load(getClass().getResource(
//		              "view/ErrorMessage.fxml"));
//			this.errorMessage = new Scene(errorMessage);
			
			AnchorPane login = FXMLLoader.load(getClass().getResource(
		              "view/Login.fxml"));
			this.login = new Scene(login);
			
			// MENU TELAS:
			AnchorPane menu = FXMLLoader.load(getClass().getResource(
		              "view/Menu.fxml"));
			this.menu = new Scene(menu);
			
			AnchorPane menuCaixa = FXMLLoader.load(getClass().getResource(
		              "view/MenuCaixa.fxml"));
			this.menuCaixa = new Scene(menuCaixa);
			
			BorderPane menuCliente = FXMLLoader.load(getClass().getResource(
		              "view/MenuCliente.fxml"));
			this.menuCliente = new Scene(menuCliente);
			
			AnchorPane menuFuncionario = FXMLLoader.load(getClass().getResource(
		              "view/MenuFuncionario.fxml"));
			this.menuFuncionario = new Scene(menuFuncionario);
			
			
			
			// PRODUTO TELAS:
//			AnchorPane produtoAtualizar = FXMLLoader.load(getClass().getResource(
//		              "view/ProdutoAtualizar.fxml"));
//			this.produtoAtualizar = new Scene(produtoAtualizar);
//			
//			AnchorPane produtoCadastrar = FXMLLoader.load(getClass().getResource(
//		              "view/ProdutoCadastrar.fxml"));
//			this.produtoCadastrar = new Scene(produtoCadastrar);
//			
//			AnchorPane produtoListar = FXMLLoader.load(getClass().getResource(
//		              "view/ProdutoListar.fxml"));
//			this.produtoListar = new Scene(produtoListar);
//			
//			AnchorPane produtoPesquisar = FXMLLoader.load(getClass().getResource(
//		              "view/ProdutoPesquisar.fxml"));
//			this.produtoPesquisar = new Scene(produtoPesquisar);
//			
//			AnchorPane produtoRemover = FXMLLoader.load(getClass().getResource(
//		              "view/ProdutoRemover.fxml"));
//			this.produtoRemover = new Scene(produtoRemover);
			
			
			
			// ANIMAL TELAS:
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Stage getMainStage(){
		return mainStage;
	}
	
	public void setMainStage(Stage mainStage){
		this.mainStage = mainStage;
		mainStage.setWidth(800);
		mainStage.setHeight(600);
		mainStage.setTitle("PET SHOP GROUP 42");
	}
	
	// CHAMADA DE TELAS CLIENTE:
	public void showClienteAtualizar(){
		this.mainStage.setScene(this.clienteAtualizar);
	}
	
	public void showClienteCadastrar(){
		this.mainStage.setScene(this.clienteCadastrar);
	}
	
	public void showClienteListar(){
		this.mainStage.setScene(this.clienteListar);
	}
	
	public void showClientePesquisar(){
		this.mainStage.setScene(this.clientePesquisar);
	}
	
	public void showClienteRemover(){
		this.mainStage.setScene(this.clienteRemover);
	}
	
	
	// CHAMADA DA TELA DE ERRO:
	public void showErrorMessage(){
		this.mainStage.setScene(this.errorMessage);
	}
	private static Stage loginStage;
	// CHAMADA DA TELA DE MENU:
	public void showMenu(){
		loginStage.close();
		this.mainStage.setScene(this.menu);
		this.mainStage.centerOnScreen();
		this.mainStage.setWidth(800);
		this.mainStage.setHeight(626);
		this.mainStage.show();
	}
	
	public void showMenuCaixa(){
		this.mainStage.setScene(this.menuCaixa);
		this.mainStage.centerOnScreen();
		this.mainStage.setWidth(800);
		this.mainStage.setHeight(626);
		this.mainStage.show();
	}
	
	public void showMenuCliente(){
		this.mainStage.setScene(this.menuCliente);
	}
	
	public void showMenuFuncionario(){
		this.mainStage.setScene(this.menuFuncionario);
	}
	
	
	// CHAMADA DA TELA DE LOGIN:
	public void showLogin(){
		loginStage = new Stage();
		loginStage.setScene(this.login);
		loginStage.setWidth(350);
		loginStage.setHeight(275);
		loginStage.setResizable(false);
		loginStage.show();
	}
	
	
	// CHAMADA DA TELA DE FUNCIONARIO:
	public void showFuncionarioAtualizar(){
		this.mainStage.setScene(this.funcionarioAtualizar);
	}
	
	public void showFuncionarioCadastrar(){
		this.mainStage.setScene(this.funcionarioCadastrar);
	}
	
	public void showFuncionarioListar(){
		this.mainStage.setScene(this.funcionarioListar);
	}
	
	public void showFuncionarioPesquisar(){
		this.mainStage.setScene(this.funcionarioPesquisar);
	}
	
	public void showFuncionarioRemover(){
		this.mainStage.setScene(this.funcionarioRemover);
	}
	
	
	// CHAMADA DA TELA PRODUTO: 
	public void showProdutoAtualizar(){
		this.mainStage.setScene(this.produtoAtualizar);
	}
	
	public void showProdutoCadastrar(){
		this.mainStage.setScene(this.produtoCadastrar);
	}
	
	public void showProdutoListar(){
		this.mainStage.setScene(this.produtoListar);
	}
	
	public void showProdutoPesquisar(){
		this.mainStage.setScene(this.produtoPesquisar);
	}
	
	public void showProdutoRemover(){
		this.mainStage.setScene(this.produtoRemover);
	}
}
