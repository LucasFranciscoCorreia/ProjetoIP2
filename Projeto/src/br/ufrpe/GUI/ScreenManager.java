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
	
	private FXMLLoader funcionarios, produtos, clientes, clientesCaixa, servicos, menuServicos, servicoAndamentos, servicoConcluidos;
	
	private Scene clienteAtualizar, clienteCadastrar, clienteListar, clientePesquisar, clienteRemover;
	private Scene funcionarioAtualizar, funcionarioCadastrar, funcionarioListar, funcionarioPesquisar, funcionarioRemover;
	private Scene login, menu, menuCaixa, errorMessage, telaCaixa, clienteMenuCaixa, menuServico, petCareMenu;
	private Scene realizarServico, servicoAdicionar, servicoRemover, servicoAtualizar, servicoConcluido, servicoAndamento, finalizarServico;
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
	
			AnchorPane clienteAtualizar = FXMLLoader.load(getClass().getResource(
		              "view/ClienteAtualizar.fxml"));
			this.clienteAtualizar = new Scene(clienteAtualizar);
			
			StackPane clienteCadastrar = FXMLLoader.load(getClass().getResource(
		              "view/ClienteCadastrar.fxml"));
			this.clienteCadastrar = new Scene(clienteCadastrar);
				
			clientes = new FXMLLoader(this.getClass().getResource("view/ClienteListar.fxml"));
			AnchorPane clienteListar = clientes.load();
			this.clienteListar = new Scene(clienteListar);
			
			AnchorPane clientePesquisar = FXMLLoader.load(getClass().getResource(
		              "view/ClientePesquisar.fxml"));
			this.clientePesquisar = new Scene(clientePesquisar);
			
			AnchorPane clienteRemover = FXMLLoader.load(getClass().getResource(
		              "view/ClienteRemover.fxml"));
			this.clienteRemover = new Scene(clienteRemover);
			
			clientesCaixa = new FXMLLoader(this.getClass().getResource("view/ClienteMenuCaixa.fxml"));
			AnchorPane clienteMenuCaixa = clientesCaixa.load();
			this.clienteMenuCaixa = new Scene(clienteMenuCaixa);	
			
			
			// FUNCIONARIO TELAS:
			AnchorPane funcionarioAtualizar = FXMLLoader.load(getClass().getResource(
		              "view/FuncionarioAtualizar.fxml"));
			this.funcionarioAtualizar = new Scene(funcionarioAtualizar);
			
			StackPane funcionarioCadastar =  FXMLLoader.load(getClass().getResource(
		              "view/FuncionarioCadastrar.fxml"));
			this.funcionarioCadastrar = new Scene(funcionarioCadastar);
			
			funcionarios = new FXMLLoader(this.getClass().getResource(
					"view/FuncionarioListar.fxml"));
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
			
			menuServicos = new FXMLLoader(this.getClass().getResource(
					"view/MenuServicos.fxml"));
			AnchorPane menuServico = menuServicos.load();
			this.menuServico = new Scene(menuServico);
			
			servicos = new FXMLLoader(this.getClass().getResource(
					"view/PetCareMenu.fxml"));
			AnchorPane petCareMenu = servicos.load();
			this.petCareMenu = new Scene(petCareMenu);
			
			AnchorPane telaCaixa = FXMLLoader.load(getClass().getResource(
		              "view/TelaCaixa.fxml"));
			this.telaCaixa = new Scene(telaCaixa);
			
			
			
			// PRODUTO TELAS:
			AnchorPane produtoAtualizar = FXMLLoader.load(getClass().getResource(
		              "view/ProdutoAtualizar.fxml"));
			this.produtoAtualizar = new Scene(produtoAtualizar);
			
			AnchorPane produtoCadastrar = FXMLLoader.load(getClass().getResource(
		              "view/ProdutoCadastrar.fxml"));
  		    this.produtoCadastrar = new Scene(produtoCadastrar);
			
			produtos = new FXMLLoader(this.getClass().getResource(
					"view/ProdutoListar.fxml"));
			AnchorPane produtoListar = produtos.load();
			this.produtoListar = new Scene(produtoListar);
			
			AnchorPane produtoPesquisar = FXMLLoader.load(getClass().getResource(
		              "view/ProdutoPesquisar.fxml"));
			this.produtoPesquisar = new Scene(produtoPesquisar);
			
			AnchorPane produtoRemover = FXMLLoader.load(getClass().getResource(
		              "view/ProdutoRemover.fxml"));
			this.produtoRemover = new Scene(produtoRemover);
			
			
			// TELAS SERVIÇOS:
			AnchorPane realizarServico = FXMLLoader.load(getClass().getResource(
		              "view/RealizarServico.fxml"));
			this.realizarServico = new Scene(realizarServico);
			
			AnchorPane servicoAdicionar = FXMLLoader.load(getClass().getResource(
		              "view/ServicoAdicionar.fxml"));
			this.servicoAdicionar = new Scene(servicoAdicionar);
			
			AnchorPane servicoRemover = FXMLLoader.load(getClass().getResource(
		              "view/ServicoRemover.fxml"));
			this.servicoRemover = new Scene(servicoRemover);
			
			AnchorPane servicoAtualizar = FXMLLoader.load(getClass().getResource(
		              "view/ServicoAtualizar.fxml"));
			this.servicoAtualizar = new Scene(servicoAtualizar);
			
			servicoConcluidos = new FXMLLoader(this.getClass().getResource(
					"view/ServicoConcluido.fxml"));
			AnchorPane servicoConcluido = servicoConcluidos.load();
			this.servicoConcluido = new Scene(servicoConcluido);
			
			servicoAndamentos = new FXMLLoader(this.getClass().getResource(
					"view/ServicoAndamento.fxml"));
			AnchorPane servicoAndamento = servicoAndamentos.load();
			this.servicoAndamento = new Scene(servicoAndamento);
			
			AnchorPane finalizarServico = FXMLLoader.load(getClass().getResource(
		              "view/FinalizarServico.fxml"));
			this.finalizarServico = new Scene(finalizarServico);
						
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
	
	public void showClienteMenuCaixa(){
		this.mainStage.setScene(this.clienteMenuCaixa);
	}
	
	// CHAMADA DA TELA DE ERRO:
	public void showErrorMessage(){
		this.mainStage.setScene(this.errorMessage);
	}
	private static Stage loginStage;
	// CHAMADA DA TELA DE MENU:
	
	public void showPetCareMenu(){
		this.mainStage.setScene(this.petCareMenu);
	}
	
	public void showMenuServicos(){
		this.mainStage.setScene(this.menuServico);
	}
	public void showTelaCaixa(){
		this.mainStage.setScene(this.telaCaixa);
	}
	
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
		if(mainStage.isShowing()){
			mainStage.close();
		}
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
	
	public void showRealizarServico(){
		this.mainStage.setScene(this.realizarServico);
	}
	
	public void showServicoAdicionar(){
		this.mainStage.setScene(this.servicoAdicionar);
	}
	
	public void showServicoRemover(){
		this.mainStage.setScene(this.servicoRemover);
	}
	
	public void showServicoAtualizar(){
		this.mainStage.setScene(this.servicoAtualizar);
	}
	
	public void showServicoConcluido(){
		this.mainStage.setScene(this.servicoConcluido);
	}
	
	public void showServicoAndamento(){
		this.mainStage.setScene(this.servicoAndamento);
	}
	
	public void showFinalizarServico(){
		this.mainStage.setScene(finalizarServico);
	}
	
	// TABELAS
	public FXMLLoader getFuncionarios() {
		return this.funcionarios;
	}
	
	public FXMLLoader getProdutos() {
		return this.produtos;
	}
	
	public FXMLLoader getClientes(){
		return this.clientes;
	}
	
	public FXMLLoader getClientesCaixa(){
		return this.clientesCaixa;
	}
	
	public FXMLLoader getServicos(){
		return this.servicos;
	}
	
	public FXMLLoader getMenuServicos(){
		return this.menuServicos;
	}
	
	public FXMLLoader getServicoAndamentos(){
		return this.servicoAndamentos;
	}
	
	public FXMLLoader getServicoConcluidos(){
		return this.servicoConcluidos;
	}

}
