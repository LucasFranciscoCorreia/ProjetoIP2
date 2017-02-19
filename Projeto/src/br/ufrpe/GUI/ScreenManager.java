package br.ufrpe.GUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScreenManager {
	private static ScreenManager unicInstanc;
	private Stage mainStage;
	
	private FXMLLoader funcionarios, produtos;
	
	private Scene clienteAtualizar, clienteCadastrar, clienteListar, clientePesquisar, clienteRemover;
	private Scene funcionarioAtualizar, funcionarioCadastrar, funcionarioListar, funcionarioPesquisar, funcionarioRemover;
	private Scene login, menu, menuCaixa, errorMessage, telaCaixa;
	private Scene animalAtualizar, animalCadastrar, animalListar, animalPesquisar, animalRemover;
	private Scene produtoAtualizar, produtoCadastrar, produtoListar, produtoPesquisar, produtoRemover; 
	private Scene clienteCadastrarCaixa, clientePesquisarCaixa, clienteAtualizarCaixa;
	
	public static ScreenManager getInstance(){
		if(unicInstanc == null){
			unicInstanc = new ScreenManager();
		}
		
		return unicInstanc;
	}

	private ScreenManager(){
		try {
			// CLIENTE TELAS:
			AnchorPane clienteCadastrarCaixa = FXMLLoader.load(getClass().getResource(
		              "view/ClienteCadastrarCaixa.fxml"));
			this.clienteCadastrarCaixa = new Scene(clienteCadastrarCaixa);
			
			AnchorPane clientePesquisarCaixa = FXMLLoader.load(getClass().getResource(
		              "view/ClientePesquisarCaixa.fxml"));
			this.clientePesquisarCaixa = new Scene(clientePesquisarCaixa);
			
			AnchorPane clienteAtualizarCaixa = FXMLLoader.load(getClass().getResource(
		              "view/ClienteAtualizarCaixa.fxml"));
			this.clienteAtualizarCaixa = new Scene(clienteAtualizarCaixa);
	
//			AnchorPane clienteAtualizar = FXMLLoader.load(getClass().getResource(
//		              "view/ClienteAtualizar.fxml"));
//			this.clienteAtualizar = new Scene(clienteAtualizar);
			
			StackPane clienteCadastrar = FXMLLoader.load(getClass().getResource(
		              "view/ClienteCadastrar.fxml"));
			this.clienteCadastrar = new Scene(clienteCadastrar);
					
			AnchorPane clienteListar = FXMLLoader.load(getClass().getResource(
		              "view/ClienteListar.fxml"));
			this.clienteListar = new Scene(clienteListar);
			
			AnchorPane clientePesquisar = FXMLLoader.load(getClass().getResource(
		              "view/ClientePesquisar.fxml"));
			this.clientePesquisar = new Scene(clientePesquisar);
			
			AnchorPane clienteRemover = FXMLLoader.load(getClass().getResource(
		              "view/ClienteRemover.fxml"));
			this.clienteRemover = new Scene(clienteRemover);
			
			
			
			// FUNCIONARIO TELAS:
			AnchorPane funcionarioAtualizar = FXMLLoader.load(getClass().getResource(
		              "view/FuncionarioAtualizar.fxml"));
			this.funcionarioAtualizar = new Scene(funcionarioAtualizar);
			
			StackPane funcionarioCadastar =  FXMLLoader.load(getClass().getResource(
		              "view/FuncionarioCadastrar.fxml"));
			this.funcionarioCadastrar = new Scene(funcionarioCadastar);
			
			funcionarios = new FXMLLoader(this.getClass().getResource("view/FuncionarioListar.fxml"));
			AnchorPane funcionarioListar = funcionarios.load();
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
			
//			AnchorPane telaCaixa = FXMLLoader.load(getClass().getResource(
//		              "view/TelaCaixa.fxml"));
//			this.telaCaixa = new Scene(telaCaixa);
			
			
			
			// PRODUTO TELAS:
//			AnchorPane produtoAtualizar = FXMLLoader.load(getClass().getResource(
//		              "view/ProdutoAtualizar.fxml"));
//			this.produtoAtualizar = new Scene(produtoAtualizar);
//			
			AnchorPane produtoCadastrar = FXMLLoader.load(getClass().getResource(
		              "view/ProdutoCadastrar.fxml"));
  		    this.produtoCadastrar = new Scene(produtoCadastrar);
			
			produtos = new FXMLLoader(this.getClass().getResource("view/ProdutoListar.fxml"));
			AnchorPane produtoListar = produtos.load();
			this.produtoListar = new Scene(produtoListar);
			
			AnchorPane produtoPesquisar = FXMLLoader.load(getClass().getResource(
		              "view/ProdutoPesquisar.fxml"));
			this.produtoPesquisar = new Scene(produtoPesquisar);
			
			AnchorPane produtoRemover = FXMLLoader.load(getClass().getResource(
		              "view/ProdutoRemover.fxml"));
			this.produtoRemover = new Scene(produtoRemover);
			
			
			
			// ANIMAL TELAS:
//			AnchorPane  animalCadastrar = FXMLLoader.load(getClass().getResource(
//		              "view/AnimalCadastrar.fxml"));
//			this.animalCadastrar = new Scene(animalCadastrar);
//			
//			AnchorPane  animalRemover = FXMLLoader.load(getClass().getResource(
//		              "view/AnimalRemover.fxml"));
//			this.animalRemover = new Scene(animalRemover);
			
			
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
	public void showClienteAtualizarCaixa(){
		this.mainStage.setScene(clienteAtualizarCaixa);
	}
	public void showClienteCadastrarCaixa(){
		this.mainStage.setScene(clienteCadastrarCaixa);
	}
	
	public void showClientePesquisarCaixa(){
		this.mainStage.setScene(clientePesquisarCaixa);
	}
	
	public void showClienteAtualizar(){
		this.mainStage.setScene(this.clienteAtualizar);
	}
	
	public void showClienteCadastrar(){
		this.mainStage.setScene(this.clienteCadastrar);
	}
	
	public void showClientePesquisar(){
		this.mainStage.setScene(this.clientePesquisar);
	}
	
	public void showClienteRemover(){
		this.mainStage.setScene(this.clienteRemover);
	}
	
	public void showClienteListar(){
		this.mainStage.setScene(this.clienteListar);
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
		mainStage.setResizable(false);
		this.mainStage.show();
	}
	
	public void showMenuCaixa(){
		loginStage.close();
		this.mainStage.setScene(this.menuCaixa);
		this.mainStage.centerOnScreen();
		this.mainStage.setWidth(800);
		this.mainStage.setHeight(626);
		this.mainStage.show();
	}
	
	public void showMenuCliente(){
		this.mainStage.setScene(this.clienteListar);
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
	
	public FXMLLoader getFuncionarios() {
		return this.funcionarios;
	}
	
	public FXMLLoader getProdutos() {
		return this.produtos;
	}
}
