package br.ufrpe.GUI.model;

import java.util.ArrayList;

import javax.swing.text.TableView.TableCell;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Acessorio;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Carrinho;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Remedio;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.FachadaControlador;
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
	private Label aviso,valorTotal;
	@FXML 
	private TextField codigoVenda, quantidadeVenda;
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
	private TableColumn<Integer, Integer> quantidade;
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
//		quantidade.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("quantidade"));
		
		
		tableCarrinho.setItems(FXCollections.observableArrayList(carrinhoLista));
		tableCarrinho.refresh();

	}
	
	@FXML	
	public void voltarMenuCaixa(){
		novo = null;
		ScreenManager.getInstance().showMenuCaixa();
	}
	
	@FXML
	public void buttonAddCarrinho(ActionEvent event){
		
		try {	
            if(!codigoVenda.getText().isEmpty() && !quantidadeVenda.getText().isEmpty()){
            	
            	
            	Produto encontrado = FachadaControlador.getInstance().pesquisar(codigoVenda.getText());
    			int quantidade = Integer.parseInt(quantidadeVenda.getText());
    			
    			if(!(novo.Size()<= 0)){
    				for(int i = 0; i<=novo.Size()-1;i++){
    					if(!encontrado.equals(novo.getArrayDeProdutos().get(i))){
    						novo.adicionarAoCarrinho(quantidade, encontrado);
    						
    			            break;
    					}else{
    							novo.addMaisAoCarrinho(i, novo.getArrayDeProdutos().get(i), quantidade);
    							
        						break;
    						
    						
    					}
    				}	
    			}else{
    				novo.adicionarAoCarrinho(quantidade, encontrado);
	
    			}
    			encontrado = null;
    			aviso.setText("OK");
    			valorTotal.setText("R$ "+novo.valorTotal());
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
	}
	
	@FXML
	public void buttonRemoverCarrinho(ActionEvent event){
		
		Produto selecionado = tableCarrinho.getSelectionModel().getSelectedItem();
		
		if(selecionado != null){
			for(int i = 0; i<=novo.getArrayDeProdutos().size()-1;i++){
				if(selecionado.equals(novo.getArrayDeProdutos().get(i))){
					if(novo.getArrayDeQuantidade().get(i)==1){
						novo.removerDoCarrinho(selecionado);
					}
					else{
						novo.removeMaisDoCarrinho(selecionado, 1);
					}
					
				}
			}
		}
		
		preencherTabelaCarrinho();
		valorTotal.setText("R$ "+novo.valorTotal());
	}
	
	
	
	
	
}
