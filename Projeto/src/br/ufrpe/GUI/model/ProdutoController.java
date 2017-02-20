package br.ufrpe.GUI.model;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Acessorio;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Remedio;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.FachadaControlador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProdutoController{
	@FXML
	private Button buttonRemover, buttonAtualizar;
	@FXML
	private TextField nomeProduto, tipoProduto, preçoProduto, estoqueProduto, codigoProduto, codigoProdutoRemover;
	@FXML 
	private TextField nomeAnimal, precoAnimal, estoqueAnimal, especieAnimal, racaAnimal, pesoAnimal, tamanhoAnimal;
	@FXML 
	private TextField nomeRemedio, precoRemedio, estoqueRemedio, bulaRemedio, tarjaRemedio;
	@FXML 
	private TextField nomeAcessorio, precoAcessorio, estoqueAcessorio, corAcessorio, tamanhoAcessorio, validadeAcessorio;
	@FXML 
	private Label avisoCadastroAnimal, avisoCadastroAcessorio, avisoCadastroRemedio, avisoRemover, avisoAtualizar, aviso, produtoToString;	
	@FXML
	private TableView<Produto> tableProduto;
	@FXML
	private TableColumn<Produto, String> codigo;
	@FXML
	private TableColumn<Produto, String> nome;
	@FXML
	private TableColumn<Produto, String> tipo;
	@FXML
	private TableColumn<Produto, Float> preco;
	@FXML
	private TableColumn<Produto, Integer> estoque;
	

	public void preencherTabela() {
		ArrayList<Produto> produtoLista = FachadaControlador.getInstance().listarProduto();

			codigo.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));
			nome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
			tipo.setCellValueFactory(new PropertyValueFactory<Produto, String>("tipo"));
			preco.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
			estoque.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("estoque"));
			tableProduto.setPlaceholder(new Label("Nenhum registro encontrado."));
			tableProduto.setItems(FXCollections.observableArrayList(produtoLista));	
			
	}
	@FXML	
	public void voltarMenu(){
		ScreenManager.getInstance().showMenu();
	}
	
	@FXML
	public void abrirProdutoCadastrar(ActionEvent evento){
		ScreenManager.getInstance().showProdutoCadastrar();
	}
	@FXML
	public void abrirProdutoListar(ActionEvent evento){
		try{
			ProdutoController controlador = ScreenManager.getInstance().getProdutos().getController();
			controlador.preencherTabela();
			ScreenManager.getInstance().showProdutoListar();
		}
		catch(NullPointerException e){
			
		}
		
	}
	@FXML
	public void abrirProdutoRemover(ActionEvent evento){
		ScreenManager.getInstance().showProdutoRemover();
	}
	@FXML
	public void abrirProdutoAtualizar(ActionEvent evento){
		ScreenManager.getInstance().showProdutoAtualizar();
	}
	@FXML
	public void abrirProdutoPesquisar(ActionEvent evento){
		ScreenManager.getInstance().showProdutoPesquisar();
	}
	
	
	
	@FXML
	public void buttonPesquisarProduto(ActionEvent event){		
			
			try {	
				
				Produto encontrado = FachadaControlador.getInstance().pesquisar(codigoProduto.getText());
				
				if(encontrado instanceof Animal){
					produtoToString.setText(((Animal) encontrado).toStringP());		
				}
				else if(encontrado instanceof Acessorio){
					produtoToString.setText(((Acessorio) encontrado).toString());
				}
				
				else if(encontrado instanceof Remedio){
					produtoToString.setText(((Remedio) encontrado).toString());		
				}
				
				aviso.setText("Produto encontrado no sistema!!!");
				
			} catch (ObjectNaoExisteException | NullPointerException e) {
				aviso.setText(e.getMessage());
			    produtoToString.setText("");
				
				}
		
		
	}
	
	@FXML
	public void buttonPesquisarProdutoRemover(ActionEvent event){		
		
			try {		
				
				Produto encontrado = FachadaControlador.getInstance().pesquisar(codigoProdutoRemover.getText());
				
				if(encontrado instanceof Animal){
					produtoToString.setText(((Animal) encontrado).toStringP());		
				}
				else if(encontrado instanceof Acessorio){
					produtoToString.setText(((Acessorio) encontrado).toString());
				}
				
				else if(encontrado instanceof Remedio){
					produtoToString.setText(((Remedio) encontrado).toString());		
				}
				
					aviso.setText("Produto encontrado no sistema!!!");
					buttonRemover.setVisible(true);
				
				
			} catch (ObjectNaoExisteException | NullPointerException e) {
				aviso.setText(e.getMessage());
				produtoToString.setText("");
				buttonRemover.setVisible(false);
			}
			

		
	}
	
	@FXML
	public void buttonProdutoRemover(ActionEvent event) {
		
		try {
			
			FachadaControlador.getInstance().remover(codigoProdutoRemover.getText());
			FachadaControlador.getInstance().salvarNoArquivoProduto();
			
			avisoRemover.setText("Produto removido do sistema!!!");
			buttonRemover.setVisible(false);
		} catch (ObjectNaoExisteException | ErroAoRemoverException e) {
			avisoRemover.setText(e.getMessage());
		}			
		

		if(!codigoProdutoRemover.getText().isEmpty()){
			codigoProdutoRemover.setText("");
		}

		 
	}
	
	@FXML
	public void buttonCadastrarProdutoAnimal(ActionEvent event) throws ObjectNaoExisteException{
		
		int estoqueOk = 0;
		float preçoOk = 0;
		double  pesoOk = 0, tamanhoOk = 0;
		
		if(nomeAnimal.getText().isEmpty() || precoAnimal.getText().isEmpty()
				|| estoqueAnimal.getText().isEmpty() || especieAnimal.getText().isEmpty() ||
				pesoAnimal.getText().isEmpty() || tamanhoAnimal.getText().isEmpty() ||
				racaAnimal.getText().isEmpty()){
			avisoCadastroAnimal.setText("Dado Inválido!! Tente novamente");
		
		}else{	
			
			try{			
				estoqueOk = Integer.parseInt(estoqueAnimal.getText());
				preçoOk = Float.parseFloat(precoAnimal.getText());
				tamanhoOk = Double.parseDouble(tamanhoAnimal.getText());
				pesoOk =  Double.parseDouble(pesoAnimal.getText());
			}catch(NumberFormatException e){
				avisoCadastroAnimal.setText("Alguns campos devem ser escritos em numeros");
			}
				
			try {
	
				
					Produto novoProduto = new Animal(preçoOk, nomeAnimal.getText(), 
					"", estoqueOk, true, especieAnimal.getText(), racaAnimal.getText(),
					pesoOk, tamanhoOk);	

					FachadaControlador.getInstance().cadastrar(novoProduto);
					FachadaControlador.getInstance().salvarNoArquivoProduto();
							
				avisoCadastroAnimal.setText("Produto cadastrado com sucesso!!");
			 
			} catch (ErroAoSalvarException | ObjectJaExisteException | NullPointerException f) {
				avisoCadastroAnimal.setText(f.getMessage());
			} 
		}
	

		if(!nomeAnimal.getText().isEmpty() || !precoAnimal.getText().isEmpty()
				|| !estoqueAnimal.getText().isEmpty() || !especieAnimal.getText().isEmpty() ||
				!pesoAnimal.getText().isEmpty() || !tamanhoAnimal.getText().isEmpty() ||
				!racaAnimal.getText().isEmpty()){
			
			nomeAnimal.setText("");
			precoAnimal.setText("");
			estoqueAnimal.setText("");
			especieAnimal.setText("");
			pesoAnimal.setText("");
			tamanhoAnimal.setText("");
			racaAnimal.setText("");
			
		} 
	
	}
		
	@FXML
	public void buttonCadastrarProdutoRemedio(ActionEvent event) throws ObjectNaoExisteException{
		
		int estoqueOk = 0;
		float preçoOk = 0;
		
		
		if(nomeRemedio.getText().isEmpty() || precoRemedio.getText().isEmpty()
				|| estoqueRemedio.getText().isEmpty() || tarjaRemedio.getText().isEmpty()){
			avisoCadastroRemedio.setText("Dado Inválido!! Tente novamente");
		
		}else{	
		
			try{			
				estoqueOk = Integer.parseInt(estoqueRemedio.getText());
				preçoOk = Float.parseFloat(precoRemedio.getText());
					
			}catch(NumberFormatException e){
				avisoCadastroAnimal.setText("Alguns campos devem ser escritos em numeros");
			}
				
			try {
	
				
					Produto novoProduto = new Remedio(preçoOk, nomeRemedio.getText(), 
					"", estoqueOk, tarjaRemedio.getText());	

					FachadaControlador.getInstance().cadastrar(novoProduto);
					FachadaControlador.getInstance().salvarNoArquivoProduto();
							
				avisoCadastroRemedio.setText("Produto cadastrado com sucesso!!");
			 
			} catch (ErroAoSalvarException | ObjectJaExisteException | NullPointerException f) {
				avisoCadastroRemedio.setText(f.getMessage());
			} 
		}
	

		if(nomeRemedio.getText().isEmpty() || precoRemedio.getText().isEmpty()
				|| estoqueRemedio.getText().isEmpty() || tarjaRemedio.getText().isEmpty()){
			avisoCadastroRemedio.setText("Dado Inválido!! Tente novamente");
			
			nomeRemedio.setText("");
			precoRemedio.setText("");
			estoqueRemedio.setText("");
			tarjaRemedio.setText("");	
		}
				
	}
	
	@FXML
	public void buttonCadastrarProdutoAcessorio(ActionEvent event) throws ObjectNaoExisteException{
		
		int estoqueOk = 0;
		float preçoOk = 0;
		double tamanhoOk = 0;
		
		if(nomeAcessorio.getText().isEmpty() || precoAcessorio.getText().isEmpty()
				|| estoqueAcessorio.getText().isEmpty() || tamanhoAcessorio.getText().isEmpty() ||
				corAcessorio.getText().isEmpty()){
			avisoCadastroAcessorio.setText("Dado Inválido!! Tente novamente");
		
		}else{	
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate validade;
			if(!validadeAcessorio.getText().isEmpty()){
				
				validade = LocalDate.parse(this.validadeAcessorio.getText(), formatter);
			}
			else{
				validade = null;
			}
			
			
			try{			
				estoqueOk = Integer.parseInt(estoqueAcessorio.getText());
				preçoOk = Float.parseFloat(precoAcessorio.getText());
				tamanhoOk = Double.parseDouble(tamanhoAcessorio.getText());
				
				
			}catch(NumberFormatException e){
				avisoCadastroAnimal.setText("Alguns campos devem ser escritos em numeros");
			}
				
			try {
			
					Produto novoProduto = new Acessorio(preçoOk, nomeAcessorio.getText(), 
					"", estoqueOk, corAcessorio.getText(), tamanhoOk, validade);	

					FachadaControlador.getInstance().cadastrar(novoProduto);
					FachadaControlador.getInstance().salvarNoArquivoProduto();
							
				avisoCadastroAcessorio.setText("Produto cadastrado com sucesso!!");
			 
			} catch (ErroAoSalvarException | ObjectJaExisteException | NullPointerException f) {
				avisoCadastroAcessorio.setText(f.getMessage());
			} 
		}
	

		if(!nomeAcessorio.getText().isEmpty() || !precoAcessorio.getText().isEmpty()
				|| !estoqueAcessorio.getText().isEmpty() || !tamanhoAcessorio.getText().isEmpty() ||
				!corAcessorio.getText().isEmpty() || !validadeAcessorio.getText().isEmpty()){
			
			nomeAcessorio.setText("");
			precoAcessorio.setText("");
			estoqueAcessorio.setText("");
			tamanhoAcessorio.setText("");
			corAcessorio.setText("");
			validadeAcessorio.setText("");
		
		}
				
	}
		
}
