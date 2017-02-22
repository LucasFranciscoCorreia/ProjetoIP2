package br.ufrpe.beans;


import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * Esta classe representa o carrinho de produtos utilizado na loja.
 * Nela encontra-se dois arrayLists com o nome do produto posto no carrinho
 * e com a quantidade (escolhida pelo cliente) do produto a ser comprado.
 * 
 * @author srtacamelo
 */
public class Carrinho {
	private ArrayList <Produto> arrayDeProdutos;
	
	/**
	 * Construtor de Carrinho, apenas inicializa os dois ArrayLists
	 * caso não haja um carrinho inicializado.
	 * Singleton
	 * 
	 * @param arrayDeProdutos
	 * @param arrayDeQuantidade
	 */
	public Carrinho(){
		
		this.arrayDeProdutos = new ArrayList<>();	
	}
	
	public int Size(){
		return this.getArrayDeProdutos().size();
	}
	/**
	 * Getters and Setters
	 * @return
	 */
	public ArrayList<Produto> getArrayDeProdutos() {
		return arrayDeProdutos;
	}

	public void setArrayDeProdutos(ArrayList<Produto> arrayDeProdutos) {
		this.arrayDeProdutos = arrayDeProdutos;
	}


	/**
	 * Este método adicona o produto selecionado do ArrayList de Produtos no carrinho
	 * e sua quantidade do ArrayList de quantidade.
	 * 
	 * @param quantidade
	 * @param produto
	 */
	public void adicionarAoCarrinho(int quantidade, Produto produto){
		produto.setQuantidadeCompra(produto.getQuantidadeCompra()+quantidade);
		this.arrayDeProdutos.add(produto);
	}
	/**
	 * Este método remove o produto selecionado do ArrayList de Produtos no carrinho
	 * e sua quantidade do ArrayList de quantidade.
	 * 
	 * @param produto
	 */
	
	public void removerDoCarrinho(Produto produto){
		produto.setQuantidadeCompra(0);
		this.arrayDeProdutos.remove(produto);
		
	}
	/**
	 * Este método altera a quantidade de determinado item no carrinho, aumentando
	 * @param produto
	 * @param quantidade
	 */	
	
	//Se eu fizer um botão pra diminuir e aumentar a quantidade de um produto, como passo a informação
	//pra modificar a quantidade, e quando? (ao confirmar a compra, antes de remover do estoque)?
	
	//As funções que munipulam o carrinho deveriam estar na Classe loja, ao invés daqui?
	
	public void addMaisAoCarrinho(int i, Produto produto, int quantidade){
		
		produto.setQuantidadeCompra( produto.getQuantidadeCompra() + quantidade);
	}
	
	/**
	 * Este método altera a quantidade de determinado item no carrinho, diminuindo 
	 * @param produto
	 * @param quantidade
	 */
	public void removeMaisDoCarrinho(Produto produto, int quantidade){
		
		
		produto.setQuantidadeCompra(produto.getQuantidadeCompra()-quantidade);
	}
	
	public double valorTotal(){
		double resul = 0;
		for(int i=0; i<=this.Size()-1;i++){
			resul += this.getArrayDeProdutos().get(i).getPreco() * this.getArrayDeProdutos().get(i).getQuantidadeCompra();
		}
		return resul;
	}
	

	/**
	 * Método ToString();
	 */
	@Override
	public String toString() {
		return "Comprou:\n" + arrayDeProdutos;
	}
	

}