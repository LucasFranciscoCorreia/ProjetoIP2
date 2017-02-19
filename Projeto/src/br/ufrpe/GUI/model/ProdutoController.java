package br.ufrpe.GUI.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import br.ufrpe.GUI.ScreenManager;
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
	private TextField nomeProduto, tipoProduto, preçoProduto, estoqueProduto, codigoProduto;
	@FXML 
	private TextField nomeAnimal, precoAnimal, estoqueAnimal, especieAnimal, racaAnimal, pesoAnimal, tamanhoAnimal;
	@FXML 
	private TextField nomeRemedio, precoRemedio, estoqueRemedio, bulaRemedio, tarjaRemedio;
	@FXML 
	private TextField nomeAcessorio, precoAcessorio, estoqueAcessorio, corAcessorio, tamanhoAcessorio, validadeAcessorio;
	@FXML 
	private Label avisoCadastro, avisoCadastroAnimal, avisoRemover, avisoAtualizar, aviso, produtoToString;	
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
		ScreenManager.getInstance().showProdutoListar();
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
		if(!produtoToString.getText().isEmpty()){
			produtoToString.setText("");
		} if(!aviso.getText().isEmpty()){
			aviso.setText("");
		}
		
			try {				
				
				
				aviso.setText("Produto encontrado no sistema!!!");
				produtoToString.setText(FachadaControlador.getInstance().pesquisar(codigoProduto.getText()).toString());
			} catch (ObjectNaoExisteException e) {
				aviso.setText(e.getMessage());
			
		}
		
		if(!codigoProduto.getText().isEmpty()){
			codigoProduto.setText("");
		}
	}
	
	@FXML
	public void buttonPesquisarProdutoRemover(ActionEvent event){		
		
			try {				
				
					aviso.setText("Produto encontrado no sistema!!!");
					produtoToString.setText(FachadaControlador.getInstance().pesquisar(codigoProduto.getText()).toString());
					buttonRemover.setVisible(true);
				
				
			} catch (ObjectNaoExisteException e) {
				aviso.setText(e.getMessage());
			}
		
		
	}
	
	@FXML
	public void buttonProdutoRemover(ActionEvent event) {
		
			try {
				
				FachadaControlador.getInstance().remover(codigoProduto.getText());
				FachadaControlador.getInstance().salvarNoArquivoProduto();
				
				avisoRemover.setText("Produto removido do sistema!!!");
				buttonRemover.setVisible(false);
			} catch (ObjectNaoExisteException | ErroAoRemoverException e) {
				avisoRemover.setText(e.getMessage());
			}			
		

		if(!codigoProduto.getText().isEmpty()){
			codigoProduto.setText("");
		}

		if(!avisoRemover.getText().isEmpty() || !aviso.getText().isEmpty() 
				|| !produtoToString.getText().isEmpty()){
			avisoRemover.setText("");
			aviso.setText("");
			produtoToString.setText("");
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
						int i=1;
						novoProduto.setCodigo("" + i);
						FachadaControlador.getInstance().cadastrar((Produto)novoProduto);
						FachadaControlador.getInstance().salvarNoArquivoProduto();
								
					avisoCadastroAnimal.setText("Produto cadastrado com sucesso!!");
				 
				} catch (ErroAoSalvarException | ObjectJaExisteException f) {
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
			
		} else if (!avisoCadastro.getText().isEmpty()) {
			avisoCadastro.setText("");
		}
	
	}
		
		
		
		
	
	
	@FXML
	public void buttonCadastrarProdutoRemedio(ActionEvent event) throws ObjectNaoExisteException{
		
		
		
		
	}
	
	@FXML
	public void buttonCadastrarProdutoAcessorio(ActionEvent event) throws ObjectNaoExisteException{
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
