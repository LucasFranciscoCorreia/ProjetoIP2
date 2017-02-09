package br.ufrpe.beans;
import br.ufrpe.beans.Produto;
import java.util.ArrayList;
/**
 * Esta classe representa o carrinho de produtos utilizado na loja.
 * Nela encontra-se dois arrayLists com o nome do produto posto no carrinho
 * e com a quantidade (escolhida pelo cliente) do produto a ser comprado.
 * 
 * @author srtacamelo
 */
public class Carrinho {
	// Um array de produto e outro pra quantidade?
	//Carrinho deve ser singleton?
	//Carrinho pode ser protected (construtor)?
	private ArrayList <Produto> arrayDeProdutos;
	private ArrayList <Integer> arrayDeQuantidade;
	private static Carrinho carrinho;
	
	/**
	 * Construtor de Carrinho, apenas inicializa os dois ArrayLists
	 * caso não haja um carrinho inicializado.
	 * Singleton
	 * 
	 * @param arrayDeProdutos
	 * @param arrayDeQuantidade
	 */
	private Carrinho(){
		
		this.arrayDeProdutos = new ArrayList<Produto>();
		this.arrayDeQuantidade = new ArrayList<Integer>();
	}
	public static Carrinho  getInstance(){
		if(this.carrinho == null){
			this.carrinho = new Carrinho();
		}
		return this.Carrinho();
		
	}
	/**
	 * Este método adicona o produto selecionado do ArrayList de Produtos no carrinho
	 * e sua quantidade do ArrayList de quantidade.
	 * 
	 * @param quantidade
	 * @param produto
	 */
	public void adicionarAoCarrinho(int quantidade, Produto produto){
		this.arrayDeProdutos.add(produto);
		this.arrayDeQuantidade.add(quantidade);
	}
	/**
	 * Este método remove o produto selecionado do ArrayList de Produtos no carrinho
	 * e sua quantidade do ArrayList de quantidade.
	 * 
	 * @param produto
	 */
	
	public void removerDoCarrinho(Produto produto){
		this.arrayDeProdutos.remove(produto);
		this.arrayDeQuantidade.remove(this.arrayDeProdutos.indexOf(produto));
	}

}
