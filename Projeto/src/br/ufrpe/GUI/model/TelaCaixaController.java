package br.ufrpe.GUI.model;

import java.util.ArrayList;

import javax.swing.text.TableView.TableCell;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Acessorio;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Carrinho;
import br.ufrpe.beans.Loja;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Remedio;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.FachadaControlador;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class TelaCaixaController {
    
	@FXML
	private Button cadastrar, atualizar, remover;
	@FXML
	private Label aviso,valorTotal, produtoToString;
	@FXML 
	private TextField codigoVenda, quantidadeVenda, codigoProduto;
	@FXML
	private TableView<Produto> tableCarrinho;
	@FXML
	private TableColumn<Produto, String> codigo;
	@FXML
	private TableColumn<Produto, String> nome;
	@FXML
	private TableColumn<Produto, String> tipo;
	@FXML
	private TableColumn<Produto, Float> preco;
	@FXML
	private TableColumn<Produto, Integer> quantidade;
	@FXML
	private TableColumn<Produto, Produto> delete;
	
	private Carrinho novo = new Carrinho();
	
	@FXML
	public void preencherTabelaCarrinho() {
		
		ArrayList<Produto> carrinhoLista = novo.getArrayDeProdutos();
 
		codigo.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));
		nome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		tipo.setCellValueFactory(new PropertyValueFactory<Produto, String>("tipo"));
		preco.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
		quantidade.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidadeCompra"));
	
			tableCarrinho.setItems(FXCollections.observableArrayList(carrinhoLista));		
			tableCarrinho.refresh();

	}
	
	@FXML	
	public void voltarMenuCaixa(){
		novo.getArrayDeProdutos().clear();
		tableCarrinho.getItems().clear();
		ScreenManager.getInstance().showMenuCaixa();
	}
	
	
	@FXML
	public void buttonAddCarrinho(ActionEvent event){
		
		try {	
            if(!codigoVenda.getText().isEmpty() && !quantidadeVenda.getText().isEmpty()){
            	
            	aviso.setText("");
            	Produto encontrado = FachadaControlador.getInstance().pesquisar(codigoVenda.getText());
    			int quantidade = Integer.parseInt(quantidadeVenda.getText());
    			
    			if(!(novo.Size()<= 0)){
    				for(int i = 0; i<=novo.Size()-1;i++){
    					if(!encontrado.equals(novo.getArrayDeProdutos().get(i)) && i == novo.Size() -1){
    						if(quantidade<=encontrado.getEstoque()){
    							novo.adicionarAoCarrinho(quantidade, encontrado);
    						}else{
    							aviso.setText("Não existe produtos suficientes no estoque");
    						}
    						
    						
    			            break;
    					}else if(encontrado.equals(novo.getArrayDeProdutos().get(i))){
    							
    							if(quantidade<=encontrado.getEstoque()){
    								novo.addMaisAoCarrinho(i, novo.getArrayDeProdutos().get(i), quantidade);
        						}else{
        							aviso.setText("Não existe produtos suficientes no estoque");
        						}
        						break;		
    					}
    				}	
    			}else{
    				if(quantidade<=encontrado.getEstoque()){
						novo.adicionarAoCarrinho(quantidade, encontrado);
					}else{
						aviso.setText("Não existe produtos suficientes no estoque");
					}
	
    			}
    			encontrado = null;
    			
    			valorTotal.setText("Valor Total á pagar: R$ "+novo.valorTotal());
                preencherTabelaCarrinho();		
                  	
            }else{
            	aviso.setText("Preencha todos os campos!!");
            }
            
			
			
		} catch (ObjectNaoExisteException | NullPointerException e) {
			aviso.setText(e.getMessage());
		}
		
	}
	
	@FXML
	public void buttonRealizarCompra(ActionEvent event){		
	          
	        if(tableCarrinho.getItems() != null){
	        	Loja venda = new Loja(null);
	        	try {
					venda.realizarCompra(novo);
					novo.getArrayDeProdutos().clear();
					FachadaControlador.getInstance().salvarNoArquivoProduto();
					aviso.setText("Compra realizada com sucesso");
					tableCarrinho.getItems().clear();
					valorTotal.setText("Valor total a pagar: ");
				} catch (ObjectNaoExisteException e) {
					
					e.printStackTrace();
				}
	        }else{
	        	aviso.setText("Nenhum produto no carrinho!!");
	        }
	

	}
	
	@FXML
	public void buttonRemoverCarrinho(ActionEvent event){
		
		Produto selecionado = tableCarrinho.getSelectionModel().getSelectedItem();
		
		if(selecionado != null){
			for(int i = 0; i<=novo.getArrayDeProdutos().size()-1;i++){
				if(selecionado.equals(novo.getArrayDeProdutos().get(i))){
					if(novo.getArrayDeProdutos().get(i).getQuantidadeCompra()==1){
						novo.removerDoCarrinho(selecionado);
					}
					else{
						novo.removeMaisDoCarrinho(selecionado, 1);
					}
					
				}
			}
		}
		
		preencherTabelaCarrinho();
		valorTotal.setText("Valor Total á pagar: R$ "+novo.valorTotal());
	}
	
	
	
	
	
}
