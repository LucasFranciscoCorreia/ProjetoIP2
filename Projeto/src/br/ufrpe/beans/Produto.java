/*
 * Projeto PetShop
 * 
 * Tipo: Produto
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.beans;

import java.io.Serializable;

/**
 * Esta classe representa o basico de um produto, ela é do tipo abstrata, por que não é preciso instanciar um produto
 * em si, mas sim, seu tipo, por exemplo, acessorio. 
 * 
 * @author Diego 
 */
public abstract class Produto implements Serializable, Cloneable{
	private float preco;
	private String nome;
	private String tipo;
	private String codigo;
	private int estoque;	
	private int quantidadeCompra;
	/**
	 * Costrutor do produto (inclui animal vendível)
	 * @param preco
	 * @param nome
	 * @param tipo
	 * @param codigo
	 * @param estoque
	 */
	public Produto(float preco, String nome, String tipo, int estoque) {
		this.preco = preco;
		this.nome = nome;
		this.tipo = tipo;
		this.codigo = null;
		this.estoque = estoque;
	}	
	/**
	 * Construtor pro animal não vendível
	 * @param nome
	 * @param codigo
	 */
	public Produto(String nome, String codigo){ 
		this.nome = nome;
		this.codigo = codigo;
	}

	/**
	 * Adiciona nova quantidade de determinado produto ao estoque
	 * @param qtd
	 */
	public void addEstoque(int qtd){
		int x = this.getEstoque();
		x += qtd;
		this.setEstoque(x);
	}	
	/**
	 * Getters and Setters
	 * @return
	 */
	
	
	
	public float getPreco() {
		return preco;
	}	
	public void setPreco(float preco) {
		this.preco = preco;
	}	
	public String getNome() {
		return nome;
	}	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getEstoque() {
		return estoque;
	}	
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}	
	public String toString(){
		String prod;
		if(tipo == "Serviço"){
			prod = String.format("Nome: %s \nPreço: %.2f\nCodigo %s", nome,preco,codigo);
		}
		prod = String.format("Codigo: %s\nNome: %s \nPreço: %.2f\nEstoque: %d",codigo, nome,preco,estoque);
		return prod;  
	}

	public boolean equals(Object prod) {
		boolean resultado = false;

			Produto p = (Produto) prod;
			if (this.getTipo().equals(p.getTipo()) 
					&& this.getNome().equalsIgnoreCase(p.getNome())){
				resultado = true;
			}	
		
		
		return resultado;	
	}
	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}
	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}
}
