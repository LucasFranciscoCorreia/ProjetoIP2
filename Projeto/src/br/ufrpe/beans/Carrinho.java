package br.ufrpe.beans;
import br.ufrpe.beans.Produto;
import java.util.ArrayList;
public class Carrinho {
	// Um array de produto e outro pra quantidade?
	//Carrinho deve ser singleton?
	
	private ArrayList <Produto> arrayDeProdutos;
	private ArrayList <Integer> arrayDeQuantidade;
	
	public Carrinho(){
		
		this.arrayDeProdutos = new ArrayList<Produto>();
		this.arrayDeQuantidade = new ArrayList<Integer>();
	}
	
	public void adicionarAoCarrinho(int quantidade, Produto produto){
		this.arrayDeProdutos.add(produto);
		this.arrayDeQuantidade.add(quantidade);
	}
	
	public void removerDoCarrinho(Produto produto){
		this.arrayDeProdutos.remove(produto);
		this.arrayDeQuantidade.remove(this.arrayDeProdutos.indexOf(produto));
	}
}
