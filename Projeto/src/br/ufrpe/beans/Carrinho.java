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
	// TODO  Dúvidas: Um array de produto e outro pra quantidade?
	//Carrinho pode ser protected (construtor)?
	//Precisa de Get e set pro carrinho? se ja tem adicionar e remover
	
	private ArrayList <Produto> arrayDeProdutos;
	private ArrayList <Integer> arrayDeQuantidade;
	private LocalDateTime dataCompra;
	/**
	 * Construtor de Carrinho, apenas inicializa os dois ArrayLists
	 * caso não haja um carrinho inicializado.
	 * Singleton
	 * 
	 * @param arrayDeProdutos
	 * @param arrayDeQuantidade
	 */
	public Carrinho(){
		
		this.arrayDeProdutos = new ArrayList<Produto>();
		this.arrayDeQuantidade = new ArrayList<Integer>();
		this.dataCompra = LocalDateTime.now();
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

	public ArrayList<Integer> getArrayDeQuantidade() {
		return arrayDeQuantidade;
	}

	public void setArrayDeQuantidade(ArrayList<Integer> arrayDeQuantidade) {
		this.arrayDeQuantidade = arrayDeQuantidade;
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
	/**
	 * Este método altera a quantidade de determinado item no carrinho, aumentando
	 * @param produto
	 * @param quantidade
	 */
	//TODO Dúvida: está certo colocar o index do arraylist de produtos?
	// Dado que o indice é o mesmo do arrayDeQuantidade pro mesmo produto
	//
	//Ao invés de ter duas funções (addMaisAoCarrinho e removeMaisDoCarrinho
	//poderia ter uma única função que alterasse o valor da quantidade (somando),
	//passando como parametro um número negativo ou positivo para remover e acrescentar, respectivamente
	
	//Se eu fizer um botão pra diminuir e aumentar a quantidade de um produto, como passo a informação
	//pra modificar a quantidade, e quando? (ao confirmar a compra, antes de remover do estoque)?
	
	//As funções que munipulam o carrinho deveriam estar na Classe loja, ao invés daqui?
	
	public void addMaisAoCarrinho(Produto produto, int quantidade){
		
		int index = arrayDeProdutos.indexOf(produto);
		this.arrayDeQuantidade.set(index, this.arrayDeQuantidade.get(index)+ quantidade);
	}
	
	/**
	 * Este método altera a quantidade de determinado item no carrinho, diminuindo 
	 * @param produto
	 * @param quantidade
	 */
	public void removeMaisDoCarrinho(Produto produto, int quantidade){
		
		int index = arrayDeProdutos.indexOf(produto);
		this.arrayDeQuantidade.set(index, this.arrayDeQuantidade.get(index)- quantidade);
	}
	

}